package law.advisor;

import law.advisor.model.Category;
import law.advisor.model.Question;
import law.advisor.model.User;
import law.advisor.model.UserType;
import law.advisor.repository.QuestionRepository;
import law.advisor.repository.UserRepository;
import law.advisor.service.QuestionServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public @RunWith(MockitoJUnitRunner.class)
class QuestionServiceTest {

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    QuestionServiceImpl questionService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() {
        System.out.println("Starting CategoryService Test Class");
    }

    @Test
    public void findById() {
        Question question=new Question();
        //Category category = new Category();
        question.setId(8L);
        question.setTitle("How to");
        //question.setCategory();
        //question.setContent();
        //question.setGrades();
        //question.setDate();
        question.setStatus(1);
        question.setViews(1);

        when(questionRepository.getOne(8L)).thenReturn(question);
        assertEquals(question,questionService.findById(8L));

    }

//    @Test
//    public void findByUser(){
//        Question question = new Question();
//        User user = new User();
//        user.setUsername("User");
//        when(userRepository.findUserByUsername("user")).thenReturn(user);
//        assertEquals(user,questionService.findByUser(user));
//    }
//    public void testFindByUser(){
//        ArrayList<Question> list=new ArrayList<>();
//        Question question = new Question();
//        User user1=new User();
//        String name = "Aba-Bakri";
//        user1.setUsername(name);
//        question.setUser(user1);
//        User user=new User();
//        user.setName("Aba-Bakri Ibragimov");
//        list.add(question);
//        when(questionRepository.findByUser(user)).thenReturn(list);
//        assertEquals(list,questionService.findByUser(user));
//    }

//    @Test
//    public void findByCategory(){
//        ArrayList<Question> list=new ArrayList<>();
//        Question question = new Question();
//        Category category = new Category();
//        Long id = 8L;
//        category.setId(id);
//        list.add(question);
//        when(questionRepository.findByCategory_Id(id)).thenReturn(list);
//        assertEquals(question,questionService.findByCategory(id));
//    }


    @Test
    public void searchByTitle(){
        ArrayList<Question> list=new ArrayList<>();
        Question question = new Question();
        String title = "Question1";
        question.setTitle(title);
        Question question1 = new Question();
        question1.setTitle(title);
        list.add(question);
        list.add(question1);
        when(questionRepository.findByTitleIsLike(title)).thenReturn(list);
        assertEquals(list,questionService.searchByTitle(title));
    }

    @Test
    public void searchByTitleTestWhenNull(){
        ArrayList<Question> list=new ArrayList<>();
        Question question = new Question();
        String title = null;
        question.setTitle(title);
        Question question1 = new Question();
        question1.setTitle(title);
        list.add(question);
        list.add(question1);
        when(questionRepository.findByTitleIsLike(title)).thenReturn(list);
        assertEquals(list,questionService.searchByTitle(title));
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}
