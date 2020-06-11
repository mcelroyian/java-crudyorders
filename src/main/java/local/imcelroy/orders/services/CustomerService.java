package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Customers;
import local.imcelroy.orders.models.Orders;

import java.util.List;

public interface CustomerService {

    List<Customers> findAllOrders();

    Customers findCustomerById(long id);

    List<Customers> findByNameLike(String substring);
}
