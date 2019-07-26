package nl.toefel.blog.backendtypings.dto.typings

import me.ntrrgc.tsGenerator.TypeScriptGenerator
import nl.toefel.blog.backendtypings.Main
import nl.toefel.blog.backendtypings.dto.ActorDto
import nl.toefel.blog.backendtypings.dto.Genre
import nl.toefel.blog.backendtypings.dto.MovieWithActorDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime

object TypingsGenerator {
    private val logger: Logger = LoggerFactory.getLogger(TypingsGenerator::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        println(TypeScriptGenerator(
            rootClasses = setOf(
                Genre::class,
                ActorDto::class,
                MovieWithActorDto::class
            ),
            mappings = mapOf(
                ZonedDateTime::class to "Date"
            )
        ).definitionsText)
    }
}