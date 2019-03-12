package law.advisor.repository;

import law.advisor.model.User;
import law.advisor.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {

    public User findUserByUsername(String username);
    public User findByEmail(String email);
    public User findByToken(String token);
    public List<User> findByUserType(UserType userType);
}
