package nl.toefel.blog.backendtypings

import nl.toefel.blog.backendtypings.rest.Router
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Main {
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Main::class.java)

        @JvmStatic
        fun main(args: Array<String>) {
            Router(8080).start()
        }
    }
}





