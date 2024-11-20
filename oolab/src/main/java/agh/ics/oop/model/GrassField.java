package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

import static java.lang.Math.sqrt;


public  class GrassField extends AbstractWorldMap{


    private final int numberOfGrassFields;
    public  final Vector2d lowerBound = new Vector2d(0,0);
    public GrassField(int numberOfGrassFields) {
        this.numberOfGrassFields = numberOfGrassFields;

        Random rand = new Random();
        int i = 0;
        List<Vector2d> points = new ArrayList<Vector2d>();
        while (i < numberOfGrassFields){
            int x = rand.nextInt((int) sqrt(numberOfGrassFields * 10));
            int y = rand.nextInt((int) sqrt(numberOfGrassFields * 10));

            Vector2d newPoint = new Vector2d(x, y);
            boolean flaga = false;
            for (Vector2d point : points){
                if (point.equals(newPoint)){
                    flaga = true;
                    break;
                }
            }
            if (!flaga){
                points.add(newPoint);
                grassMap.put(newPoint,new Grass(newPoint));
                i += 1;
            }
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null) return animals.get(position);
        if (grassMap.get(position) != null) return grassMap.get(position);
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        return position.follows(lowerBound)  && !(objectAt(position) instanceof Animal);
    }


    @Override
    public String toString() {

        Vector2d lowLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(0, 0);

        for (Vector2d location : animals.keySet()) {

            lowLeft = lowLeft.lowerLeft(location);
             upperRight = upperRight.upperRight(location);
        }

        for (Vector2d location : grassMap.keySet()) {
            lowLeft = lowLeft.lowerLeft(location);
            upperRight = upperRight.upperRight(location);
        }

        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowLeft, upperRight);

    }

    @Override
    public Collection<WorldElement> getElements() {
        List<WorldElement> elements = (List<WorldElement>) super.getElements();
        elements.addAll(grassMap.values());
        return elements;
    }
}
