#!/usr/bin/env bash
set -euo pipefail
# Build and run the Java + JS services via Docker Compose
# Why: provide a zero-install quickstart that works the same on any machine.

# Ensure compose v2 command works across environments
if command -v docker-compose >/dev/null 2>&1; then
  docker-compose up --build
else
  docker compose up --build
fi
