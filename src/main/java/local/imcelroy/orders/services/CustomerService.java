package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> findAllOrders();

    Customers findCustomerById(long id);

    List<Customers> findByNameLike(String substring);

    void delete(long id);

    //POST, PUT
    Customers save(Customers customer);

    // PATCH
    Customers update(Customers customer, long id);
}
