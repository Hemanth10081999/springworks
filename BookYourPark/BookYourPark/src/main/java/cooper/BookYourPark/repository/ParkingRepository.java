package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Parking;
import org.springframework.data.repository.CrudRepository;

public interface ParkingRepository extends CrudRepository<Parking,Integer> {
}
