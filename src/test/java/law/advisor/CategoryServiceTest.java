 package law.advisor;

 import law.advisor.model.Category;
 import law.advisor.repository.CategoryRepository;
 import law.advisor.service.CategoryService;
 import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.junit.MockitoJUnitRunner;
 import org.springframework.beans.factory.annotation.Autowired;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;

 import static org.junit.Assert.assertEquals;
 import static org.mockito.Mockito.when;

 @RunWith(MockitoJUnitRunner.class)
 public class CategoryServiceTest {

     @Mock
     CategoryRepository categoryRepositoryMock;

     @Autowired
     CategoryRepository categoryRepository;

     @InjectMocks
     CategoryService categoryService;

     @Before
     public void setUp(){
         System.out.println("Starting CategoryService Test Class");
     }

     @Test
     public void getAllCategories(){
         List<Category> listTop=new ArrayList<>();
         Category cat1 = new Category();
         Category cat2 = new Category();
         Category cat3 = new Category();
         listTop.add(cat1);
         listTop.add(cat2);
         listTop.add(cat3);

         when(categoryRepositoryMock.findAll()).thenReturn(listTop);
         assertEquals(listTop, categoryService.getAll());

     }

     @After
     public void terminate(){
         System.out.println("PlaceServiceTest class is terminated");
     }


 }
