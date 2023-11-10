import net.minecraftforge.gradle.user.UserExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.LocalDate
import java.time.format.DateTimeFormatter

buildscript {
	repositories {
		mavenCentral()
		maven {
			name = "forge"
			url = uri("https://maven.minecraftforge.net/")
		}
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
		classpath("com.anatawa12.forge:ForgeGradle:1.2-1.1.+") {
			isChanging = true
		}
	}
}

apply(plugin = "forge")
apply(plugin = "kotlin")

plugins {
	id("java")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(8)
	}
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

group = "org.example"
version = "v" + LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

val Project.minecraft: UserExtension
	get() = extensions.getByName<UserExtension>("minecraft")

minecraft.version = "1.7.10-10.13.4.1614-1.7.10"

configure<UserExtension> {
	replacements["@version@"] = project.version
	runDir = "run"
}

val embed: Configuration by configurations.creating

dependencies {
	embed("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.20")
}

tasks {
	jar {
		manifest {
			attributes(mapOf("Main-Class" to "genst.GenstPatchKt"))
		}
		from(embed.map {
			if (it.isDirectory) it else zipTree(it)
		})
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	}
	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
		}
	}
}