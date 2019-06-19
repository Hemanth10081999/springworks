package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking,Integer> {
}
