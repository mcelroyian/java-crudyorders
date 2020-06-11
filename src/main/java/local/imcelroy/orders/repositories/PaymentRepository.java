package local.imcelroy.orders.repositories;

import local.imcelroy.orders.models.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payments, Long> {
}
