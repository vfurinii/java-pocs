#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
AVAJE_DIR="$ROOT_DIR/avaje-inject-poc"
SPRING_DIR="$ROOT_DIR/springboot-inject-poc"
BROKER_DIR="$AVAJE_DIR"
BROKER_MANAGED_BY_SCRIPT=0

start_broker() {
  if docker ps --format '{{.Ports}}' | rg -q '9092->9092'; then
    echo "== broker already running on 9092 =="
    echo
    return
  fi

  echo "== starting broker =="
  (
    cd "$BROKER_DIR"
    docker compose up -d
  ) >/dev/null
  BROKER_MANAGED_BY_SCRIPT=1
  echo
}

stop_broker() {
  if [[ "$BROKER_MANAGED_BY_SCRIPT" -ne 1 ]]; then
    return
  fi

  echo "== stopping broker =="
  (
    cd "$BROKER_DIR"
    docker compose down
  ) >/dev/null
  echo
}

measure_build() {
  local project_dir="$1"
  local label="$2"
  echo "== $label build =="
  (
    cd "$project_dir"
    /usr/bin/time -p mvn -q -DskipTests package
  ) 2>&1 | tee "$ROOT_DIR/.${label// /_}_build.log"
  echo
}

run_consumer_and_producer() {
  local project_dir="$1"
  local label="$2"

  echo "== $label runtime =="

  local consumer_log="$ROOT_DIR/.${label// /_}_consumer.log"
  local producer_log="$ROOT_DIR/.${label// /_}_producer.log"
  : > "$consumer_log"
  : > "$producer_log"

  (
    cd "$project_dir"
    mvn -q -Dexec.mainClass=notification.service.Main exec:java
  ) >"$consumer_log" 2>&1 &
  local consumer_pid=$!

  trap 'kill "$consumer_pid" 2>/dev/null || true' RETURN

  sleep 8

  (
    cd "$project_dir"
    mvn -q -Dexec.mainClass=org.order.api.Main exec:java
  ) >"$producer_log" 2>&1

  sleep 3
  kill "$consumer_pid" 2>/dev/null || true
  wait "$consumer_pid" 2>/dev/null || true
  trap - RETURN

  echo "-- consumer timing --"
  rg -n "ready in|Order received|Avaje consumer ready|Spring Boot consumer ready" "$consumer_log" || true
  echo "-- producer timing --"
  rg -n "ready in|completed in|Event published|Spring Boot producer" "$producer_log" || true
  echo
}

trap stop_broker EXIT

start_broker

measure_build "$AVAJE_DIR" "avaje"
run_consumer_and_producer "$AVAJE_DIR" "avaje"

measure_build "$SPRING_DIR" "springboot"
run_consumer_and_producer "$SPRING_DIR" "springboot"
