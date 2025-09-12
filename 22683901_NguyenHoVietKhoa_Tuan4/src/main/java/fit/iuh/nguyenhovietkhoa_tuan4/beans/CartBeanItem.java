package fit.iuh.nguyenhovietkhoa_tuan4.beans;

public class CartBeanItem {
    private Product product;
    private int quantity;

    public CartBeanItem() {
    }

    public CartBeanItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSubtotal() {
        return this.product.getPrice() * this.quantity;
    }
}
