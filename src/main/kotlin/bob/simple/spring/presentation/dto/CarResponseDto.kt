package bob.simple.spring.presentation.dto

import bob.simple.spring.domain.model.Car

data class CarResponseDto(
    val id: String,
    var acStatus: Boolean,
    val model: String,
) {
    companion object {
        fun from(car: Car) =
            CarResponseDto(
                id = car.id,
                acStatus = car.acStatus,
                model = car.model,
            )
    }
}
