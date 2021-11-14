package com.auproject.rest.repository;

import com.auproject.rest.model.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepo extends JpaRepository<Topic, Integer> {

    @Query(value="Select * from topic where topicid  in " +
            "(Select topicid from usertopic where userid=:userid) ",nativeQuery = true)
    List<Topic> getSub(@Param("userid") int userid);

    @Query(value="Select * from topic where topicid not in " +
            "(Select topicid from usertopic where userid=:userid)",nativeQuery = true)
    List<Topic>  unsubscribeTopic(@Param("userid") int userid);
}

