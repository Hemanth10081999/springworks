package cooper.BookYourPark.repository;

import cooper.BookYourPark.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
