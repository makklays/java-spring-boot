package org.example;

// Для запуска приложения выполняем (из корня приложения):
// mvn spring-boot:run


// @EnableAutoConfiguration. Эта аннотация сообщает Spring Boot, что необходимо "угадать", как нужно сконфигурировать
//  @EnableAutoConfiguration is already include to @SpringBootApplication annotation
// Spring, основываясь на добавленных вами jar-зависимостях. Поскольку spring-boot-starter-web добавил Tomcat и
// Spring MVC, средство автоконфигурирования предполагает, что вы разрабатываете веб-приложение, и настраивает Spring
// соответствующим образом.