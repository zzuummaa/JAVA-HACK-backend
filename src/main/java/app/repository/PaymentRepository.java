package app.repository;

import app.entities.PaymentDB;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<PaymentDB, Integer> {
}
