import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("java")
	id("application")
}

group = "hummel"
version = "v" + LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

application {
	mainClass = "by.bsuir.hummel.lab1.task9.Task9"
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
					"Main-Class" to "by.bsuir.hummel.lab1.task9.Task9"
				)
			)
		}
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	}
	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}
}
