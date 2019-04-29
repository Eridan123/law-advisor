package law.advisor.repository;

import law.advisor.model.WebsiteRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<WebsiteRating , Long> {
//    @Override
//    <S extends Integer> S save(S s);
//
//    void save(WebsiteRating r);

    List<WebsiteRating> findAll();

}

