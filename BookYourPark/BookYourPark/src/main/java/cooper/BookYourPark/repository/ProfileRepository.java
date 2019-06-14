package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Integer> {
}
