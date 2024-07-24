import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("java")
	id("application")
}

group = "com.github.hummel"
version = LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:latest.release")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

application {
	mainClass = "com.github.hummel.wt.lab1.task9.Task9"
}

tasks {
	named<JavaExec>("run") {
		standardInput = System.`in`
	}
	test {
		useJUnitPlatform()
	}
	jar {
		manifest {
			attributes(
				mapOf(
					"Main-Class" to "by.bsuir.hummel.lab1.task9.Main"
				)
			)
		}
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	}
	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}
}
