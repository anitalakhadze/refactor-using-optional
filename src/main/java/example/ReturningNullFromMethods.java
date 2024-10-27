package example;

import model.user.Address;
import model.user.User;

import java.util.Optional;

public class ReturningNullFromMethods {

    public Address getAddress(User user) {
        if (user != null && user.address() != null) {
            return user.address();
        }
        return null;
    }

    public Optional<Address> getAddressAfterRefactor(User user) {
        return Optional.ofNullable(user)
                .map(User::address);
    }

}
