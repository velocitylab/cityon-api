#!/usr/bin/env bash

RELEASE_VERSION=$(git describe --tags $(git rev-list --tags --max-count=1))
echo RELEASE_VERSION=${RELEASE_VERSION}

echo "# push image..."
docker push velocitylab/cityon-api:${RELEASE_VERSION}
docker tag velocitylab/cityon-api:${RELEASE_VERSION} velocitylab/cityon-api:latest
docker push velocitylab/cityon-api:latest