import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("org.jetbrains.kotlin.jvm") version "1.9.21"
	id("com.gtnewhorizons.retrofuturagradle") version "1.3.24"
}

group = "hummel"
version = "v" + LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

val embed: Configuration by configurations.creating

dependencies {
	embed("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(8)
	}
}

minecraft {
	mcVersion = "1.7.10"
	username = "Hummel009"
}

val unzipArchive: Copy by tasks.register<Copy>("unzipArchive") {
	val destinationDir = file("build/rfg/minecraft-src")
	from(zipTree("libs/lotr.zip"))
	into(destinationDir)
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
	setupDecompWorkspace {
		finalizedBy(unzipArchive)
	}
}