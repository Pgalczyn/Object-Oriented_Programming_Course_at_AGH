package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassTest {



    @Test
    void testGetLocation() {
        Grass grass = new Grass(new Vector2d(19,1));
        Grass grass1 = new Grass(new Vector2d(14,3));
        Grass grass2 = new Grass(new Vector2d(17,6));
        Grass grass3 = new Grass(new Vector2d(1,1));


        assertEquals(grass.getLocation(),new Vector2d(19,1));
        assertEquals(grass1.getLocation(),new Vector2d(14,3));
        assertEquals(grass2.getLocation(),new Vector2d(17,6));
        assertEquals(grass3.getLocation(),new Vector2d(1,1));

    }

    @Test
    void testIsAt() {


        Grass grass = new Grass(new Vector2d(19,1));
        Grass grass1 = new Grass(new Vector2d(14,3));
        Grass grass2 = new Grass(new Vector2d(17,6));
        Grass grass3 = new Grass(new Vector2d(1,1));

        assertTrue(grass.isAt(new Vector2d(19,1)));
        assertTrue(grass1.isAt(new Vector2d(14,3)));
        assertTrue(grass2.isAt(new Vector2d(17,6)));
        assertTrue(grass3.isAt(new Vector2d(1,1)));

        assertFalse(grass.isAt(new Vector2d(14,2)));
        assertFalse(grass1.isAt(new Vector2d(4,5)));
        assertFalse(grass2.isAt(new Vector2d(7,6)));
        assertFalse(grass3.isAt(new Vector2d(1,10)));
    }

}