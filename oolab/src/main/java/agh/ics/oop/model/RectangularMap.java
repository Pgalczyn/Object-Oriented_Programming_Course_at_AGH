package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    public Map<Vector2d, Animal> animals = new HashMap<>();

    private final int width;
    private final  int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean place(Animal animal) {

        if(canMoveTo(animal.getLocation())){
            animals.put(animal.getLocation(), animal);
            return true;
        }
        return false;

    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

        if (animals.containsValue(animal)) {

           Vector2d location = animal.getLocation();
           animal.move(direction,this);
            animals.remove(location);
            animals.put(animal.getLocation(), animal);

        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0)) && !isOccupied(position);
    }

    @Override
    public String toString() {
        MapVisualizer mapa = new MapVisualizer(this);
        return mapa.draw(new Vector2d(0,0),new Vector2d(width,height));

    }
}
