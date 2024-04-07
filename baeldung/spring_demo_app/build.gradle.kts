plugins {
	application
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "baeldung"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	// Main Spring Boot, JPA and Hibernate deps
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

    // https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-community-dialects
    implementation("org.hibernate.orm:hibernate-community-dialects")

	// JDBC drivers - needed only at runtime
    runtimeOnly("org.xerial:sqlite-jdbc")
	// runtimeOnly("com.mysql:mysql-connector-j")
	// runtimeOnly("org.postgresql:postgresql")

	// Test deps
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// TODO: Adding tests to the main build fails for now
// tasks.withType<Test> {
// 	useJUnitPlatform()
// }

application {
    // Define the main class for the application.
    mainClass.set("baeldung.spring_demo_app.App")
}
