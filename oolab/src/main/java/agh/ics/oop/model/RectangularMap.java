package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {


    private final int width;
    private final  int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
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

    @Override
    public Collection<WorldElement> getElements() {
        return super.getElements();
    }
}
