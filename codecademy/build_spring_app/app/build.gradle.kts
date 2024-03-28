/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.3/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework
    testImplementation("junit:junit:4.13.2")   

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.4")

    // This dependency is used by the application.
    // TODO: Do we still need this dependency?
    implementation("com.google.guava:guava:32.1.1-jre")

    // NOTE: Needed explicitly for use with 'Hibernate'
    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:2.2.224")

    // https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
    implementation("org.xerial:sqlite-jdbc:3.45.2.0")

    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.3.0")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter
    implementation("org.springframework.boot:spring-boot-starter:3.2.4")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.4")

    // https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager
    implementation("org.hibernate:hibernate-entitymanager:5.6.15.Final")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
    // NOTE: Spring Data JPA (JPA - Java Persistence API) which uses 'Hibernate' ORM, but doesn't pull it as a dependency!
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.4")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("build_spring_app.App")
}
