package bob.simple.spring.presentation.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerE2ETest(@Autowired val webTestClient: WebTestClient) {

    @Test
    fun `should return image for valid key`() {
        val validKeys = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "blank")

        validKeys.forEach { key ->
            val expectedImage = ClassPathResource("keypad/_${key}.png").file.readBytes()
            webTestClient.get().uri("/keypad/${key}.png")
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.IMAGE_PNG)
                .expectBody(ByteArray::class.java)
                .isEqualTo(expectedImage)
        }
    }

    @Test
    fun `should return bad request for invalid key`() {
        webTestClient.get().uri("/keypad/invalid.png")
            .exchange()
            .expectStatus().isBadRequest
    }
}