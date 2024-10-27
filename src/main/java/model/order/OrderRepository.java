package model.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// This is intended to simulate a repository behavior for demonstration purposes only
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public OrderRepository() {
        orders.add(new Order(1L, 3, 150.0));
        orders.add(new Order(2L,4, 100.0));
    }

    public Order findById(Long id) {
        return orders.stream()
                .filter(order -> order.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Optional<Order> findLatestByCustomerId(Long customerId) {
        System.out.println("Getting latest order for customer with id " + customerId);
        return Optional.of(orders.getLast());
    }

}
