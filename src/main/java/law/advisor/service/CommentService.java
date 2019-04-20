package law.advisor.service;

import law.advisor.model.Comment;
import law.advisor.model.CommentTo;
import law.advisor.model.User;

import java.util.List;

public interface CommentService {

    public List<Comment> findByLawyerAndCommentTo(User lawyer, CommentTo commentTo);
}
