# Distributed-Content-Searching-UOM

* Based on : [Distributed Content Searching](https://github.com/Sathiyakugan/Distributed-Content-Searching)
* Transform to a REST full web service with Swagger 


## Steps to run
* extract the zip 
* move to extract directory 
* To run the client jar use the below 2 options:

##### option 1
* Run below commands in the shell 
```shell script
cd Distributed-Content-Searching-UOM
java -cp BootstrapServer/Java/: BootstrapServer # In windows os java -cp BootstrapServer/Java/; BootstrapServer
path="distributed-content-searching-node/target/*.jar"
mvn clean install -DskipTest
java -jar $path --server.port=<port to up the appliation >
```
##### example
```shell script
$ java -jar distributed-content-searching-node-0.0.1-SNAPSHOT.jar --server.port=8084
```

##### option 2
* if you have installed konsole run the run.sh script
* provide the number of nodes required as a argument 
```shell script
sh run.sh <number of node>
``` 
##### example
```shell script
sh run.sh 1
```

##### Swagger url 
```html
http://localhost:<port>/swagger-ui.html
```
##### example
```shell script
http://localhost:8084/swagger-ui.html
```
