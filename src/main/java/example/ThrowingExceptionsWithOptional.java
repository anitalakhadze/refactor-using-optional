package example;

import model.user.User;
import model.user.UserRepository;

import java.util.Optional;

public class ThrowingExceptionsWithOptional {
    private final UserRepository userRepository;

    public ThrowingExceptionsWithOptional() {
        this.userRepository = new UserRepository();
    }

    public User findUserById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found for id: " + id);
        }
        return user;
    }

    public User findUserByIdAfterRefactor(Long id) {
        return Optional.ofNullable(userRepository.findById(id))
                .orElseThrow(() -> new RuntimeException("User not found for id: " + id));
    }

}
