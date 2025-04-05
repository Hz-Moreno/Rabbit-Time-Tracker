package com.rabbit.application.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DayTest {

    @Autowired
    private TestEntityManager entityManager;

    private Client client;
    private Day monday;

    @BeforeEach
    void setUp() {
        client = new Client();
        entityManager.persist(client);

        monday = new Day("Monday", client);
        entityManager.persist(monday);

        DailyTask reading = new DailyTask("08:00", "10:00", "read");
        reading.setDay(monday);
        DailyTask lunch = new DailyTask("11:00", "12:00", "lunch");
        lunch.setDay(monday);

        monday.getTasks().add(reading);
        monday.getTasks().add(lunch);

        entityManager.persist(reading);
        entityManager.persist(lunch);
        entityManager.flush();
    }

    @Test
    void testDayCreation() {
        Day foundDay = entityManager.find(Day.class, monday.getId());

        assertNotNull(foundDay);
        assertEquals("Monday", foundDay.getTitle());
        assertEquals(client.getId(), foundDay.getClient().getId());
        assertEquals(2, foundDay.getTasks().size());
    }

    @Test
    void testTaskCreationAndRelationship() {
        List<DailyTask> tasks = monday.getTasks();

        assertEquals(2, tasks.size());

        DailyTask readingTask = tasks.get(0);
        assertEquals("08:00", readingTask.getStartTime());
        assertEquals("10:00", readingTask.getEndTime());
        assertEquals("read", readingTask.getDescription());
        assertFalse(readingTask.isCompleted());
        assertEquals(monday.getId(), readingTask.getDay().getId());
    }

    @Test
    void testTaskCompletion() {
        DailyTask lunchTask = monday.getTasks().get(1);
        lunchTask.setCompleted(true);

        entityManager.persist(lunchTask);
        entityManager.flush();

        DailyTask foundTask = entityManager.find(DailyTask.class, lunchTask.getId());
        assertTrue(foundTask.isCompleted());
    }

    @Test
    void testClientDayRelationship() {
        Client foundClient = entityManager.find(Client.class, client.getId());

        assertNotNull(foundClient.getDays());
        assertEquals(1, foundClient.getDays().size());
        assertEquals("Monday", foundClient.getDays().get(0).getTitle());
    }

    @Test
    void testTaskRemoval() {
        DailyTask taskToRemove = monday.getTasks().get(0);
        monday.getTasks().remove(taskToRemove);
        taskToRemove.setDay(null);

        entityManager.merge(monday);
        entityManager.remove(taskToRemove);
        entityManager.flush();

        Day updatedDay = entityManager.find(Day.class, monday.getId());
        assertEquals(1, updatedDay.getTasks().size());

        DailyTask removedTask = entityManager.find(DailyTask.class, taskToRemove.getId());
        assertNull(removedTask);
    }

    @Test
    void testInvalidTaskCreation() {
        DailyTask invalidTask = new DailyTask();
        invalidTask.setDay(monday);

        assertThrows(Exception.class, () -> {
            entityManager.persist(invalidTask);
            entityManager.flush();
        });
    }
}