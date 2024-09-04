package automobile.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automobile.demo.entity.Car;
import automobile.demo.service.CarService;


@RestController
@RequestMapping("api/inventary")
public class CarController {
	
	
	 @Autowired
	    private CarService carService;
	 
	

	    @PostMapping("/AddCar")
	    public ResponseEntity<Car> addCar(@RequestBody Car car) {
	        Car savedCar = carService.addCar(car);
	        return ResponseEntity.ok(savedCar);
	    }
	    
	    @PostMapping("/bulk")
	    public ResponseEntity<List<Car>> addCars(@RequestBody List<Car> cars) {
	        List<Car> savedCars = carService.addCars(cars);
	        return ResponseEntity.ok(savedCars);
	    }


	    @PutMapping("UpdateCar/{id}")
	    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
	        Car updatedCar = carService.updateCar(id, carDetails);
	        return ResponseEntity.ok(updatedCar);
	    }

	    @GetMapping("/GetAllCar")
	    public ResponseEntity<List<Car>> getAllCars() {
	        List<Car> cars = carService.getAllCars();
	        return ResponseEntity.ok(cars);
	    }

	    @GetMapping("car/{id}")
	    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
	        Car car = carService.getCarById(id);
	        return ResponseEntity.ok(car);
	    }

	    @DeleteMapping("dcar/{id}")
	    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
	        carService.deleteCar(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/category/{category}")
	    public ResponseEntity<List<Car>> getCarsByCategory(@PathVariable String category) {
	        List<Car> cars = carService.getCarsByCategory(category);
	        return ResponseEntity.ok(cars);
	    }

		/*
		 * @GetMapping("/low-stock") public ResponseEntity<String> getLowStockCars
		 * (@RequestParam int stockThreshold) { List<Car> cars =
		 * carService.getLowStockCars(stockThreshold); String alertMessage; try { if
		 * (!cars.isEmpty()) { alertMessage = "Low stock alert: " + cars.size() +
		 * " cars with stock less than " + stockThreshold; // Send email alert
		 * email.sendEmail("vinothkumar18032001@gmail.com", "Low Stock Alert",
		 * alertMessage); } else { alertMessage = "No cars found with stock less than "
		 * + stockThreshold; } } catch (Exception e) { alertMessage =
		 * "An error occurred while sending the email alert."; // Optionally log the
		 * exception e.printStackTrace(); } return ResponseEntity.ok(alertMessage); }
		 */

}
