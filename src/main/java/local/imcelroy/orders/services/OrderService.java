package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Orders;

public interface OrderService {

    Orders findOrdersById(long id);

    void delete(long id);

    Orders save(Orders order);

    // PATCH

}
