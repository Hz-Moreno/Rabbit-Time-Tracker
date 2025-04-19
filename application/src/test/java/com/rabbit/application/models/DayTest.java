package com.rabbit.application.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@ActiveProfiles("test")
public class DayTest{
    @Autowired
    private TestEntityManager entityManager;

    private Client client;
    private Day day;

    @BeforeEach
    void setUp(){
        client = new Client("test@example", "testuser", "password123");
        entityManager.persist(client);

        day = new Day("Monday", client);
        entityManager.persist(day);

        client.getDays().add(day);
        entityManager.flush();
    }

    @Test
    void testCreateDaySuccess(){
        Day foundDay = entityManager.find(Day.class, day.getId());

        assertNotNull(foundDay);
        assertEquals("Monday", foundDay.getTitle());
        assertEquals(client.getId(), foundDay.getClient().getId());
        assertEquals(2, foundDay.getTasks().size());
    }
}