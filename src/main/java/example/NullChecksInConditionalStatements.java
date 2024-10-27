package example;

import model.customer.Customer;

import java.util.Optional;

public class NullChecksInConditionalStatements {

    public int getDiscount(Customer customer) {
        if (customer != null && customer.discount() != null) {
            return customer.discount();
        }
        return 0;
    }

    public int getDiscountAfterRefactor(Customer customer) {
        return Optional.ofNullable(customer)
                .map(Customer::discount)
                .orElse(0);
    }

}
