package agh.ics.oop.model;

public class Animal {
    MapDirection orientation;
    Vector2d location;

    public Animal() {

        this.orientation = MapDirection.NORTH;
        this.location = new Vector2d(2,2);


    }

    public Animal(Vector2d vector){
        this.orientation = MapDirection.NORTH;
        this.location = vector;
    }

    @Override
    public String toString() {
        return "Animal [orientation=" + orientation + ", location=" + location + "]";
    }

    public boolean IsAt(Vector2d position){

    return location.equals(position);

    }

    public void move(MoveDirection direction){

        switch (direction){

            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case BACKWARD -> this.location = this.location.subtract(this.orientation.toUnitVector());
            case FORWARD -> this.location = this.location.add(this.orientation.toUnitVector());
        }



    }

}
