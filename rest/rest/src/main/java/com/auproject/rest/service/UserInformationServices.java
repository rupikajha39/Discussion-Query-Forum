package com.auproject.rest.service;

import com.auproject.rest.model.UserInformation;
import com.auproject.rest.repository.UserInformationRepo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
//changes to be donw constant
@Service
public class UserInformationServices {
    @Autowired
    private UserInformationRepo userinformationrepo;

    public String login(UserInformation user) {
        Optional<UserInformation> id=userinformationrepo.findById(user.getId());
        if(id.isEmpty()){
            return "User doesn't exist";
        }
        else{

            String encryptedPassword=user.getPassword();
            if(StringUtils.isNotEmpty(user.getPassword()) && encryptedPassword.equals(id.get().getPassword()) )
            {
                return "User matched";
            }
            else
            {
                return "Incorrect password";
            }
        }

    }

    public String register(UserInformation user) {
        Optional<UserInformation> id=userinformationrepo.findById(user.getId());
        if(id.isEmpty()) {

            try {

                userinformationrepo.save(user);
                return "User inserted into table";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error";
            }
        }
        else{
            return "User already exist";
        }
    }


    public Boolean updateUser(UserInformation user) {
        try {

            userinformationrepo.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<UserInformation> getUser(int userId) {
        return this.userinformationrepo.findById(userId);
    }
}
