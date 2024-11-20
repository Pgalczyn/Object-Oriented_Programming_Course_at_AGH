package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static List<MoveDirection> parse(String[] args){

        List<MoveDirection> moves = new ArrayList<MoveDirection>();

        for(String arg : args) {
            try {
                switch (arg) {

                    case "f":
                        moves.add(MoveDirection.FORWARD);
                        break;
                    case "b":
                        moves.add(MoveDirection.BACKWARD);
                        break;
                    case "r":
                        moves.add(MoveDirection.RIGHT);
                        break;
                    case "l":
                        moves.add(MoveDirection.LEFT);
                        break;
                    default:
                        throw new IllegalArgumentException(arg + " is not legal move specification");


                }

            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return moves;
    }

}
