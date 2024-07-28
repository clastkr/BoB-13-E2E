package bob.simple.spring.presentation.controller

import bob.simple.spring.domain.service.CarService
import bob.simple.spring.presentation.dto.CarRequestDto
import bob.simple.spring.presentation.dto.CarResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cars")
@RestController
class CarController(
    private val carService: CarService,
) {
    @GetMapping("/{id}")
    fun getCar(
        @PathVariable id: String,
    ): CarResponseDto {
        return carService.getCar(id)
    }

    @PostMapping
    fun postCar(
        @RequestBody carRequestDto: CarRequestDto,
    ): CarResponseDto {
        return carService.createCar(carRequestDto)
    }

    @PatchMapping("/{id}/air-conditioner")
    fun updateAirConditionerStatus(
        @PathVariable id: String,
        @RequestParam status: Boolean,
    ): CarResponseDto {
        return carService.updateAirConditionerStatus(id, status)
    }
}
