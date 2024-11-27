package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {

    public static void main(String[] args) {
    try {
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(2, 4));
        AbstractWorldMap map = new GrassField(10,1);
        AbstractWorldMap map1 = new RectangularMap(10,10,2);
        map.addMapChangeListener(new ConsoleMapDisplay());
        map1.addMapChangeListener(new ConsoleMapDisplay());
        //Simulation simulation = new Simulation(positions, directions, map);
        //simulation.run();
        List<Simulation> simulations = List.of(new Simulation(positions,directions,map), new Simulation(positions,directions,map1));
        SimulationEngine engine = new SimulationEngine(simulations);
        engine.runSync();
    }
    catch (IllegalArgumentException e) {
        e.printStackTrace();
    }
    }

    public static void run(List<MoveDirection> directions) {
        System.out.println("start");

        for(int i = 0; i<directions.size();i++ ){

            switch (directions.get(i)){

                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }

        }
        System.out.println("stop");
    }
}

