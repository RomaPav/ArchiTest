package com.example.lab4.repository;

import com.example.lab4.model.Entity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   user
  @project   lab4
  @class  EntityRepositoryTest
  @version  1.0.0 
  @since 12.03.2024 - 17.53
*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataMongoTest
class EntityRepositoryTest {
    @Autowired
    EntityRepository underTest;

    @BeforeEach
    void setUp() {
            List<Entity> items = List.of(
                    new Entity("1", "John", "test", LocalDateTime.now(),null),
                    new Entity("2", "Paul", "test", LocalDateTime.now(),null),
                    new Entity("3", "Freddie", "test", LocalDateTime.now(),null)
            );
            underTest.saveAll(items);
    }

    @AfterEach
    void tearDown() {
        List<Entity> entities=underTest.findAll()
                .stream()
                .filter(item -> item.getDescription().contains("test"))
                .toList();
        underTest.deleteAll(entities);
    }

    @Test
    void itShouldCheckThrCollectionIsNotEmpty() {
        assertFalse(underTest.findAll().isEmpty());
        List<Entity> entities = underTest.findAll()
                .stream().filter(item -> item.getDescription().contains("test"))
                .toList();
        assertEquals(entities.size(), 3);
    }

    @Test
    void itShouldSaveEntity() {
        Entity testEntity = new Entity("Test", "0004");
        underTest.save(testEntity);
        Entity forTest = underTest.findAll().stream()
                .filter(item -> item.getName().equals("Test"))
                .filter(item -> item.getDescription().contains("0004"))
                .findAny()
                .orElse(null);
        assertNotNull(forTest);
        assertNotNull(forTest.getId());
        assertFalse(forTest.getId().isEmpty());
        assertEquals(forTest.getDescription(), "0004");
        underTest.delete(testEntity);
    }

    @Test
    void itShouldUpdateEntity() {
        Entity testEntity = new Entity("1", "Roma", "test", LocalDateTime.now(), LocalDateTime.now());
        underTest.save(testEntity);
//        Entity forTest = underTest.findAll().stream()
//                .filter(item -> item.getName().equals("Roma"))
//                .filter(item -> item.getDescription().contains("test"))
//                .findAny()
//                .orElse(null);
        Entity forTest = underTest.getEntityById("1");
        assertNotNull(forTest.getId());
        assertFalse(forTest.getId().isEmpty());
        assertEquals(forTest.getName(),"Roma");
        assertEquals(forTest.getDescription(), "test");
    }

    @Test
    void itShouldDeleteEntity() {
        Entity testEntity = new Entity("1", "John", "test", LocalDateTime.now(), null);
        underTest.delete(testEntity);
//        Entity forTest = underTest.findAll().stream()
//                .filter(item -> item.getName().equals("Roma"))
//                .filter(item -> item.getDescription().contains("test"))
//                .findAny()
//                .orElse(null);
        Entity forTest = underTest.getEntityById("1");
        assertNull(forTest);
    }
}