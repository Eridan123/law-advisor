package law.advisor.repository;

import law.advisor.model.User;
import law.advisor.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    public List<UserRole> findAllByUser(User user);
}
