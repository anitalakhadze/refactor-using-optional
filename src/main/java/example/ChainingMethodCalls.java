package example;

import model.user.Address;
import model.user.Country;
import model.user.User;

import java.util.Optional;

public class ChainingMethodCalls {

    public String getCountryName(User user) {
        if (user != null && user.address() != null && user.address().country() != null) {
            return user.address().country().name();
        }
        return "Unknown";
    }

    public String getCountryNameAfterRefactor(User user) {
        return Optional.ofNullable(user)
                .map(User::address)
                .map(Address::country)
                .map(Country::name)
                .orElse("Unknown");
    }

}
