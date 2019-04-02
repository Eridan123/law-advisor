package law.advisor.repository;

import law.advisor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerRepository extends JpaRepository<User,Long> {
}
