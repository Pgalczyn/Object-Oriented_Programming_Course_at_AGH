package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> moves;

    public Simulation(List<Vector2d> initialPosition, List<MoveDirection> moves) {
        this.animals = new ArrayList<>();
        this.moves = moves;
        for(Vector2d position : initialPosition) {

            animals.add(new Animal(position));

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
        for(MoveDirection move : moves) {

            animals.get(counter % numberOfAnimals).move(move);

            System.out.println("Zwierze:"+(counter % numberOfAnimals)+ animals.get(counter % numberOfAnimals).toString());
            counter++;
        }

    }
}

//7. Moim zdaniem do deklaracji tablic powinniśmy używać arrayList ,poniewać dane nie są modyfikowane i zależy
// nam tylko na szybkim oddczycie.
