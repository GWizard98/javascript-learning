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

# Secure endpoint should be 401 without token
code=$(curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/api/secure/hello || true)
if [ "$code" != "401" ]; then
  echo "Expected 401 for secure endpoint without token, got $code" >&2
  exit 1
fi

echo "OK: smoke tests passed"
