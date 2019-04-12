package law.advisor.service;

import law.advisor.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    List<Category> getAll();

    Category findById(long id);

    //ArrayList<Category> findAllByTitle(String );
}
