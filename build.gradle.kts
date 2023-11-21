import org.jetbrains.gradle.ext.Gradle
import org.jetbrains.gradle.ext.RunConfigurationContainer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("org.jetbrains.kotlin.jvm") version "1.9.20"
	id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
	id("com.gtnewhorizons.retrofuturagradle") version "1.3.24"
}

group = "hummel"
version = "v" + LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

val embed: Configuration by configurations.creating

dependencies {
	embed("org.jetbrains.kotlin:kotlin-stdlib:1.9.20")
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(8))
	}
}

minecraft {
	mcVersion.set("1.7.10")
	username.set("Hummel009")
}

idea {
	project {
		this.withGroovyBuilder {
			"settings" {
				"runConfigurations" {
					val self = this.delegate as RunConfigurationContainer
					self.add(
						Gradle("1. Run Client").apply {
							setProperty("taskNames", listOf("runClient"))
						},
					)
					self.add(
						Gradle("2. Run Server").apply {
							setProperty("taskNames", listOf("runServer"))
						},
					)
				}
			}
		}
	}
}

tasks {
	jar {
		manifest {
			attributes(
				mapOf(
					"Main-Class" to "genst.GenstPatchKt"
				)
			)
		}
		from(embed.map {
			if (it.isDirectory) it else zipTree(it)
		})
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	}
}
