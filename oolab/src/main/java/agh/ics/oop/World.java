package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {
    try {
       // List<MoveDirection> directions = OptionsParser.parse(args);
        //List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(2, 9));
        //AbstractWorldMap map = new GrassField(10,1);
        //AbstractWorldMap map1 = new RectangularMap(10,10,2);

        //map1.addMapChangeListener(new ConsoleMapDisplay());
        //map1.addMapChangeListener(new SimulationPresenter());
        //Simulation simulation = new Simulation(   positions, directions, map);
        //simulation.run();
        //List<Simulation> simulations = new ArrayList<>();
//        simulations.add(new Simulation(positions, directions, map));
////        simulations.add(new Simulation(positions, directions, map));
//        for(int i = 0; i < 100; i++){
//            AbstractWorldMap map = new GrassField(10,i);
//            map.addMapChangeListener(new ConsoleMapDisplay());
//            simulations.add(new Simulation(positions, directions, map));
//
//        }
//
//        SimulationEngine engine = new SimulationEngine(simulations);
//        engine.runAsync();

        Application.launch(SimulationApp.class, args);


//        try {
//            engine.awaitSimulationsEnd();
//        } catch (InterruptedException e) {
//           e.printStackTrace();
//        }
    }
    catch (IllegalArgumentException e) {
        e.printStackTrace();
    }
    System.out.println("System zakonczyl dzialanie");

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

