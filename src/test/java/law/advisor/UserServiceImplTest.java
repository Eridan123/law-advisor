package law.advisor;

import law.advisor.model.User;
import law.advisor.repository.UserRepository;
import law.advisor.service.UserService;
import law.advisor.service.UserServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.annotations.ITestAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public @RunWith(MockitoJUnitRunner.class)
 class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void findById() {
        User user=new User();
        user.setId(8L);
        user.setEnabled(true);
        user.setGender(1);

        when(userRepository.getOne(8L)).thenReturn(user);
        assertEquals(user,userService.findById(8L));

    }

    @Test
    public void findByIdWhenUserDoesntExist() {

        when(userRepository.getOne(8L)).thenReturn(null);
        assertEquals(null,userService.findById(8L));

    }

    @Test
    public void findUserByUsername() {

        User user=new User();
        user.setUsername("men");

        when(userRepository.findUserByUsername("men")).thenReturn(user);
        assertEquals(user,userService.findUserByUsername("men"));
    }

    @Test
    public void findUserByUsernameWhenUserDoesntExist() {


        when(userRepository.findUserByUsername("men")).thenReturn(null);
        assertEquals(null,userService.findUserByUsername("men"));
    }

    @Test
    public void findUserByEmail() {

        User user=new User();
        user.setEmail("eridan.sarygulov@iaau.edu.kg");

        when(userRepository.findByEmail("eridan.sarygulov@iaau.edu.kg")).thenReturn(user);
        assertEquals(user,userService.findUserByEmail("eridan.sarygulov@iaau.edu.kg"));

    }

    @Test
    public void findUserByEmailWhenUserDoesntExist() {


        when(userRepository.findByEmail("eridan.sarygulov@iaau.edu.kg")).thenReturn(null);
        assertEquals(null,userService.findUserByEmail("eridan.sarygulov@iaau.edu.kg"));

    }

    @Test
    public void findUserByReset_token() {
    }

    @Test
    public void findTopLawyers() {
    }

    @Test
    public void findActiveLawyersByPeriod() {
    }

    @Test
    public void findByUserType() {
    }
}