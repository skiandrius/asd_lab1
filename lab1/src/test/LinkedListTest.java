package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
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
        assertEquals(0, listString.size());
        listString.add("000");
        assertEquals(1, listString.size());
    }
    
    @Test
    void testIsEmpty() {
        assertTrue(listString.isEmpty());
        listString.add("000");
        assertFalse(listString.isEmpty());
    }
    
    @Test
    void testRemoveObject() {
        assertFalse(listString.remove("000"));
        listString.add("000");
        listString.add("111");
        listString.add("222");
        listString.add("333");
        listString.add("444");
        assertTrue(listString.remove("000"));
        assertTrue(listString.remove("444"));
        assertTrue(listString.remove("222"));
        assertTrue(listString.remove("111"));
        assertTrue(listString.remove("333"));
        
        listString.add("OOO");
        assertFalse(listString.remove("AAA"));
    }
    
    @Test
    void testRemoveByIndex() {
        Throwable exceptionEmpty1 = assertThrows(IndexOutOfBoundsException.class, () -> listString.remove(0));
        Throwable exceptionEmpty2 = assertThrows(IndexOutOfBoundsException.class, () -> listString.remove(-1));
        Throwable exceptionEmpty3 = assertThrows(IndexOutOfBoundsException.class, () -> listString.remove(1));
        assertEquals("Index is out of range.", exceptionEmpty1.getMessage());
        assertEquals("Index is out of range.", exceptionEmpty2.getMessage());
        assertEquals("Index is out of range.", exceptionEmpty3.getMessage());
        
        listString.add("000");
        listString.add("111");
        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> listString.remove(2));
        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> listString.remove(-1));
        assertEquals("Index is out of range.", exception1.getMessage());
        assertEquals("Index is out of range.", exception2.getMessage());
        
        listString.add("222");
        listString.add("333");
        listString.add("444");
        assertEquals("000", listString.remove(0));
        assertEquals("444", listString.remove(3));
        assertEquals("222", listString.remove(1));
        assertEquals("111", listString.remove(0));
        assertEquals("333", listString.remove(0));
    }

    @Test
    void testGet() {
        IndexOutOfBoundsException exceptionEmpty1 = assertThrows(IndexOutOfBoundsException.class, () -> listString.get(0));
        IndexOutOfBoundsException exceptionEmpty2 = assertThrows(IndexOutOfBoundsException.class, () -> listString.get(-1));
        IndexOutOfBoundsException exceptionEmpty3 = assertThrows(IndexOutOfBoundsException.class, () -> listString.get(1));
        assertEquals("Index is out of range.", exceptionEmpty1.getMessage());
        assertEquals("Index is out of range.", exceptionEmpty2.getMessage());
        assertEquals("Index is out of range.", exceptionEmpty3.getMessage());
        
        listString.add("000");
        assertEquals("000", listString.get(0));
        
        listString.add("111");
        assertEquals("111", listString.get(1));
        assertEquals("000", listString.get(0));
    }
    
    @Test
    void testSet() {
        IndexOutOfBoundsException exceptionEmpty1 = assertThrows(IndexOutOfBoundsException.class, () -> listString.set(-1, "000"));
        assertEquals("Index is out of range.", exceptionEmpty1.getMessage());
        IndexOutOfBoundsException exceptionEmpty2 = assertThrows(IndexOutOfBoundsException.class, () -> listString.set(1, "000"));
        assertEquals("Index is out of range.", exceptionEmpty2.getMessage());
        
        listString.add("000");
        assertEquals("000", listString.set(0, "111"));
        
        listString.add("222");
        assertEquals("111", listString.set(0, "333"));
        
        assertEquals("222", listString.set(1, "333"));
    }
    
    @Test
    void testContains() {
        assertFalse(listString.contains("000"));
        
        listString.add("000");
        assertTrue(listString.contains("000"));
        assertFalse(listString.contains("222"));
        
        listString.add("111");
        assertTrue(listString.contains("111"));
        assertTrue(listString.contains("000"));
        assertFalse(listString.contains("222"));
    }
    
    @Test
    void testIndexOf() {
        assertEquals(-1, listString.indexOf("000"));
        listString.add("000");
        assertEquals(0, listString.indexOf("000"));
        listString.add("111");
        assertEquals(1, listString.indexOf("111"));
        assertEquals(-1, listString.indexOf("222"));
    }
    
    @Test
    void clear() {
        listString.clear();
        assertEquals(0, listString.size());
        
        listString.add("000");
        assertEquals(1, listString.size());
        listString.clear();
        assertEquals(0, listString.size());
    }
}
