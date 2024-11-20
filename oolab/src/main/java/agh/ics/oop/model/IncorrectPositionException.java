package agh.ics.oop.model;

public class IncorrectPositionException extends Exception {

    private final Vector2d position;

    public IncorrectPositionException(Vector2d position) {
        super("Position" + "(" + position.getX() + "," + position.getY() + ")" + "is not correct");
        this.position = position;
    }
}



// popraw mapa od -int do int trawa jest losowana tylko od 0 do int ale zwirzaki mogą chodzić jak chcą