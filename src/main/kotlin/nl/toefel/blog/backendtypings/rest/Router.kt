package nl.toefel.blog.backendtypings.rest

import io.javalin.Javalin
import io.javalin.http.Context
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Creates the webserver:
 * 1. configures a request logger
 * 2. enables CORS on all domains
 * 3. configures available paths and their handlers
 * 4. transforms database results to and from DTOs (client interface)
 */
class Router(val port: Int) {
    private val logger: Logger = LoggerFactory.getLogger(Router::class.java)

    val app = Javalin.create { cfg -> cfg.requestLogger(::logRequest).enableCorsForAllOrigins() }
        .get("/actors", ::listActors)
        .get("/movies", ::listMovies)


    private fun logRequest(ctx: Context, executionTimeMs: Float) =
        logger.info("${ctx.method()} ${ctx.fullUrl()} status=${ctx.status()} durationMs=$executionTimeMs")

    fun start(): Router {
        app.start(port)
        return this
    }

    fun listActors(ctx: Context) {

    }

    fun listMovies(ctx: Context) {

    }
}
