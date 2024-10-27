package model.product;

import java.util.ArrayList;
import java.util.List;

// This is intended to simulate a repository behavior for demonstration purposes only
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("laptop"));
        products.add(new Product("display"));
    }

    public Product findByName(String name) {
        return products.stream()
                .filter(product -> product.name().equals(name))
                .findFirst()
                .orElse(null);
    }

}
