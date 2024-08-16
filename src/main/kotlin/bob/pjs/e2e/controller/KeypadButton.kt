package bob.pjs.e2e.controller

data class KeypadButton(
    val hashData:   String,
    val imageData:  String,
    val answer:     Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KeypadButton

        if (hashData != other.hashData) return false
        if (answer   != other.answer) return false

        return true
    }
}