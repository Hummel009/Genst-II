package genst

import java.io.File
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

fun main() {
	val searchPath = File(System.getProperty("user.dir"))
	val lotrClassPath = "lotr/common/LOTRMod.class"
	val patchPaths = setOf(
		"lotr/common/world/LOTRWorldChunkManager.class",
		"lotr/common/world/biome/LOTRBiomeDecorator.class",
		"lotr/common/world/biome/LOTRBiomeDecorator\$OreGenerant.class",
		"lotr/common/world/biome/LOTRBiomeDecorator\$RandomStructure.class",
		"lotr/common/world/village/LOTRVillageGen.class",
		"lotr/common/world/village/LOTRVillageGen\$StructureInfo.class",
		"lotr/common/world/village/LOTRVillageGen\$AbstractInstance.class"
	)

	val jarFiles = searchPath.listFiles { file -> file.isFile && file.extension == "jar" }
	for (jarFile in jarFiles ?: return) {
		if (jarContainsEntry(jarFile, lotrClassPath)) {
			val tempJarFile = File.createTempFile("temp_", ".jar")
			editJarFile(jarFile, tempJarFile, patchPaths)
			jarFile.delete()
			tempJarFile.renameTo(jarFile)
			println("Файлы удалены из JAR-файла: ${jarFile.name}")
		}
	}
}

fun jarContainsEntry(jarFile: File, entryPath: String): Boolean {
	JarFile(jarFile).use { jar ->
		val entries = jar.entries()
		while (entries.hasMoreElements()) {
			val entry = entries.nextElement()
			if (entry.name == entryPath) {
				return true
			}
		}
	}
	return false
}

fun editJarFile(inputJarFile: File, outputJarFile: File, entryPathToRemove: Set<String>) {
	JarFile(inputJarFile).use { inputJar ->
		JarOutputStream(outputJarFile.outputStream()).use { outputJar ->
			val entries = inputJar.entries()

			while (entries.hasMoreElements()) {
				val entry = entries.nextElement()
				val entryName = entry.name

				if (entryPathToRemove.contains(entryName)) {
					continue
				}

				val inputStream = inputJar.getInputStream(entry)
				val newEntry = JarEntry(entryName)
				outputJar.putNextEntry(newEntry)

				inputStream.copyTo(outputJar)
				inputStream.close()
				outputJar.closeEntry()
			}
		}
	}
}