#!/bin/bash
n=$1
mvn clean install -DskipTests;
path="distributed-content-searching-node/target/*.jar"
port=8080
konsole --new-tab -e java -Xms10M -Xmx10M -cp BootstrapServer/Java/: BootstrapServer &
for (( i = 1; i <= $n; i++ )); do
    echo $path;
    p=`expr $port + $i`;
    konsole --new-tab -e java -Xms10M -Xmx20M -jar $path --server.port=$p &
    sleep 10
done
