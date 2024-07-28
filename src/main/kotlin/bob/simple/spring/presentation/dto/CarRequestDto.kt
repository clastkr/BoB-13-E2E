package bob.simple.spring.presentation.dto

import bob.simple.spring.domain.model.Car

data class CarRequestDto(
    val model: String,
) {
    fun toEntity(id: String) =
        Car(
            id = id,
            acStatus = false,
            model = model,
        )
}
