package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Customers;
import local.imcelroy.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository custrepo;

    @Override
    public List<Customers> findAllOrders() {
        List<Customers> results = new ArrayList<>();

        custrepo.findAll().iterator().forEachRemaining(results::add);
        return results;
    }

    @Override
    public Customers findCustomerById(long id) {
        return custrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
    }

    @Override
    public List<Customers> findByNameLike(String substring) {
        List<Customers> list = custrepo.findByCustnameContainingIgnoreCase(substring);
        return list;
    }
}
