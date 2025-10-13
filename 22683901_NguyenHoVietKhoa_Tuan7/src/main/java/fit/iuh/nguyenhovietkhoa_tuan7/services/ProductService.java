package fit.iuh.nguyenhovietkhoa_tuan7.services;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Product;
import fit.iuh.nguyenhovietkhoa_tuan7.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        products.forEach(p -> p.getComments().size());
        return products;
    }

    @Transactional(readOnly = true)
    public Product getById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.getComments().size();
        return product;
    }

    // 🔹 Tìm theo category_id
    @Transactional(readOnly = true)
    public List<Product> getByCategoryId(int categoryId) {
        List<Product> products = productRepository.findProductByCategoryId(categoryId);
        products.forEach(p -> p.getComments().size());
        return products;
    }

    @Transactional(readOnly = true)
    public List<Product> getByCategoryName(String categoryName) {
        List<Product> products = productRepository.findProductByCategoryName(categoryName);
        products.forEach(p -> p.getComments().size());
        return products;
    }

}
