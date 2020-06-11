package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Orders;

public interface OrderService {

    Orders findOrdersById(long id);
}
