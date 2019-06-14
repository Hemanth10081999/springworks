package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {



}
