#!/bin/bash
set -e

# docker build
echo "Step 1. docker build"
sudo docker build -t deploy:0.0.1 .

# docker run
echo "Step 1. docker run"
sudo docker run -d -p 9191:9191 deploy:0.0.1
