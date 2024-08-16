package bob.pjs.e2e.controller

import org.springframework.core.io.ClassPathResource
import java.io.ByteArrayOutputStream
import java.io.File
import javax.imageio.ImageIO
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.random.Random

class KeypadGenerator {

    fun hashGenerator(): String{
        val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..32)
            .map { charset.random() }
            .joinToString("")
    }

    @OptIn(ExperimentalEncodingApi::class)
    fun imageGenerator(fileNumber: Int): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        var fileName: String = ""
        if(fileNumber == -1){
            fileName = "_blank.png"
        }
        else{
            fileName = "_${fileNumber}.png"
        }

        val bitmap = ClassPathResource(fileName).inputStream.readAllBytes()
        return Base64.encode(bitmap)
    }

    fun generate():List<KeypadButton>{
        var buttonList = mutableListOf<KeypadButton>()

        for(i in 0..9){
            buttonList.add(KeypadButton(hashGenerator(), imageGenerator(i), i))
        }
        buttonList.add(KeypadButton("", imageGenerator(-1), -1))
        buttonList.add(KeypadButton("", imageGenerator(-1), -1))

        buttonList.shuffle()
        return buttonList
    }
}
