package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap map;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves, WorldMap map) {
        this.map = map;
        this.animals = new ArrayList<>();
        this.moves = moves;
        for(Vector2d position : initialPositions) {
            Animal animal = new Animal(position);
            if (map.place(animal)) {

                animals.add(animal);
            }
        }
    }

    public List<MoveDirection> getMoves() {
        return moves;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run() {

        int numberOfAnimals = animals.size();
        int counter = 0;
        System.out.println(map);
        for(MoveDirection movee : moves) {

            map.move(animals.get(counter % numberOfAnimals), movee);

            counter++;
            System.out.println(map);
        }

    }
}

//7. Moim zdaniem do deklaracji tablic powinniśmy używać arrayList ,poniewać dane nie są modyfikowane i zależy
// nam tylko na szybkim oddczycie.
