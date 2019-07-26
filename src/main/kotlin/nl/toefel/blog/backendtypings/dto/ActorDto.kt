package nl.toefel.blog.backendtypings.dto

import java.time.ZonedDateTime

data class ActorDto(
    val firstName: String,
    val lastName: String,
    val dateOfBirth: ZonedDateTime?
)