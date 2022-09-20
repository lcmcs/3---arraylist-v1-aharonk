package edu.touro.cs.mcon364;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainTest {

    static MyArrayList ma = new MyArrayList();

    @Test
    @Order(0)
    void empty() {
        assertTrue(ma.isEmpty());
    }

    @Test
    @Order(1)
    void add() {
        assertTrue(ma.add("a"));
        assertTrue(ma.add("b"));
    }

    @Test
    @Order(2)
    void size() {
        assertEquals(2, ma.size());
        assertFalse(ma.isEmpty());
    }

    @Test
    @Order(3)
    void contains() {
        assertTrue(ma.contains("a"));
        assertFalse(ma.contains("c"));
    }

    @Test
    @Order(4)
    void addSpecific() {
        ma.add(1, "c");
        assertEquals(ma.get(1), "c");
        assertEquals(ma.get(2), "b");

        ma.add(3, "d");
        assertEquals(ma.get(3), "d");
        assertEquals(ma.get(2), "b");
    }

    @Test
    @Order(4)
    void addSpecificFail() {
        assertThrows(IndexOutOfBoundsException.class, () -> ma.add(7, "e"));
    }

    @Test
    @Order(5)
    void get() {
        assertEquals("a", ma.get(0));
        assertEquals("c", ma.get(1));
    }

    @Test
    @Order(5)
    void getFail() {
        assertThrows(IndexOutOfBoundsException.class, () ->  ma.get(7));
    }

    @Test
    @Order(6)
    void set() {
        assertEquals("a", ma.set(0, "f"));
        assertEquals("f", ma.set(0, "a"));
    }

    @Test
    @Order(6)
    void setFail() {
        assertThrows(IndexOutOfBoundsException.class, () -> ma.set(7, "g"));
    }

    @Test
    @Order(7)
    void remove() {
        assertEquals("d", ma.remove(3));
        assertEquals(3, ma.size());
    }

    @Test
    @Order(7)
    void removeFail() {
        assertThrows(IndexOutOfBoundsException.class, () -> ma.remove(3));
    }

    @Test
    @Order(8)
    void clear() {
        ma.clear();
        assertTrue(ma.isEmpty());
        assertEquals(0, ma.size());
    }
}