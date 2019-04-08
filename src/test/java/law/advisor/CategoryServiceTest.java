// package law.advisor;

// import law.advisor.model.Category;
// import law.advisor.repository.CategoryRepository;
// import law.advisor.service.CategoryService;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.MockitoJUnitRunner;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// import static org.junit.Assert.assertEquals;
// import static org.mockito.Mockito.when;

// @RunWith(MockitoJUnitRunner.class)
// public class CategoryServiceTest {

//     @Mock
//     CategoryRepository categoryRepositoryMock;

//     @InjectMocks
//     CategoryService categoryServiceTest;

//     @Before
//     public void setUp() {
//         System.out.println("Starting CategoryService Test Class");
//     }

//     @Test
//     public void findByNameTest(){
//         ArrayList<Category> list=new ArrayList<>();
//         Category category=new Category();
//         String name = "Category1";
//         category.setName(name);
//         Category category1=new Category();
//         category1.setName(name);
//         list.add(category);
//         list.add(category1);
//         when(categoryRepositoryMock.findAll()).thenReturn(list);
//         assertEquals(list,categoryServiceTest.findAll());
//     }

//     @Test
//     public void findByNameTest_whennull(){
//         ArrayList<Category> list=new ArrayList<>();
//         Category category=new Category();
//         String name = null;
//         category.setName(name);
//         Category category1=new Category();
//         category1.setName(name);
//         list.add(category);
//         list.add(category1);
//         when(categoryRepositoryMock.findAll()).thenReturn(list);
//         assertEquals(list,categoryServiceTest.findAll());
//     }

//     @After
//     public void terminate(){
//         System.out.println("Terminating Test Class");
//     }

// }
