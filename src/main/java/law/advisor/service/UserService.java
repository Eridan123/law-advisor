package law.advisor.service;

import law.advisor.model.User;

import java.util.Optional;

public interface UserService {
    public User findUserByEmail(String email);
    public User findUserByReset_token(String resetToken);
    public void save(User user);
}