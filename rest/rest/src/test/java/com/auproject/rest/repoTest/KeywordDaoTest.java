package com.auproject.rest.repoTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import com.auproject.rest.model.Keyword;
import com.auproject.rest.model.UserInformation;
import com.auproject.rest.repository.KeywordRepo;
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
public class KeywordDaoTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    KeywordRepo keywordRepo;

    @Test
    public void testCreateKeyword() {
        UserInformation user = new UserInformation(1,"Test","password","test@gmail.com","Delhi");

        UserInformation savedUser = testEntityManager.persist(user);

        Keyword keyword = new Keyword(1,"Angular","2021-02-04",1);
        testEntityManager.merge(keyword);

        Optional<Keyword> getKeywordDB = keywordRepo.findById(1);

        assertNotNull(getKeywordDB);
        //assertTrue(getKeywordDB.get().getName().equals("Angular"));
    }

    @Test
    public void testGetAllKeywords() {
        UserInformation user = new UserInformation(1,"Test","password","test@gmail.com","Delhi");

        UserInformation savedUser = testEntityManager.persist(user);

        Keyword keyword1 = new Keyword(1,"Angular","2021-02-04",1);
        Keyword keyword2 = new Keyword(2,"React","2021-02-04",1);

        testEntityManager.merge(keyword1);
        testEntityManager.merge(keyword2);

        List<Keyword> keywordList = keywordRepo.findAll();
        assertNotNull(keywordList);
    }
}
