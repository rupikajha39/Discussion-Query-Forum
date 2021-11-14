package com.auproject.rest.serviceTest;
import com.auproject.rest.model.UserInformation;
import com.auproject.rest.repository.UserInformationRepo;
import com.auproject.rest.service.UserInformationServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class UserInformationServiceTest {

    @Autowired
    private UserInformationServices userInformationServices;


    @MockBean
    private UserInformationRepo userInformationRepo;


    @Test
    public void loginTest(){
        UserInformation user= new UserInformation(1001,"Niket Jain","niket.jain@accolitedigital.com","qwerty","Delhi");
        Mockito.when(userInformationRepo.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        assert(userInformationServices.login(user)).equals("User matched");
    }

    @Test
    public void registerTest(){
        UserInformation user= new UserInformation(1001,"Niket Jain","niket.jain@accolitedigital.com","qwerty","Delhi");
        Mockito.when(userInformationRepo.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        Mockito.when(userInformationRepo.save(user)).thenReturn(null);

        assert(userInformationServices.register(user)).equals("User already exist");
    }

    @Test
    public void updateTest(){
        UserInformation user= new UserInformation(1001,"Niket Jain","niket.jain@accolitedigital.com","qwerty","Delhi");
        Mockito.when(userInformationRepo.save(user)).thenReturn(null);

        assert(userInformationServices.updateUser(user)).equals(true);
    }

    @Test
    public void getUserTest(){
        UserInformation user= new UserInformation(1001,"Niket Jain","niket.jain@accolitedigital.com","qwerty","Delhi");
        Mockito.when(userInformationRepo.findById(user.getId())).thenReturn(Optional.of(user));

        assert(userInformationServices.getUser(1001)).equals(Optional.of(user));
    }


}
