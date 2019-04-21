package law.advisor.repository;

import law.advisor.model.Question;
import law.advisor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    public List<Question> findByCategory_Id(Long id);
    public List<Question> findByTitleIsLike(String title);
    public List<Question> findByUser(User user);

}
