package law.advisor;


import law.advisor.model.Role;
import law.advisor.model.User;
import law.advisor.model.UserRole;
import law.advisor.repository.UserRepository;
import law.advisor.repository.UserRoleRepository;
import law.advisor.service.UserDetailsServiceImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public @RunWith(MockitoJUnitRunner.class)
    class UserDetailsServiceImplUnitTests {

    @Mock
    UserRepository userRepository;

    @Mock
    UserRoleRepository userRoleRepository;

    @InjectMocks
    UserDetailsServiceImpl userDetails;



    // this unit test is for method loadUserByUsername() in the class UserDetailsServiceImpl.java
    @Test
    public void testLoadUserByUsername() {
        User user = new User();
        user.setUsername("a7xsg");
        user.setEncryted_password("$2y$12$P7wTAW/tKA41z/XPi9Cg/.wPqNHFRvNuMyd3wKYe/dfWkAM3Pwg.m");

        Role role = new Role();
        role.setName("LAWYER");


        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        ArrayList<UserRole> list = new ArrayList<>();
        list.add(userRole);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole().getName());
        grantList.add(authority);


        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), //
                ((law.advisor.model.User) user).getEncryted_password(), grantList);

        when(userRepository.findUserByUsername("a7xsg")).thenReturn(user);
        when(userRoleRepository.findAllByUser(user)).thenReturn(list);

        UserDetailsServiceImpl service = new UserDetailsServiceImpl();
        assertEquals(userDetails, service.loadUserByUsername("a7xsg"));

    }
}
