package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {

    protected final List<Simulation> simulations;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync(){

        for (Simulation simulation : simulations) {
            simulation.run();
        }

    }
}
