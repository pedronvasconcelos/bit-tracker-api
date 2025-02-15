package tech.vasconcelos.trackercoin.webapi.middlewares
import io.swagger.v3.oas.models.info.Info

import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Coin Tracker API")
                    .version("1.0.0")
                    .description("Coin tracker API.")
            )
    }
}