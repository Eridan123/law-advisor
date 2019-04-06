package law.advisor.service;

import law.advisor.model.LawyerRateModel;
import law.advisor.model.User;
import law.advisor.model.UserType;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User findById(Long id);
    public User findUserByUsername(String username);
    public User findUserByEmail(String email);
    public User findUserByReset_token(String resetToken);
    public void save(User user);
    public List<LawyerRateModel> findTopLawyers(int first);
    public List<LawyerRateModel> findActiveLawyersByPeriod(int days);
    public List<User> findByUserType(UserType userType);
}