import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("java")
	id("application")
}

group = "hummel"
version = "v" + LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

repositories {
	mavenCentral()
}

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
	testImplementation(project(":"))
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

application {
	mainClass = "by.bsuir.hummel.lab1.task9.Main"
}

tasks {
	test {
		useJUnitPlatform()
	}
	jar {
		manifest {
			attributes(mapOf("Main-Class" to "by.bsuir.hummel.lab1.task9.Main"))
		}
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	}
}