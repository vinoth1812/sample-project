package automobile.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import automobile.demo.entity.Car;
@Repository
public interface Carrepository extends JpaRepository<Car, Long> {
    List<Car> findByCategory(String category);
    List<Car> findByStockLessThan(int stockThreshold);
  

}
