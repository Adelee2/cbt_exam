# CBT Exam using JBOSS EAP
- ``A robust CBT Exam system for mcq,theoretical questions and german.``

## Tools
- Message Broker(Active MQ) which serves as load leveling
- Levenshtein distance algorithm to calculate the degree of closeness to actual answer (applicable to theory)
- JPA like ORM in Spring Boot
- Wildfly Server
- MySql
- JDK 11
- EJB
- MDB
- Maven
- Docker (Todo)

### How to run it
```Be sure you have wildfly server installed with mysql driver```
- Add the cbt jms-queue to the standalone-full.xml file
- Add the PortalDS(mysql Data Source to the standalone-full.xml file
- Run ``mvn clean install`` to generate the war file
- move the war file to the ``/wildfly/standalone/deployments`` folder
- open terminal at the ``bin`` folder in the wildfly and run ``./standalone.sh -c standalone-full.xml`` to start the server
