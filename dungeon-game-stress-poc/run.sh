#!/bin/bash

echo "Building Stress Test project..."
./mvnw clean install

echo "Starting Project..."
docker-compose build
docker-compose up