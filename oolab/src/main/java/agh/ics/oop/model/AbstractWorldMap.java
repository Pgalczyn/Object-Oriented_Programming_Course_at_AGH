package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {


    public Map<Vector2d,Animal> animals = new HashMap<Vector2d,Animal>();
    public Map<Vector2d,Grass> grassMap = new HashMap<>();

    public boolean place(Animal animal) {

        if(canMoveTo(animal.getLocation())){
            animals.put(animal.getLocation(), animal);
            return true;
        }
        return false;

    }
    public void move(Animal animal, MoveDirection direction) {

        if (animals.containsValue(animal)) {

            Vector2d location = animal.getLocation();
            animal.move(direction,this);
            animals.remove(location);
            animals.put(animal.getLocation(), animal);

        }

    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public Collection<WorldElement> getElements(){

        Collection<WorldElement> elements = new ArrayList<WorldElement>();
        elements.addAll(animals.values());

        return elements;
    }

}
