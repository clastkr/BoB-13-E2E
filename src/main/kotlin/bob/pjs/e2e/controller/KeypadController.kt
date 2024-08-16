package bob.pjs.e2e.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/create_key")
class KeypadController(private val KeypadGenerator: KeypadGenerator = KeypadGenerator()) {

    @GetMapping
    @CrossOrigin(origins = ["http://localhost:3000"])
    fun createKeypad(): List<KeypadReturn> {
        val buttonList = KeypadGenerator.generate()
        var returnList = mutableListOf<KeypadReturn>()

        for (button in buttonList) {
            returnList.add(KeypadReturn(button.hashData, button.imageData))
        }
        return returnList
    }
}
