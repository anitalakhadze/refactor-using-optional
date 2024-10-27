package model.order;

public record Order(Long id,
                    Integer count,
                    Double totalPrice) {

    public Order() {
        this(1L, 0, 0.0);
    }

}
