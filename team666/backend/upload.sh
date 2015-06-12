#!/bin/bash
for f in "$@"
do
  echo "Processing $f file..."
  curl -i -F file=@$f http://localhost:8080/process
done
