package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Orders;
import local.imcelroy.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderrepo;

    @Override
    public Orders findOrdersById(long id) {
        return orderrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order " + id + " Not Found"));
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Orders save(Orders order) {
        return null;
    }
}
