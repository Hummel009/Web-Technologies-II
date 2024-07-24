plugins {
	id("java")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}

group = "com.github.hummel"
version = "1.0-SNAPSHOT"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-test")

	implementation("jakarta.servlet:jakarta.servlet-api:latest.release")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:latest.release")
	implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:latest.release")
	compileOnly("org.apache.tomcat.embed:tomcat-embed-jasper")

	implementation("com.mysql:mysql-connector-j:latest.release")

}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
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
