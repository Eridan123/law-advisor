package law.advisor.service;


import law.advisor.model.Question;
import law.advisor.model.User;
import law.advisor.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> searchByTitle(String title) {
        return questionRepository.findByTitleIsLike(title);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.getOne(id);
    }

    @Override
    public List<Question> findByCategory(Long categoryId) {
        return questionRepository.findByCategory_Id(categoryId);
    }

    @Override
    public List<Question> findByUser(User user) {
        return questionRepository.findByUser(user);
    }
}
