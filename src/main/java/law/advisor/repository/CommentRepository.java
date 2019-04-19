package law.advisor.repository;

import law.advisor.model.Comment;
import law.advisor.model.CommentTo;
import law.advisor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findByLawyerAndCommentTo(User lawyer, CommentTo commentTo);
}
