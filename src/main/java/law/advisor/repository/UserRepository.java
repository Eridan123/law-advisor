package law.advisor.repository;

import law.advisor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUsername(String username);
}
