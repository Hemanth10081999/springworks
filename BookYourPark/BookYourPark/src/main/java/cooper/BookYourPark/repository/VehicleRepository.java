package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Vehicle;
import org.springframework.data.repository.CrudRepository;


public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {
}
