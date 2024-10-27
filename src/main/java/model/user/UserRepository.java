package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// This is intended to simulate a repository behavior for demonstration purposes only
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(
                new User(
                        1L,
                        "Alice",
                        "alice123",
                        new Address(
                                new Country("Aliceland", "AL"),
                                "city1",
                                "street1",
                                "123"
                        ),
                        new ContactInfo(
                                "987654321",
                                "alice@example.com"
                        )
                )
        );
        users.add(
                new User(
                        2L,
                        "Bob",
                        "bob456",
                        new Address(
                                new Country("Bobland", "BO"),
                                "city2",
                                "street2",
                                "456"
                        ),
                        new ContactInfo(
                                "123456789",
                                "bob@example.com"
                        )
                )
        );
    }

    public User findById(Long id) {
        return users.stream()
                .filter(user -> user.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User findByEmail(String email) {
        return users.stream()
                .filter(user -> user.contactInfo() != null && email.equals(user.contactInfo().email()))
                .findFirst()
                .orElse(null);
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getContactInfo().isPresent() && user.contactInfo().email().equals(email))
                .findFirst();
    }

    public Optional<User> findByUserName(String username) {
        return users.stream()
                .filter(user -> user.username().equals(username))
                .findFirst();
    }

}
