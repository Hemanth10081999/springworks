package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {

    Optional<Profile> findByLogin(Login login);

}
