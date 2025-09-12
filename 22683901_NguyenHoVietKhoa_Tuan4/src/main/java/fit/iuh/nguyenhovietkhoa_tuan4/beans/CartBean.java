package fit.iuh.nguyenhovietkhoa_tuan4.beans;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
    private List<CartBeanItem> items;

    public CartBean() {
        this.items = new ArrayList<>();
    }

    public List<CartBeanItem> getItems() {
        return items;
    }

    // thêm sản phẩm
    public void addProduct(Product p){
        for(CartBeanItem item : this.items){
            if(item.getProduct().getId() == p.getId()){
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        items.add(new CartBeanItem(p, 1));
    }

    // xóa sản phẩm
    public void removeProduct(int productId){
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    // cập nhật số lượng
    public void updateQuantity(int productId, int quantity){
        for (CartBeanItem item : this.items){
            if(item.getProduct().getId() == productId){
                if(quantity > 0){
                    item.setQuantity(quantity);
                }
                else{
                    removeProduct(productId);
                }
                return;
            }
        }
    }

    // tính tổng tiền
    public double getTotal() {
        double total = 0;
        for(CartBeanItem item : this.items){
            total += item.getSubtotal();
        }
        return total;
    }

    // xóa hết giỏ hàng
    public void clear(){
        this.items.clear();
    }
}