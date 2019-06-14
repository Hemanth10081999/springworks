package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Integer> {
}
