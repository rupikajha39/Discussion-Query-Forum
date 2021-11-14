package com.auproject.rest.repository;

import com.auproject.rest.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

    //according to topic
    @Query(value = "select * from question where topicid = :id order by timestamp desc", nativeQuery = true)
    List<Question> getQuestionByTopic(@Param("id") int id);

    ///get all question for subscribed topic for particular id
    @Query(value = "select * from question where topicid in (select topicid from usertopic where userid =:userId) order by timestamp desc", nativeQuery = true)
    List<Question> getAllQuestion(@Param("userId") int userId);

    //get question by questionid
    @Query(value = "select * from question where id = :quesId order by timestamp desc", nativeQuery = true)
    Question getQuestionById(@Param("quesId") int quesId);

    //get all those question which are asked by userid
    @Query(value = "select * from question where userid = :userId order by timestamp desc", nativeQuery = true)
    List<Question> getQuestionByUserId(@Param("userId") int userId);

    //get Question values for notfication
    @Query(value = "select * from question where id =:questionId", nativeQuery = true)
    Question search(@Param("questionId") int questionId);

    //get all question which are asked by userid according to topicid
    @Query(value = "select * from question where topicid = :topicId and userid=:userId order by timestamp desc", nativeQuery = true)
    List<Question> getQuestionByTopicUser(@Param("userId") int userId,@Param("topicId") int topicId);


}
