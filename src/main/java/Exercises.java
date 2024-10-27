import model.order.Order;
import model.order.OrderRepository;
import model.user.*;

import java.util.List;
import java.util.Optional;

public class Exercises {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public Exercises() {
        this.userRepository = new UserRepository();
        this.orderRepository = new OrderRepository();
    }

    public String getUserEmail(String userName) {
        return userRepository.findByUserName(userName)
                .flatMap(User::getContactInfo)
                .map(ContactInfo::email)
                .orElse("Email not available");
    }

    public Order findOrderById(Long id) {
        return orderRepository
                .findOrderById(id)
                .orElse(new Order());
    }

    public List<String> getUserEmails(List<String> userNames) {
        return userNames.stream()
                .map(userRepository::findByUserName)
                .flatMap(Optional::stream)
                .map(User::contactInfo)
                .map(ContactInfo::email)
                .toList();
    }

    public Optional<Address> getAddress(User user) {
        return Optional.ofNullable(user)
                .flatMap(User::getFullAddress);
    }

    public User findUser(Long id, String email) {
        return Optional.ofNullable(userRepository.findById(id))
                .orElseGet(() -> userRepository.findByEmail(email));
    }

    public String getUserPhoneNumber(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .map(User::contactInfo)
                .map(ContactInfo::phoneNumber)
                .orElse("Phone number not available");
    }

    public void sendWelcomeEmail(String email) {
        Optional.ofNullable(userRepository.findByEmail(email))
                .ifPresentOrElse(
                        user -> System.out.println("Sending welcome email to " + email),
                        () -> System.out.println("Email not available")
                );
    }

    public String getUserCountry(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .map(User::address)
                .map(Address::country)
                .map(Country::name)
                .orElse(null);
    }
}
