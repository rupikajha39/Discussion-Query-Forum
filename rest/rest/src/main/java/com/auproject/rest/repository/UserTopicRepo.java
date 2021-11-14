package com.auproject.rest.repository;

import com.auproject.rest.model.UserTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserTopicRepo extends JpaRepository<UserTopic,Integer> {


    @Transactional
    @Modifying
    @Query(value= "Insert into usertopic (topicid,userid,topicname) values(:topicid,:userid,:topicname)",nativeQuery = true)
    void insert(@Param("topicid") int topicid,@Param("userid") int userid,@Param("topicname") String topicname);

    @Transactional
    @Modifying
    @Query(value="Delete from usertopic where userid=:userid",nativeQuery = true)
    void deleteByUserId(@Param("userid") int userid);

    @Query(value="Select userid from usertopic where topicid=:topicId", nativeQuery = true)
    List<Integer> getUserIdByTopicId(@Param("topicId") int topicId);

}
