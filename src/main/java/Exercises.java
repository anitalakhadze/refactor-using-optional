import model.order.Order;
import model.order.OrderRepository;
import model.user.Address;
import model.user.ContactInfo;
import model.user.User;
import model.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Exercises {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public Exercises() {
        this.userRepository = new UserRepository();
        this.orderRepository = new OrderRepository();
    }

    // TODO: Challenge yourself with these exercises and if stuck, check out the 'answers' branch

    public String getUserEmail(String userName) {
        Optional<User> userOpt = userRepository.findByUserName(userName);
        if (userOpt.isPresent()) {
            Optional<ContactInfo> contactOpt = userOpt.get().getContactInfo();
            if (contactOpt.isPresent()) {
                return contactOpt.get().email();
            }
        }
        return "Email not available";
    }

    public Order findOrderById(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            return new Order();
        }
        return order;
    }

    public List<String> getUserEmails(List<String> userNames) {
        List<String> emails = new ArrayList<>();
        for (String userName : userNames) {
            Optional<User> userOpt = userRepository.findByUserName(userName);
            if (userOpt.isPresent()) {
                emails.add(userOpt.get().contactInfo().email());
            }
        }
        return emails;
    }

    public Optional<Address> getAddress(User user) {
        if (user != null) {
            Optional<Address> address = user.getFullAddress();
            if (address.isPresent()) {
                return address;
            }
        }
        return Optional.empty();
    }

    public User findUser(Long id, String email) {
        User user = userRepository.findById(id);
        if (user == null) {
            user = userRepository.findByEmail(email);
        }
        return user;
    }

    public String getUserPhoneNumber(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.contactInfo() != null) {
            return user.contactInfo().phoneNumber();
        }
        return "Phone number not available";
    }

    public Order getOrderOrDefault(Long orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            order = new Order();
        }
        return order;
    }

    public void sendWelcomeEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            System.out.println("Sending welcome email to " + email);
        } else {
            System.out.println("Email not available");
        }
    }

    public String getUserCountry(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.address() != null) {
            return user.address().country().name();
        }
        return null;
    }
}
