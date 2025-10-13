package fit.iuh.nguyenhovietkhoa_tuan7.controller;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Category;
import fit.iuh.nguyenhovietkhoa_tuan7.entities.Product;
import fit.iuh.nguyenhovietkhoa_tuan7.services.CategoryService;
import fit.iuh.nguyenhovietkhoa_tuan7.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String product(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product/productDetail";
    }

    @GetMapping("/category")
    public String getProductByCategory(@RequestParam(required = false) Integer categoryId, Model model) {
        List<Product> products;
        if(categoryId != null) {
            products = productService.getByCategoryId(categoryId);
            model.addAttribute("selectedCategoryId", categoryId);
        }else {
            products = productService.getAllProducts();
            model.addAttribute("selectedCategoryId", null);
        }
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/list";
    }
}
