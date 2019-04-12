package law.advisor.repository;

import law.advisor.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
//    Object getAllByOrderByView();

//    Object findAllByTitle(String name);
}
