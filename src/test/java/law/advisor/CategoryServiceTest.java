package law.advisor.controller;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class CategoryServiceTest {

	@Mock
    CategoryRepository categoryRepositoryMock;

    @InjectMocks
    CategoryService categoryServiceTest;

    @Before
    public void setUp(){
        System.out.println("Starting CategoryService Test Class");
    }

    @Test
    public void testFindById(){
        Category category = new Category();
        long id = 1;
        category.setId(id);
        when(categoryRepositoryMock.findById(id)).thenReturn(category);
        assertEquals(category,categoryRepositoryMock.findById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        Category category = new Category();
        long id=0;
        when(categoryRepositoryMock.findById(id)).thenReturn(category);
        assertEquals(category,categoryServiceTest.findById(id));
    }

------------
 	@Test
    public void findByNameTest(){
        ArrayList<Category> list=new ArrayList<>();
        Category category=new Category();
        String name = "Category1";
        category.setName(name);
        Category category1=new Category();
        category1.setName(name);
        list.add(category);
        list.add(category1);
        when(categoryRepositoryMock.findAllByTitle(name)).thenReturn(list);
        assertEquals(list,categoryServiceTest.findAllByTitle(name));
    }

    @Test
    public void findByNameTest_whennull(){
        ArrayList<Category> list=new ArrayList<>();
        Category category=new Category();
        String name = null;
        category.setName(name);
        Category category1=new Category();
        category1.setName(name);
        list.add(category);
        list.add(category1);
        when(categoryRepositoryMock.findAllByTitle(name)).thenReturn(list);
        assertEquals(list,categoryServiceTest.findAllByTitle(name));
    }

    @Test
    public void findByNameTest_whenNoSuchBlog(){
       	ArrayList<Category> list1=new ArrayList<>();
        when(categoryRepositoryMock.findAllByTitle("Bishkek")).thenReturn(list1);
        assertEquals(list1,categoryServiceTest.findAllByTitle("Bishkek"));
    }


    @Test
    public void testGetAllCategories() {

        Category mockTicket1 = new Category();
        mockTicket1.setId(1);
        mockTicket1.setName("Somebody");

        Category mockTicket2 = new Category();
        mockTicket2.setId(2);
		mockTicket1.setName("Somebody222");

        List<Category> ticketList = new ArrayList<>();
        ticketList.add(mockTicket1);
        ticketList.add(mockTicket2);
        when(categoryRepositoryMock.getAllByOrderByView()).thenReturn(ticketList);
        assertEquals(ticketList, categoryServiceTest.getAll());
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }