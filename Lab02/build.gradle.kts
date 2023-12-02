plugins {
	id("java")
	id("war")
}

group = "hummel"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))
	implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
	implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")
	implementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
	implementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
	implementation("com.mysql:mysql-connector-j:8.2.0")
	implementation("ch.qos.logback:logback-classic:1.4.11")
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
