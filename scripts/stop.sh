#!/usr/bin/env bash
set -euo pipefail
# Stop and remove the stack
if command -v docker-compose >/dev/null 2>&1; then
  docker-compose down
else
  docker compose down
fi
