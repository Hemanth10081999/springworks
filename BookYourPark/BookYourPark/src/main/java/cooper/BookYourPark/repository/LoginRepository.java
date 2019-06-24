package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    Optional<Login> findByMailidAndPassword(String mailId, String password);
    List<Login> findByMailid(String mailId);
}
