package law.advisor.service;

import law.advisor.model.Category;
import law.advisor.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }


    @Override
    public Category findById(long id) {
        return categoryRepository.getOne(id);
    }
    
}
