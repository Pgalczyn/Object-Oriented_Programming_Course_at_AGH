package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    Map<Vector2d, Animal> animals = new HashMap<>();

    private final int width;
    private final  int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean place(Animal animal) {



    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }
}
