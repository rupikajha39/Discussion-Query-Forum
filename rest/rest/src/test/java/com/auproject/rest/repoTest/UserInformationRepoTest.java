package com.auproject.rest.repoTest;

import com.auproject.rest.model.UserInformation;
import com.auproject.rest.repository.UserInformationRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserInformationRepoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserInformationRepo userInformationRepo;

    @Test
    public void testLogin() {
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserInformation userInformation = testEntityManager.persist(user);

        Optional<UserInformation> userInformationOptional = this.userInformationRepo.findById(userInformation.getId());
        assertNotNull(userInformationOptional);

        assertThat(userInformationOptional).isEqualTo(Optional.of(userInformation));
        assert(userInformationOptional.isPresent());
    }


}


