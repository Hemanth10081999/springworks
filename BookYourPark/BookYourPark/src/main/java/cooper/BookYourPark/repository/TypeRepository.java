package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
}
