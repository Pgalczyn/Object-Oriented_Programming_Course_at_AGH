package agh.ics.oop.model;

public interface WorldElement {


    /**
     Returns location of the object
     */

    public Vector2d getLocation();

    /**
     Returns True if object is at this location
     */
    public boolean isAt(Vector2d position);
}
