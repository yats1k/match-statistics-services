# Getting Started
Project Description
Creation of two microservices for a multiplayer shooter game:

Statistics Server (microservice1): This service will accumulate match results sent by game servers via Kafka, and provide a RESTful API for retrieving statistics on matches, players, and servers.
Statistics Generator (microservice2): The exact function of this microservice is not explicitly stated in the Russian text. However, based on its name, it can be inferred that it might be responsible for generating statistical data or processing it in a specific way.
Possible interpretations for Statistics Generator:

Generating sample data: It could create synthetic data for testing purposes or to populate the database initially.
Performing complex calculations: It might handle more intricate statistical calculations, such as calculating player rankings or generating heatmaps.
Triggering specific actions based on statistics: For example, it could send notifications or trigger game events when certain statistical thresholds are met.
Overall, the project involves building a distributed system to collect, store, and process game statistics.

More Contextual Translation:
A more detailed translation with additional context might look like this:

Project Overview:

We are developing a microservices-based architecture for a multiplayer shooter game. This architecture will include two primary services:

Statistics Server: This service will act as a central repository for all game match data. Game servers will send match results to this service via the Kafka messaging system. The Statistics Server will expose a RESTful API that can be used to query for various statistics, such as player performance, match outcomes, and server load.

Statistics Generator: The exact role of this service will be defined in more detail, but it is expected to handle tasks related to processing raw statistical data. This might involve generating derived statistics, performing complex calculations, or triggering actions based on statistical patterns.

Key Goals:

Scalability: The system should be able to handle a large volume of data and a growing number of players.
Reliability: The system should be highly available and fault-tolerant.
Performance: Query response times should be fast to ensure a smooth user experience.
Flexibility: The system should be easy to extend and modify to accommodate new features or game mechanics.
Note: The specific functionality of the Statistics Generator will depend on the exact requirements of the game and the desired level of statistical analysis.

Would you like me to provide more information or answer any specific questions about this project?
### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin/packaging-oci-image.html)
* [Spring Integration JPA Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jpa.html)
* [Spring Integration Test Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/testing.html)
* [Spring Integration Apache Kafka Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/kafka.html)
* [Spring Integration Security Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/security.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#actuator)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Integration](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#messaging.spring-integration)
* [Jersey](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web.servlet.jersey)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#messaging.kafka)
* [Apache Kafka Streams Support](https://docs.spring.io/spring-kafka/docs/current/reference/html/#streams-kafka-streams)
* [Apache Kafka Streams Binding Capabilities of Spring Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/index.html#_kafka_streams_binding_capabilities_of_spring_cloud_stream)
* [OAuth2 Authorization Server](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web.security.oauth2.authorization-server)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web.security.oauth2.client)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web.security.oauth2.server)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web.security)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Validation](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#io.validation)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Integrating Data](https://spring.io/guides/gs/integration/)
* [Samples for using Apache Kafka Streams with Spring Cloud stream](https://github.com/spring-cloud/spring-cloud-stream-samples/tree/master/kafka-streams-samples)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

