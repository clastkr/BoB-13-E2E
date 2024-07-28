package bob.simple.spring.presentation.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/keypad")
class TestController {

    @GetMapping("/{key}.png")
    fun getKeypadImage(@PathVariable key: String): ResponseEntity<Any> {
        val imagePath = when (key) {
            in "0".."9" -> "keypad/_${key}.png"
            "blank" -> "keypad/_blank.png"
            else -> return ResponseEntity.badRequest().build()
        }

        val imgFile = ClassPathResource(imagePath)
        return ResponseEntity.ok()
            .header("Content-Type", "image/png")
            .body(imgFile)
    }
}
