package local.imcelroy.orders.repositories;

import local.imcelroy.orders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long> {
}
