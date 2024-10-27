package model.user;

import java.util.Optional;

public record User(Long id,
                   String name,
                   String username,
                   Address address,
                   ContactInfo contactInfo) {

    public boolean isActive() {
        return username != null && !username.isEmpty();
    }

    public Optional<Address> getFullAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<ContactInfo> getContactInfo() {
        return Optional.ofNullable(contactInfo);
    }

}
