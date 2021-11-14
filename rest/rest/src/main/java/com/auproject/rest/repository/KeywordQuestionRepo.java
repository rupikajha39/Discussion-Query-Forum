package com.auproject.rest.repository;


import com.auproject.rest.model.KeywordQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface KeywordQuestionRepo extends JpaRepository<KeywordQuestion, Integer> {

    @Transactional
    @Modifying
    @Query(value="insert into keywordquestion (keywordid,questionid,keywordname)values(:keywordid,:questionid,:keywordName);", nativeQuery = true)
    void insert(@Param("keywordid") int keywordid,@Param("questionid") int questionid,@Param("keywordName") String keywordName);

    @Query(value="Select keywordname from keywordquestion where questionid=:quesId",nativeQuery = true)
    List<String> getKeywordId(@Param("quesId") int quesId);

    @Query(value = "select  distinct q.id from question as q , keywordquestion as kq " +
            "where q.id=kq.questionid and kq.keywordid in :keywordId and q.topicid = :topicId order by q.timestamp",nativeQuery = true)
    List<Integer> getQuestionIdByKeyword(@Param("keywordId") List<Integer> keywordId, @Param("topicId") int topicId);


}
