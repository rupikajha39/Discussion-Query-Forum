package com.auproject.rest.repository;

import com.auproject.rest.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer,Integer> {
    @Query(value = "Select * from answer where questionid=:id and isarchive=false order by timestamp desc, id desc", nativeQuery = true)
    List<Answer> getAnswersByQuestion(@Param("id") int id);
}
