package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static void main(String[] args) {

        System.out.println("system wystartowal");

        MoveDirection[] directions = OptionsParser.parse(args);
        run(directions);
        System.out.println("system zakonczyl dzialanie");
    }

    public static void run(MoveDirection[] directions) {
        System.out.println("start");

        for(int i = 0; i<directions.length;i++ ){

            switch (directions[i]){

                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }

        }
        System.out.println("stop");
    }
}

