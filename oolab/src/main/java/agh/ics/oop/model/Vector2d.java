package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {

    public static void main(String[] args){

        Vector2d vector = new Vector2d(5,6);

        System.out.println(vector);
    }

    final int x;
    final int y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+x+"," +y+")";
    }

    public boolean precedes(Vector2d other){

        return this.x<other.x && this.y<other.y;

    }

    public boolean follows(Vector2d other){

        return this.x>=other.x && this.y>=other.y;

    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x, this.y+other.y);
    }

    public Vector2d subtract(Vector2d other){

        return new Vector2d(this.x-other.x, this.y-other.y);
    }

    public Vector2d upperRight(Vector2d other){

        int newX = Math.max(this.x, other.x);
        int newY = Math.max(this.y, other.y);

        return new Vector2d(newX,newY);
    }

    public Vector2d lowerLeft(Vector2d other){
        int newX = Math.min(this.x, other.x);
        int newY = Math.min(this.y, other.y);
        return new Vector2d(newX,newY);
    }

    public Vector2d opposite(){

        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;

        return this.x==that.x && this.y==that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
