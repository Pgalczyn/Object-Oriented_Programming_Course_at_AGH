package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    private int updateCounter;

    public ConsoleMapDisplay() {
        this.updateCounter = 0;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {

            System.out.println(message);
            System.out.println(worldMap);
            System.out.println("number of done updates: " + updateCounter);
            System.out.println(worldMap.getId());
            updateCounter++;

    }
}
