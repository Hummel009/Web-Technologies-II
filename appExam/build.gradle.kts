plugins {
	id("java")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}

group = "hummel"
version = "1.0-SNAPSHOT"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
	implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")

	compileOnly("org.apache.tomcat.embed:tomcat-embed-jasper")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

tasks {
	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}
}
