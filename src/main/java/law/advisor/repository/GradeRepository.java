package law.advisor.repository;

import law.advisor.model.Grade;
import law.advisor.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GradeRepository extends JpaRepository<Grade,Long> {
    public Set<Grade> findByTypeAndQuestion(int type, Question question);
    public Grade findByUserIdAndQuestionId(long userId,long questionId);
}
