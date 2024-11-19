package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    GrassField map = new GrassField(10);


    @Test
    public void differentPlacesForGrasses(){
        GrassField grasses = new GrassField(10);

        for (Vector2d grass : grasses.grassMap.keySet()){

            for (Vector2d grass1 : grasses.grassMap.keySet()) {
                if (grass != grass1) assertNotEquals(grass, grass1);
            }
        }


    }



    @Test
    public void placeTest() {

        Animal animal = new Animal(new Vector2d(1,1));
        Animal animal2 = new Animal(new Vector2d(5,5));

        map.animals.put(animal.getLocation(),animal);
        map.animals.put(animal2.getLocation(),animal2);

        assertTrue(map.place(new Animal(new Vector2d(2,5))));
        assertTrue(map.place(new Animal(new Vector2d(1,5))));
        assertFalse(map.place(new Animal(new Vector2d(1,1))));
        assertFalse(map.place(new Animal(new Vector2d(5,5))));
    }

    @Test
    public void moveTest() {
        Animal animal = new Animal(new Vector2d(2,1));
        Animal animal1 = new Animal(new Vector2d(3,3));
        Animal animal2 = new Animal(new Vector2d(9,8));

        map.place(animal);
        map.place(animal1);
        map.place(animal2);

        animal.move(MoveDirection.FORWARD,map);

        assertEquals(new Vector2d(2,2), animal.getLocation());

        animal1.move(MoveDirection.FORWARD,map);
        animal1.move(MoveDirection.LEFT,map);
        animal1.move(MoveDirection.FORWARD,map);
        animal1.move(MoveDirection.RIGHT,map);
        animal1.move(MoveDirection.FORWARD,map);

        assertEquals(new Vector2d(2,5), animal1.getLocation());

        animal2.move(MoveDirection.FORWARD,map);
        animal2.move(MoveDirection.FORWARD,map);
        animal2.move(MoveDirection.FORWARD,map);
        animal2.move(MoveDirection.FORWARD,map);
        animal2.move(MoveDirection.FORWARD,map);

        assertEquals(new Vector2d(9,9), animal2.getLocation());
    }

    @Test
    public void isOcuupiedTest(){

        Animal animal = new Animal(new Vector2d(2,1));
        Animal animal1 = new Animal(new Vector2d(3,3));
        Animal animal2 = new Animal(new Vector2d(9,8));

        map.place(animal);
        map.place(animal1);
        map.place(animal2);

        assertTrue(map.isOccupied(new Vector2d(2,1)));
        assertTrue(map.isOccupied(new Vector2d(3,3)));
        assertTrue(map.isOccupied(new Vector2d(9,8)));
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));

    }

    @Test
    public void objectAtTest(){

        Animal animal = new Animal(new Vector2d(2,1));
        Animal animal1 = new Animal(new Vector2d(3,3));
        Animal animal2 = new Animal(new Vector2d(9,8));

        map.place(animal);
        map.place(animal1);
        map.place(animal2);

        assertEquals(animal,map.objectAt(new Vector2d(2,1)));
        assertEquals(animal1,map.objectAt(new Vector2d(3,3)));
        assertEquals(animal2,map.objectAt(new Vector2d(9,8)));
        assertNull(map.objectAt(new Vector2d(9, 2)));
    }

    @Test
    public void canMovetoTest(){

        Animal animal = new Animal(new Vector2d(2,1));
        Animal animal1 = new Animal(new Vector2d(3,3));
        Animal animal2 = new Animal(new Vector2d(9,8));

        Grass grass = new Grass(new Vector2d(2,2));
        Grass grass1 = new Grass(new Vector2d(3,3));
        Grass grass2 = new Grass(new Vector2d(9,8));
        Grass grass3 = new Grass(new Vector2d(2,2));

        map.grassMap.put(grass.getLocation(),grass);
        map.grassMap.put(grass1.getLocation(),grass1);
        map.grassMap.put(grass2.getLocation(),grass2);
        map.grassMap.put(grass3.getLocation(),grass3);

        map.place(animal);
        map.place(animal1);
        map.place(animal2);

        assertTrue(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(3,4)));

        assertFalse(map.canMoveTo(new Vector2d(9,8)));
        assertFalse(map.canMoveTo(new Vector2d(2,1)));

        assertFalse(map.canMoveTo(new Vector2d(-1,-1)));


    }

}