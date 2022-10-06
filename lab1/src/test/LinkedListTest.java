package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.LinkedList;

class LinkedListTest {
    LinkedList<String> listString;
    
    @BeforeEach
    void init() {
        listString = new LinkedList<String>();
    }
    
    @Test
    void testAddFirst() {
        assertTrue(listString.add("AAA"));
    }
    
    @Test
    void testAddSecond() {
        listString.add("000");
        assertTrue(listString.add("111"));
    }
    
    @Test
    void testSize() {
        assertEquals(listString.size(), 0);
        listString.add("000");
        assertEquals(listString.size(), 1);
    }
    
    @Test
    void testIsEmpty() {
        assertTrue(listString.isEmpty());
        listString.add("000");
        assertFalse(listString.isEmpty());
    }

}
