package com.auproject.rest.serviceTest;

import com.auproject.rest.model.Notification;
import com.auproject.rest.repository.EmailRepo;
import com.auproject.rest.repository.NotificationRepo;
import com.auproject.rest.repository.UserInformationRepo;
import com.auproject.rest.repository.UserTopicRepo;
import com.auproject.rest.service.EmailNotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EmailNotificationServiceTest {

    @MockBean
    private EmailRepo emailRepo;

    @MockBean
    private NotificationRepo notificationRepo;

    @Autowired
    private EmailNotificationService emailNotificationService;

    @MockBean
    private UserTopicRepo userTopicRepo;

    @MockBean
    private UserInformationRepo userInformationRepo;

    @Test
    public void testShowNotification() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification(1,1,"Hello","2021-02-04",false));
        notifications.add(new Notification(1,1,"Again Hello","2021-02-04",false));

        Mockito.when(notificationRepo.findByUserId(1)).thenReturn(notifications);

        assert (emailNotificationService.showNotifications(1)).equals(notifications);
    }



}