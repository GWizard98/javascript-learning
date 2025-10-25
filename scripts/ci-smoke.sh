#!/usr/bin/env bash
set -euo pipefail

retry() {
  local n=0
  local max=60
  local delay=2
  until "$@"; do
    n=$((n+1))
    if [ $n -ge $max ]; then
      echo "Command failed after $n attempts: $*" >&2
      return 1
    fi
    sleep $delay
  done
}

echo "Waiting for backend-java health..."
retry curl -sf http://localhost:8080/actuator/health > /dev/null

echo "Waiting for micro-js ping..."
retry curl -sf http://localhost:3000/micro/ping > /dev/null

echo "Smoke: Java hello"
curl -sf http://localhost:8080/api/hello | tee /tmp/java_hello.json >/dev/null

echo "Smoke: Micro proxy to Java"
curl -sf http://localhost:3000/micro/java-hello | tee /tmp/micro_java_hello.json >/dev/null

echo "OK: smoke tests passed"
