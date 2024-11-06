package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {


    @Test
    public void OrientationTest_1() {

        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 0));
        List<MoveDirection> directions = List.of(MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD);

        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        for (Animal animal : animals) {

            assertEquals(MapDirection.WEST, animal.getOrientation());
        }
        simulation.run();
        animals = simulation.getAnimals();

        for (Animal animal : animals) {

            assertEquals(MapDirection.SOUTH, animal.getOrientation());
        }
    }

    @Test
    public void OrientationTest_2() {
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 0));
        List<MoveDirection> directions = List.of(MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT);

        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        for (Animal animal : animals) {

            assertEquals(MapDirection.NORTH, animal.getOrientation());
        }
    }


    @Test
    public void DirectionTest_1() {
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions =
                List.of(
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.BACKWARD,
                        MoveDirection.FORWARD
                );


        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).IsAt(new Vector2d(0, 4)));
        assertFalse(animals.get(0).IsAt(new Vector2d(4, 0)));

    }

    @Test
    public void DirectionTest_2() {

        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions =
                List.of(
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.RIGHT,
                        MoveDirection.FORWARD,
                        MoveDirection.BACKWARD,
                        MoveDirection.LEFT,
                        MoveDirection.BACKWARD
                );


        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).IsAt(new Vector2d(0, 1)));

    }

    @Test
    public void animalOutOfMap_1() {

        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions =
                List.of(
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD
                );


        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).getLocation().precedes(new Vector2d(5, 5)));
        assertTrue(animals.get(0).getLocation().follows(new Vector2d(-1, -1)));

    }

    @Test
    public void animalOutOfMap_2() {

        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions =
                List.of(
                        MoveDirection.LEFT,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD
                );


        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).getLocation().precedes(new Vector2d(5, 5)));
        assertTrue(animals.get(0).getLocation().follows(new Vector2d(-1, -1)));


    }

    @Test
    public void animalOutOfMap_3() {

        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions =
                List.of(
                        MoveDirection.RIGHT,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD,
                        MoveDirection.FORWARD
                );


        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).getLocation().precedes(new Vector2d(5, 5)));
        assertTrue(animals.get(0).getLocation().follows(new Vector2d(-1, -1)));


    }

    @Test
    public void animalOutOfMap_4() {

        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions =
                List.of(
                        MoveDirection.BACKWARD,
                        MoveDirection.BACKWARD,
                        MoveDirection.BACKWARD,
                        MoveDirection.BACKWARD
                );


        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).getLocation().precedes(new Vector2d(5, 5)));
        assertTrue(animals.get(0).getLocation().follows(new Vector2d(-1, -1)));


    }


    @Test
    public void movesTest() {
        String[] keyboard = new String[]{"f", "l", "r", "b"};

        List<MoveDirection> directions = OptionsParser.parse(keyboard);

        List<Vector2d> positions = List.of(new Vector2d(0, 0));

        Simulation simulation = new Simulation(positions, directions,new RectangularMap(10,10));
        simulation.run();

        assertEquals(directions, simulation.getMoves());


    }
}