package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {

    protected MapVisualizer map = new MapVisualizer(this);
    protected Map<Vector2d,Animal> animals = new HashMap<Vector2d,Animal>();
    protected final List<MapChangeListener> listeners = new ArrayList<>();
    protected  int mapId;

    public AbstractWorldMap(int mapId) {
        this.mapId = mapId;
    }

    public void addMapChangeListener(MapChangeListener listener) {
        listeners.add(listener);
    }
    public void removeMapChangeListener(MapChangeListener observer) {
        listeners.remove(observer);
    }

    public void notifyMapChanged(String string){
        for(MapChangeListener listener : listeners){
            listener.mapChanged(this,string);
        }
    }


    public void place(Animal animal) throws IncorrectPositionException{

        if(canMoveTo(animal.getLocation())){
            animals.put(animal.getLocation(), animal);
            notifyMapChanged("zmieniona pozycja zwierzaka"+ animal.getLocation());
        }
        else throw new IncorrectPositionException(animal.getLocation());

    }
    public void move(Animal animal, MoveDirection direction) {

        if (animals.containsValue(animal)) {

            Vector2d location = animal.getLocation();
            animal.move(direction,this);
            animals.remove(location);
            animals.put(animal.getLocation(), animal);
            notifyMapChanged("zmieniona pozycja zwierzaka"+ animal.getLocation());
        }

    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public Collection<WorldElement> getElements(){

        Collection<WorldElement> elements = new ArrayList<WorldElement>();
        elements.addAll(animals.values());

        return elements;
    }

    public abstract Boundary getCurrentBounds();


    @Override
    public String toString() {

        return map.draw(this.getCurrentBounds().lowLeftBoundary(), this.getCurrentBounds().highRightBoundary());

    }

    @Override
    public int getId() {
        return this.mapId;
    }
}
