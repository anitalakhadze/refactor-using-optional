package example;

import model.product.Product;
import model.product.ProductRepository;

import java.util.Optional;

public class UsingEmptyOptional {
    private final ProductRepository productRepository;

    public UsingEmptyOptional() {
        this.productRepository = new ProductRepository();
    }

    public Optional<Product> findProductByName(String name) {
        Product product = productRepository.findByName(name);
        if (product == null) {
            return null;
        }
        return Optional.of(product);
    }

    public Optional<Product> findProductByNameAfterRefactor(String name) {
        return Optional.ofNullable(productRepository.findByName(name))
                .or(Optional::empty);
    }

}
