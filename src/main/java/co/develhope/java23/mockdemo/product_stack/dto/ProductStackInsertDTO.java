package co.develhope.java23.mockdemo.product_stack.dto;

public class ProductStackInsertDTO {
    private String name;
    private int quantity;

    public ProductStackInsertDTO() {

    }

    public ProductStackInsertDTO(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
