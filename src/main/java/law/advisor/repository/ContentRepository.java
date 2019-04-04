package law.advisor.repository;

import law.advisor.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContentRepository extends JpaRepository<Content, Long> {
}
