import { check } from 'k6';
import http from 'k6/http';

export let options = {
  vus: 10,
  duration: '30s',
};

export default function () {
  // 1) GET request
  let res = http.get('http://localhost:8080/v1/dungeons');
  check(res, { 'status was 200': (r) => r.status === 200 });

  // 2) POST request
  const url = 'http://localhost:8080/v1/dungeons';
  const payload = JSON.stringify({
    dungeon: [
      [3, 4, -2],
      [9, 3, -1],
      [2, -9, 3]
    ]
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  let postRes = http.post(url, payload, params);
  check(postRes, { 'POST status was 200': (r) => r.status === 200 });
}

//https://vitormfurini.grafana.net/a/k6-app/runs/5392041