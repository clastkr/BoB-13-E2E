package bob.simple.spring.data.repository

import bob.simple.spring.domain.model.Car

interface CarRepository {
    fun insert(car: Car)

    fun selectBy(id: String): Car

    fun update(car: Car)
}
