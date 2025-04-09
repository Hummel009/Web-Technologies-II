import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("java")
	id("application")
}

group = "com.github.hummel"
version = LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

dependencies {
	val junitBom = platform("org.junit:junit-bom:latest.release")
	testImplementation(junitBom)
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
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
