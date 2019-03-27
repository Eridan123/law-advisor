package law.advisor.service;

import law.advisor.model.LawyerRateModel;
import law.advisor.model.User;
import law.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByReset_token(String resetToken) {
        return userRepository.findByToken(resetToken);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<LawyerRateModel> findTopLawyers(int first) {
        String baseQuery="select answer.user_id,count(1) as num_answers\n" +
                "from answer,user u where u.user_type='LAWYER' group by user_id order by num_answers desc limit "+first;
        Query query=entityManager.createNativeQuery(baseQuery,LawyerRateModel.class);
        List<LawyerRateModel> lawyerRateModels=query.getResultList();
        return lawyerRateModels;
    }
}