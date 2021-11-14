package com.auproject.rest.repository;

import com.auproject.rest.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface EmailRepo extends JpaRepository<Email,Integer> {

    @Transactional
    @Modifying
    @Query(value="Insert into email (remail,timestamp,issuccess,description,subject,userid) values(:remail,:timestamp,:issuccess,:description,:subject,:userid)",nativeQuery = true)
    void insert(@Param("remail") String remail,@Param("timestamp") String timestamp,
                @Param("issuccess") Boolean issuccess,@Param("description") String description,@Param("subject") String subject,@Param("userid") int userid);
}
