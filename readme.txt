Создание серверной архитектуры для многопользовательской игры-шутера с использованием Spring Boot, REST API и Kafka — интересная задача.
Ниже представлено детальное техническое задание, проект с реализацией кода и инструкции по настройке Kafka.

[Creating a server architecture for a multiplayer shooter game using Spring Boot, REST API, and Kafka is an interesting task.
Below is a detailed technical specification, a project with code implementation, and instructions for configuring Kafka.]

Техническое задание
1. Описание системы
Проект состоит из двух микросервисов:

Сервер статистики (Microservice1): аккумулирует и предоставляет статистику по результатам матчей.
Генератор матчей (Microservice2): отправляет результаты матчей в Kafka.
2. Функциональные требования
Сервер статистики (Microservice1) должен реализовывать следующие функции:

Получать результаты матчей из Kafka.
Хранить статистику о матчах и игроках.
Предоставлять RESTful API для запроса статистики.

[Technical Specification
1. System Description
The project consists of two microservices:

Statistics Server (Microservice1): Accumulates and provides statistics on match results.
Match Generator (Microservice2): Sends match results to Kafka.
2. Functional Requirements
The Statistics Server (Microservice1) must implement the following functions:

Receive match results from Kafka.
Store statistics about matches and players.
Provide a RESTful API for querying statistics]

REST API Методы:

GET /servers/{endpoint}/info: Получить информацию о сервере.
GET /servers/{endpoint}/matches/{timestamp}: Получить матчи с указанной меткой времени.
GET /servers/info: Получить информацию о всех серверах.
GET /servers/{endpoint}/stats: Получить статистику по серверу.
GET /players/{name}/stats: Получить статистику по игроку.
GET /reports/recent-matches[/{count}]: Получить недавние матчи (по умолчанию 10).
GET /reports/best-players[/{count}]: Получить лучших игроков (по умолчанию 10).
GET /reports/popular-servers[/{count}]: Получить самые популярные серверы (по умолчанию 10).
3. Непосредственные задачи
Реализовать микросервис для статистики с использованием Spring Boot и Kafka.
Настроить Kafka для обработки сообщений.
Создать REST API для взаимодействия с пользователем.

[REST API Methods:
GET /servers/{endpoint}/info: Get information about a specific server.
GET /servers/{endpoint}/matches/{timestamp}: Get matches with a given timestamp.
GET /servers/info: Get information about all servers.
GET /servers/{endpoint}/stats: Get statistics for a specific server.
GET /players/{name}/stats: Get statistics for a specific player.
GET /reports/recent-matches[/{count}]: Get recent matches (default 10).
GET /reports/best-players[/{count}]: Get the top players (default 10).
GET /reports/popular-servers[/{count}]: Get the most popular servers (default 10).
3. Immediate Tasks
Implement a statistics microservice using Spring Boot and Kafka.
Configure Kafka to process messages.
Create a REST API for user interaction.]

microservice1-statistics
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── statistics
│   │   │               ├── StatisticsApplication.java
│   │   │               ├── controller
│   │   │               │   └── StatisticsController.java
│   │   │               ├── service
│   │   │               │   └── StatisticsService.java
│   │   │               ├── model
│   │   │               │   └── MatchResult.java
│   │   │               └── config
│   │   │                   └── KafkaConfig.java
│   │   └── resources
│   │       └── application.yml
├── build.gradle
└── settings.gradle
