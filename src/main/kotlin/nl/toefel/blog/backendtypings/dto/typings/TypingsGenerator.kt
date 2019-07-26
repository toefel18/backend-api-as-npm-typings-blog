package nl.toefel.blog.backendtypings.dto.typings

import me.ntrrgc.tsGenerator.TypeScriptGenerator
import nl.toefel.blog.backendtypings.dto.ActorDto
import nl.toefel.blog.backendtypings.dto.Genre
import nl.toefel.blog.backendtypings.dto.MovieWithActorDto
import java.io.File
import java.time.ZonedDateTime

object TypingsGenerator {
    @JvmStatic
    fun main(args: Array<String>) {
        val typingsDestination = "${args[0]}/src/typings.d.ts"
        val packageJsonDestination = "${args[0]}/package.json"
        val projectVersion = args[1]

        println("Using project version = $projectVersion")
        println("Writing typings to = $typingsDestination")
        println("Writing package.json to = $packageJsonDestination")

        //Generates the typings for the provided classes and also configures
        //a mapping for non-standard types like ZonedDateTime
        val typingsContent = TypeScriptGenerator(
            rootClasses = setOf(
                Genre::class,
                ActorDto::class,
                MovieWithActorDto::class
            ),
            mappings = mapOf(
                ZonedDateTime::class to "Date"
            )
        ).definitionsText

        // Write the typings file as a .js source in backend-api-typings/src/typings.d.ts
        File(typingsDestination).writeText(typingsContent)

        // Set the node package to the same version as the application
        val packageJsonContent = packageJson.replace("PROJECT_VERSION", projectVersion)

        // Overwrite the package.json so that it contains the correct project.version
        File(packageJsonDestination).writeText(packageJsonContent)
    }

    val packageJson = """{
  "name": "backend-api-as-npm-typings-blog",
  "version": "PROJECT_VERSION",
  "description": "typings for backend-api-npm-typings java app",
  "repository": {
    "type": "git",
    "url": "git+https://github.com/toefel18/backend-api-as-npm-typings-blog.git"
  },
  "author": "toefel18@gmail.com",
  "license": "ISC",
  "homepage": "https://github.com/toefel18/backend-api-as-npm-typings-blog#readme"
}
"""
}