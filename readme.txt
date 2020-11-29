1. clean Compile >> mvn clean install
2. on successful compile 
3.select Target folder and run command 
java -jar spring-data-jpa-1.0.jar

4. upload inmemory database :
http://localhost:8080/myTest/loadmasterdata

5. GET command for different use case :
http://localhost:8080/myTest/serviceaudit?serviceName=null&moduleName=Find&envName=QA
http://localhost:8080/myTest/serviceaudit?serviceName=null&moduleName=null&envName=QA
http://localhost:8080/myTest/serviceaudit/history?serviceName=null&moduleName=null&envName=abc

Post Command :
http://localhost:8080/myTest/servicecurrent?serviceName=Find&branchName=MIL&envName=DOT
http://localhost:8080/myTest/servicecurrent?serviceName=Find&branchName=MIL&envName=QA



