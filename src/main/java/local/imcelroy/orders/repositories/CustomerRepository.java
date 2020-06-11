package local.imcelroy.orders.repositories;

import local.imcelroy.orders.models.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customers, Long> {

    List<Customers> findByCustnameContainingIgnoreCase(String likename);
}
