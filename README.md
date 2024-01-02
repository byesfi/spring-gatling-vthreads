
# Spring Boot with Gatling Performance Testing and Virtual Threads
This project aims to measure the performance difference in a Spring Boot 3.2 application when using Virtual Threads, a feature introduced in Java 21.
By toggling the `spring.threads.virtual.enabled` property, the springboot enables or disables Virtual Threads.

## How to Run

1. **Clone the Repository:**
```bash
git clone https://github.com/byesfi/spring-gatling-vthreads.git
cd spring-gatling-vthreads
```

2. **Set Virtual Threads Properties:**\
Configure the **`spring.threads.virtual.enabled`** property in `application.properties` file, 
setting it to **`true`** or **`false`** to respectively activate or deactivate virtual threads.\
Additionally, you can adjust the maximum number of Tomcat threads to observe its impact on performance.
Change the **`server.tomcat.threads.max`** property to a desired limit. The default is set to 10. \
**Note** that the **`/hello/{name}`** endpoint includes a deliberate 1-second sleep to simulate some processing time.

```properties
spring.threads.virtual.enabled=true
server.tomcat.threads.max=10

```
3. **Run the Gatling test:**
```bash
mvn clean gatling:test  # or use 'mvnw.cmd' on Windows
```

## Analysis
Review the generated Gatling reports in the **target/gatling** directory for each run.
Compare the performance metrics and observe the impact of Virtual Threads.

## Requirements
Ensure Java 21 is installed on your machine.


## Acknowledgment
The concept was initially inspired [by this repo](https://github.com/olegonsoftware/boot-vt-benchmark). 
Many thanks to @olegonsoftware for sharing this valuable resource!
