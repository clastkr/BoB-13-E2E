package bob.simple.spring.data.repository

import bob.simple.spring.domain.model.Car
import org.springframework.stereotype.Repository

@Repository
class CarRedisRepository : CarRepository {
    override fun insert(car: Car) {}

    override fun selectBy(id: String): Car {
        return Car(
            id = id,
            acStatus = false,
            model = "tesla",
        )
    }

    override fun update(car: Car) {}
}
