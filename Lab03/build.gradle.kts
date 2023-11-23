plugins {
	id("java")
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "hummel"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
	implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")
	implementation("com.mysql:mysql-connector-j:8.2.0")

	implementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
	implementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")

	compileOnly("org.apache.tomcat.embed:tomcat-embed-jasper")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

tasks {
	test {
		useJUnitPlatform()
	}
	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}
}
