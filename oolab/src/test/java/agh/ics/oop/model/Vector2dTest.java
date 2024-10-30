package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Vectior2dTest{

    @Test
    public void equalTest(){

        assertTrue(new Vector2d(8,9).equals(new Vector2d(8,9)));

    }

    @Test
    public void toStringTest(){

        assertEquals(new Vector2d(8,9).toString(),"(8,9)");
    }

    @Test
    public void prcedeesTest(){

        assertTrue(new Vector2d(7,8).precedes(new Vector2d(8,9)));

    }

    @Test
    public void followsTest(){
        assertFalse(new Vector2d(7,8).follows(new Vector2d(8,9)));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Vector2d(9,9),new Vector2d(7,9).upperRight(new Vector2d(9,5)));
    }
    @Test
    public void lowerLeftTest(){

        assertEquals(new Vector2d(5,5),new Vector2d(5,9).lowerLeft(new Vector2d(9,5)));
    }

    @Test
    public void addTest(){

        assertEquals(new Vector2d(9,9),new Vector2d(4,4).add(new Vector2d(5,5)));

    }
    @Test
    public void subTest(){
        assertEquals(new Vector2d(10,10),new Vector2d(20,20).subtract(new Vector2d(10,10)));
    }

    @Test
    public void oppositeTest(){

        assertEquals(new Vector2d(-9,-9),new Vector2d(9,9).opposite());

    }

}
