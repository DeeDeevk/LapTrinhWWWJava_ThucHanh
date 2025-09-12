package fit.iuh.nguyenhovietkhoa_tuan4.beans;

public class Product {
    private int id;
    private String model;
    private String description;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String model, int id, double price, int quantity, String description) {
        this.model = model;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
