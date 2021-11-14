package com.auproject.rest.repoTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import com.auproject.rest.model.Answer;
import com.auproject.rest.model.UserInformation;
import com.auproject.rest.repository.AnswerRepo;
import com.auproject.rest.repository.UserInformationRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class AnswerDaoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private UserInformationRepo userInformationRepo;

    @Test
    public void testAddAnswer() {
        UserInformation user = new UserInformation(1,"Test","password","test@gmail.com","Delhi");

        UserInformation userInDB = testEntityManager.persist(user);

        Answer answer = new Answer(1,"Test Question",1,1,"2021-02-04",false);

        Answer savedAnswer = testEntityManager.merge(answer);
        Optional<Answer> answerFromDb = answerRepo.findById(savedAnswer.getId());

        assertNotNull(answerFromDb);
        assert(answerFromDb.isPresent());
        assertTrue(answerFromDb.get().getId() > 0);
        assertTrue(answerFromDb.get().getDescription().equals("Test Question"));
    }

    @Test
    public void testGetAnswerByQuestionId() {
        UserInformation user = new UserInformation(1,"Test","password","test@gmail.com","Delhi");

        UserInformation userInDB = testEntityManager.persist(user);

        Answer answer1 = new Answer(1,"Test Question 1",1,1,"2021-02-04",false);
        Answer answer2 = new Answer(2,"Test Question 2",1,1,"2021-02-04",false);
        Answer answer3 = new Answer(3,"Test Question 2",1,1,"2021-02-04",false);

        testEntityManager.merge(answer1);
        testEntityManager.merge(answer2);
        testEntityManager.merge(answer3);

        List<Answer> answers = answerRepo.getAnswersByQuestion(1);

        System.out.println(answers.size());
        assertTrue(answers.size() >0);

    }

    @Test
    public void testDeleteAnswer() {
        UserInformation user = new UserInformation(1,"Test","password","test@gmail.com","Delhi");

        UserInformation userInDB = testEntityManager.persist(user);

        Answer answer = new Answer(1,"Test Question",1,1,"2021-02-04",false);

        Answer savedAnswer = testEntityManager.merge(answer);
        Optional<Answer> answerFromDb = answerRepo.findById(savedAnswer.getId());

        assertNotNull(answerFromDb);
        assert(answerFromDb.isPresent());
        assertTrue(answerFromDb.get().getId() > 0);
        assertTrue(answerFromDb.get().getDescription().equals("Test Question"));
    }
}