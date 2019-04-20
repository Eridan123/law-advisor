package law.advisor.service;

import law.advisor.model.Comment;
import law.advisor.model.CommentTo;
import law.advisor.model.User;
import law.advisor.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findByLawyerAndCommentTo(User lawyer, CommentTo commentTo) {
        return commentRepository.findByLawyerAndCommentTo(lawyer,commentTo);
    }
}
