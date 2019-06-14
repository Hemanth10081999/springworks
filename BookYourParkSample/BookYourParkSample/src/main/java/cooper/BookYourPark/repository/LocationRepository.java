package cooper.BookYourPark.repository;


import cooper.BookYourPark.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Integer> {
}
