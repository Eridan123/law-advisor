package law.advisor.repository;

import law.advisor.model.MessageResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageResourceRepository extends JpaRepository<MessageResource,Long> {
}
