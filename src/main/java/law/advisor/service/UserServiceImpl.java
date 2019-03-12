package law.advisor.service;

import law.advisor.model.User;
import law.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
}