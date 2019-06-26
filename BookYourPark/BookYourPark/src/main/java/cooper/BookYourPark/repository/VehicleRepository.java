package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    List<Vehicle> findByLogin(Integer login);

}
