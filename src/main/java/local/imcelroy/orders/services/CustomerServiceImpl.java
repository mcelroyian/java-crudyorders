package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Customers;
import local.imcelroy.orders.models.Orders;
import local.imcelroy.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
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

    @Transactional
    @Override
    public void delete(long id) {
        if (custrepo.findById(id).isPresent()) {
            custrepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Customer " + id + " Not Found");
        }
    }

    @Transactional
    @Override
    public Customers save(Customers customer) {
        Customers newCustomer = new Customers();

        if (customer.getCustcode() != 0) {
            // put
            custrepo.findById(customer.getCustcode())
                    .orElseThrow(() -> new EntityNotFoundException("Customer " + customer.getCustcode() + " Not Found"));
            newCustomer.setCustcode(customer.getCustcode());

        }

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());

        newCustomer.getOrders().clear();

        for (Orders o : customer.getOrders()) {
            Orders newOrder = new Orders(o.getOrdamount(), o.getAdvanceamount(), o.getOrderdescription(), customer);
            newCustomer.getOrders().add(newOrder);
        }

        return custrepo.save(newCustomer);
    }

    @Override
    public Customers update(Customers customer, long id) {
        return null;
    }
}
