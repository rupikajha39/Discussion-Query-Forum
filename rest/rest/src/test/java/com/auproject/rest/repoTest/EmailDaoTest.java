package com.auproject.rest.repoTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import com.auproject.rest.model.Email;
import com.auproject.rest.model.UserInformation;
import com.auproject.rest.repository.EmailRepo;
import com.auproject.rest.repository.UserInformationRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EmailDaoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private EmailRepo emailRepo;

    @Autowired
    private UserInformationRepo userInformationRepo;

    @Test
    public void testAddEmail() {
        UserInformation user = new UserInformation(1,"Test","password","test@gmail.com","Delhi");

        UserInformation userInDB = testEntityManager.persist(user);

        Email email = new Email(1,"test@gmail.com","2021-02-04","true","Test Description","TestSubject",1);

        Email savedEmail = testEntityManager.merge(email);

        Optional<Email> getEmail = emailRepo.findById(1);

        assertNotNull(getEmail);
        assertTrue(getEmail.get().getRemail().equals("test@gmail.com"));
    }

}
