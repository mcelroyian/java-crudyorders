package local.imcelroy.orders.controllers;

import local.imcelroy.orders.models.Customers;
import local.imcelroy.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers() {
        List<Customers> myCustomers = customerService.findAllOrders();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }


    //http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(@PathVariable long id) {
        Customers c = customerService.findCustomerById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{thisname}", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomersLikeName(@PathVariable String thisname) {
        List<Customers> myCustomers = customerService.findByNameLike(thisname);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

//    POST /customers/customer - Adds a new customer including any new orders
    @PostMapping(value = "/customer", consumes = {"application/json"})
    public ResponseEntity<?> addCustomer( @RequestBody Customers newCustomer)
    {
        newCustomer.setCustcode(0);
        newCustomer = customerService.save(newCustomer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{custcode}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


//    PUT /customers/customer/{custcode} - completely replaces the customer record including associated orders with the provided data
    @PutMapping(value = "/customer/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customers newCustomer, @PathVariable long custcode)
    {
        newCustomer.setCustcode(custcode);
        customerService.save(newCustomer);

        return new ResponseEntity<>(HttpStatus.OK);
    }



//    PATCH /customers/customer/{custcode} - updates customers with the new data. Only the new data is to be sent from the frontend client.
    @PatchMapping(value = "/customer/{custcode}")

    //    DELETE /customers/customer/{custcode} - Deletes the given customer including any associated orders
    @DeleteMapping(value = "/customer/{custcode}", produces = {"application/json"})
    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode) {
        customerService.delete(custcode);
        return new ResponseEntity<>(custcode, HttpStatus.OK);
    }

//    @DeleteMapping("/customer/{custcode}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode)
//    {
//        customerService.delete(custcode);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
