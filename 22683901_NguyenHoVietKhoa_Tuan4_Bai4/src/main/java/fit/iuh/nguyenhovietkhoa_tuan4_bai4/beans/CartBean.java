package fit.iuh.nguyenhovietkhoa_tuan4_bai4.beans;

import java.util.List;

public class CartBean {
    private List<CartItemBean> items;

    public List<CartItemBean> getItems() {
        return items;
    }

    // thêm sản phẩm
    public void addProduct(Book b) {
        for (CartItemBean item : this.items) {
            if (item.getBook().getId() == b.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        items.add(new CartItemBean(b, 1));
    }

    // xóa sản phẩm
    public void removeBook(int bookId) {
        items.removeIf(item -> item.getBook().getId() == bookId);
    }

    // cập nhật số lượng
    public void updateQuantity(int bookId, int quantity) {
        for (CartItemBean item : this.items) {
            if (item.getBook().getId() == bookId) {
                if (quantity > 0) {
                    item.setQuantity(quantity);
                } else {
                    removeBook(bookId);
                }
                return;
            }
        }
    }

    // tính tổng tiền
    public double getTotal() {
        double total = 0;
        for (CartItemBean item : this.items) {
            total += item.getTotal();
        }
        return total;
    }

    // xóa hết giỏ hàng
    public void clear() {
        this.items.clear();
    }
}
