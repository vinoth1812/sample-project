package automobile.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automobile.demo.entity.Car;
import automobile.demo.repo.Carrepository;
@Service
public class CarService {
	
	
	@Autowired
    private Carrepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }
    public List<Car> addCars(List<Car> cars) {
        return carRepository.saveAll(cars);
    }


    public Car updateCar(Long id, Car carDetails) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setMake(carDetails.getMake());
            car.setModel(carDetails.getModel());
            car.setYear(carDetails.getYear());
            car.setColor(carDetails.getColor());
            car.setVin(carDetails.getVin());
            car.setMileage(carDetails.getMileage());
            car.setPrice(carDetails.getPrice());
            car.setCategory(carDetails.getCategory());
            return carRepository.save(car);
        } else {
            throw new RuntimeException("Car not found with id " + id);
        }
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with id " + id));
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> getCarsByCategory(String category) {
        return carRepository.findByCategory(category);
    }

    public List<Car> getLowStockCars(int stockThreshold) {
        return carRepository.findByStockLessThan(stockThreshold);
    }

}
