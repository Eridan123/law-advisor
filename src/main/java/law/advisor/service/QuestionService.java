package law.advisor.service;

import law.advisor.model.Question;
import law.advisor.model.User;

import java.util.List;

public interface QuestionService {
    List<Question> searchByTitle(String title);
    public Question findById(Long id);
    public List<Question> findByCategory(Long categoryId);
    public List<Question> findByUser(User user);

}
