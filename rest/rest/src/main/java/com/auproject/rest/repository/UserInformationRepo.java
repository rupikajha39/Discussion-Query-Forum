package com.auproject.rest.repository;

import com.auproject.rest.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface UserInformationRepo extends JpaRepository<UserInformation,Integer> {

    @Query(value = "Select email from userinformation where id in :userId",nativeQuery = true)
    List<String> getEmailByUserId(@Param("userId") List<Integer> userId);
}
