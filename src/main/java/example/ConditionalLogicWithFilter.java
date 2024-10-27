package example;

import model.user.User;

import java.util.Optional;

public class ConditionalLogicWithFilter {

    public Optional<User> getActiveUser(User user) {
        if (user != null && user.isActive()) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public Optional<User> getActiveUserAfterRefactor(User user) {
        return Optional.ofNullable(user)
                .filter(User::isActive);
    }

}
