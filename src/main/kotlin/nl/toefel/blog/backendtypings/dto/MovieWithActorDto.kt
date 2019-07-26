package nl.toefel.blog.backendtypings.dto

import java.time.ZonedDateTime

data class MovieWithActorDto(
    val id: Int?,
    val name: String,
    val producerName: String,
    val releaseDate: ZonedDateTime,
    val actors: List<ActorDto>
)