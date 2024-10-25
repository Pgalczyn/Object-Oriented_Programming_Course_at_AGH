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

    public MapDirection getOrientation() {
        return this.orientation;
    }

    @Override
    public String toString() {
        return " [orientation=" + orientation + ", location=" + location + "]";
    }

    public Vector2d getLocation() {
        return this.location;
    }

    public boolean IsAt(Vector2d position){

    return location.equals(position);

    }

    public void move(MoveDirection direction){

        switch (direction){

            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case BACKWARD ->{
                Vector2d newLocation = this.location.subtract(this.orientation.toUnitVector());
                if (newLocation.getX() < 5 && newLocation.getY() > -1 && newLocation.getY() < 5 && newLocation.getX() > -1){
                    location = newLocation;
                }
            }
            case FORWARD ->{
                Vector2d newLocation = this.location.add(this.orientation.toUnitVector());
                if (newLocation.getX() < 5 && newLocation.getY() > -1 && newLocation.getY() < 5 && newLocation.getX() > -1){
                    location = newLocation;
                }

                }

        }



    }

}
