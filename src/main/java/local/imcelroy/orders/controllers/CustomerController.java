package local.imcelroy.orders.controllers;

import local.imcelroy.orders.models.Customers;
import local.imcelroy.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{

    @Autowired
    private CustomerService customerService;

    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customers> myCustomers = customerService.findAllOrders();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }


    //http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(@PathVariable long id)
    {
        Customers c = customerService.findCustomerById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{thisname}", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomersLikeName(@PathVariable String thisname)
    {
        List<Customers> myCustomers = customerService.findByNameLike(thisname);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

}
