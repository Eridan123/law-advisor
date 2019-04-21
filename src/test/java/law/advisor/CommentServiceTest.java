//package law.advisor;
//
//import law.advisor.model.Comment;
//import law.advisor.model.CommentTo;
//import law.advisor.model.User;
//import law.advisor.model.UserType;
//import law.advisor.repository.CommentRepository;
//import law.advisor.service.CommentServiceImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//public @RunWith(MockitoJUnitRunner.class)
//class CommentServiceTest {
//
//    @Mock
//    CommentRepository commentRepository;
//
//    @InjectMocks
//    CommentServiceImpl commentService;
//
//    @Test
//    public void findByLawyerAndCommentToTest(){
//        User lawyer=new User();
//        lawyer.setUserType(UserType.LAWYER);
//        Comment comment=new Comment();
//        comment.setLawyer(lawyer);
//        comment.setCommentTo(CommentTo.LAWYER);
//        List<Comment> comments=new ArrayList<>();
//        comments.add(comment);
//        when(commentRepository.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER)).thenReturn(comments);
//        assertEquals(comments,commentService.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER));
//    }
//
//    @Test
//    public void findByLawyerAndCommentToTestWhenNull(){
//        User lawyer=new User();
//        when(commentRepository.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER)).thenReturn(null);
//        assertEquals(null,commentService.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER));
//    }
//
//    @Test
//    public void findByLawyerAndCommentToTestWhenNullLawyer(){
//        User lawyer=new User();
//        lawyer.setUserType(UserType.USER);
//        Comment comment=new Comment();
//        comment.setLawyer(lawyer);
//        comment.setCommentTo(CommentTo.LAWYER);
//        when(commentRepository.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER)).thenReturn(null);
//        assertEquals(null,commentService.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER));
//    }
//
//    @Test
//    public void findByLawyerAndCommentToTestWhenNullCommentTo(){
//        User lawyer=new User();
//        lawyer.setUserType(UserType.LAWYER);
//        Comment comment=new Comment();
//        comment.setLawyer(lawyer);
//        comment.setCommentTo(CommentTo.DEVELOPER);
//        when(commentRepository.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER)).thenReturn(null);
//        assertEquals(null,commentService.findByLawyerAndCommentTo(lawyer,CommentTo.LAWYER));
//    }
//
//    @Test
//    public void findByLawyerAndCommentToTestWhenBothNull(){
//        when(commentRepository.findByLawyerAndCommentTo(null,null)).thenReturn(null);
//        assertEquals(null,commentService.findByLawyerAndCommentTo(null,null));
//    }
//}
