package bob.simple.spring.domain.service

import bob.simple.spring.data.repository.CarRepository
import bob.simple.spring.domain.model.Car
import bob.simple.spring.presentation.dto.CarRequestDto
import bob.simple.spring.presentation.dto.CarResponseDto
import org.springframework.stereotype.Service

@Service
class CarService(
    private val carJdbcRepository: CarRepository,
) {
    var id = 3

    fun getCar(id: String): CarResponseDto {
        val car: Car = carJdbcRepository.selectBy(id)
        return CarResponseDto.from(car)
    }

    fun createCar(carRequestDto: CarRequestDto): CarResponseDto {
        val car: Car = carRequestDto.toEntity(id++.toString())
        carJdbcRepository.insert(car)
        return CarResponseDto.from(car)
    }

    fun updateAirConditionerStatus(
        id: String,
        status: Boolean,
    ): CarResponseDto {
        val car: Car = carJdbcRepository.selectBy(id)

        if (car.acStatus == status) throw IllegalStateException("acStatus is already $status.")

        car.acStatus = status
        carJdbcRepository.update(car)
        return CarResponseDto.from(car)
    }
}
