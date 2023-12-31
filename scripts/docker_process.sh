#!/bin/bash

name_image="ec2_spring_boot"

docker stop $(docker ps -q --filter name=$name_image)
docker rm $(docker ps -aq --filter name=$name_image)

cd ../

docker build -t $name_image .
docker run -e PORT_APP=$PORT_APP -e URL_API_ANIME=$URL_API_ANIME -d -p 9000:$PORT_APP --name $name_image $name_image