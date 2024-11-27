package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void placeTest() throws InterruptedException {

        Animal animal = new Animal(new Vector2d(1,1));
        Animal animal2 = new Animal(new Vector2d(5,5));

        map.animals.put(animal.getLocation(),animal);
        map.animals.put(animal2.getLocation(),animal2);
        assertDoesNotThrow(() -> map.place(new Animal(new Vector2d(2,5))));
        assertDoesNotThrow(() -> map.place(new Animal(new Vector2d(1,5))));

        IncorrectPositionException exception1 = assertThrows(IncorrectPositionException.class, () -> map.place(new Animal(new Vector2d(1,5))));
        IncorrectPositionException exception2 = assertThrows(IncorrectPositionException.class, () -> map.place(new Animal(new Vector2d(5,5))));

        assertEquals(("Position" + "(" + animal.getLocation().getX() + "," + animal.getLocation().getY() + ")" + "is not correct"),exception1.getMessage());
        assertEquals(("Position" + "(" + animal2.getLocation().getX() + "," + animal2.getLocation().getY() + ")" + "is not correct"),exception2.getMessage());

    }

    @Test
    public void moveTest() throws  IncorrectPositionException {
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

        assertEquals(new Vector2d(9,13), animal2.getLocation());
    }

    @Test
    public void isOcuupiedTest() throws IncorrectPositionException{

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
    public void objectAtTest() throws IncorrectPositionException {

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
    public void canMovetoTest() throws IncorrectPositionException {

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

    @Test
    public void getElementsTest() throws IncorrectPositionException{
        GrassField map = new GrassField(4);
        Animal animal1 = new Animal(new Vector2d(1, 1));
        Animal animal2 = new Animal(new Vector2d(2, 2));
        Grass grass1 = new Grass(new Vector2d(3, 3));
        Grass grass2 = new Grass(new Vector2d(4, 4));

        map.place(animal1);
        map.place(animal2);
        map.grassMap.put(grass1.getLocation(), grass1);
        map.grassMap.put(grass2.getLocation(), grass2);


        assertTrue(map.getElements().contains(animal1), "The map should contain the first animal");
        assertTrue(map.getElements().contains(animal2), "The map should contain the second animal");
        assertTrue(map.getElements().contains(grass1), "The map should contain the first grass");
        assertTrue(map.getElements().contains(grass2), "The map should contain the second grass");
    }

}