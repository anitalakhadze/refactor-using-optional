package example;

import model.order.Order;
import model.order.OrderRepository;
import model.user.User;

import java.util.Optional;

public class PerformingActionsConditionally {
    private final OrderRepository orderRepository;

    public PerformingActionsConditionally() {
        this.orderRepository = new OrderRepository();
    }

    public void notifyUser(User user) {
        if (user != null) {
            sendNotification(user);
        }
    }

    public void notifyUserAfterRefactor(User user) {
        Optional.ofNullable(user)
                .ifPresent(this::sendNotification);
    }

    private void sendNotification(User user) {
        System.out.println("Sending notification to user...");
    }

    public void processLastOrder(Long orderId) {
        Optional<Order> orderOpt = orderRepository.findLatestByCustomerId(orderId);
        if (orderOpt.isPresent()) {
            handleOrder(orderOpt.get());
        } else {
            handleMissingOrder();
        }
    }

    public void processOrderAfterRefactor(Long orderId) {
        orderRepository.findLatestByCustomerId(orderId)
                .ifPresentOrElse(this::handleOrder, this::handleMissingOrder);
    }

    private void handleMissingOrder() {
        System.out.println("Missing order");
    }

    private void handleOrder(Order order) {
        System.out.println("Handling order: " + order);
    }

}
