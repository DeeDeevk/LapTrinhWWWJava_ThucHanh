package fit.iuh.nguyenhovietkhoa_tuan4_bai4.beans;

public class CartItemBean {
    private Book book;
    private int quantity;

    public CartItemBean(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal(){
        return this.quantity * this.book.getPrice();
    }
}
