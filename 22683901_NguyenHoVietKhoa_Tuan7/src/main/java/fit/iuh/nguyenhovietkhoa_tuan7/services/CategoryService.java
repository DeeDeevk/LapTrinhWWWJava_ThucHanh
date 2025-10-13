package fit.iuh.nguyenhovietkhoa_tuan7.services;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Category;
import fit.iuh.nguyenhovietkhoa_tuan7.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
