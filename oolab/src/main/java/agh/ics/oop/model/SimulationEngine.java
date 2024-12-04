package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {

    protected final List<Simulation> simulations;
    protected final List<Thread> threads = new ArrayList<>();

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync(){

        for (Simulation simulation : simulations) {
            simulation.run();
        }

    }

    public synchronized void runAsync(){

        for (Simulation simulation : simulations) {
            Thread newSimulation = new Thread(simulation);
            threads.add(newSimulation);
            newSimulation.start();
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (Thread thread : threads) {
            thread.join();
        }
        executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        executorService.shutdown();

    }

    public void runAsyncInThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (Simulation simulation : simulations) {
            executorService.submit(simulation);
        }


    }

}
