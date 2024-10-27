package model.user;

public record Address(Country country,
                      String city,
                      String street,
                      String zipCode) {
}
