package law.advisor.service;

import law.advisor.model.LawyerRateModel;
import law.advisor.model.User;
import law.advisor.model.UserType;
import law.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

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
        String baseQuery="select u.name, u.surname, answer.user_id,count(1) as num_answers\n" +
                "from answer,user u where u.user_type='LAWYER' and u.id=answer.user_id group by user_id order by num_answers desc limit "+first;
        Query query=entityManager.createNativeQuery(baseQuery,LawyerRateModel.class);
        List<LawyerRateModel> lawyerRateModels=query.getResultList();
        return lawyerRateModels;
    }

    @Override
    public List<LawyerRateModel> findActiveLawyersByPeriod(int days) {

        SimpleDateFormat sd=new SimpleDateFormat("yyyy.MM.dd");
        Date lastDate=new Date();
        String last=sd.format(lastDate);
        String first="";

        String[] dates=last.split(".");
        if(dates[1]=="1"){
            first=Integer.valueOf(dates[0])-1+".12."+dates[2];
        }
        else{
            first=Integer.valueOf(dates[0])-1+"."+dates[1]+"."+dates[2];
        }
        String baseQuery="select u.name, u.surname, answer.user_id,count(1) as num_answers\n"+
        "from answer,user u where u.user_type='LAWYER' and  u.id=answer.user_id and answer.date  between \'"+first+"\' and \'"+last+"\'  group by user_id order by num_answers desc";
        Query query=entityManager.createNativeQuery(baseQuery,LawyerRateModel.class);
        List<LawyerRateModel> lawyerRateModels=query.getResultList();
        return lawyerRateModels;
    }

    @Override
    public List<User> findByUserType(UserType userType) {
        return userRepository.findByUserType(userType);
    }
}