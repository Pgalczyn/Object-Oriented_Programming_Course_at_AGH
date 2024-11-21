package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {


    protected Map<Vector2d,Animal> animals = new HashMap<Vector2d,Animal>();


    public void place(Animal animal) throws IncorrectPositionException{

        if(canMoveTo(animal.getLocation())){
            animals.put(animal.getLocation(), animal);

        }
        else throw new IncorrectPositionException(animal.getLocation());

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
