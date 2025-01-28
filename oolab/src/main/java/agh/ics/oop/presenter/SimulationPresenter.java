package agh.ics.oop.presenter;
import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.awt.*;
import java.util.List;


public class SimulationPresenter implements MapChangeListener {
    WorldMap worldMap;

    @FXML
    private Button startButton;

    @FXML
    private GridPane mapGrid;

    @FXML
    private TextField movesInput;

    @FXML
    private Label infoLabel;

    int maxX;
    int maxY;
    int minX;
    int minY;
    int mapWidth;
    int mapHeight;
    int colWidth = 30;
    int colHeight = 30;


    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void setMapGrid(GridPane mapGrid) {
        mapGrid.getColumnConstraints().add(new ColumnConstraints(colWidth));
        mapGrid.getRowConstraints().add(new RowConstraints(colHeight));
        mapGrid.setGridLinesVisible(true);
        Label label = new Label("y/x");
        mapGrid.add(label,0,0);
        GridPane.setHalignment(label, HPos.CENTER);
    }

    public void getBounds(){
        maxX = worldMap.getCurrentBounds().highRightBoundary().getX();
        maxY = worldMap.getCurrentBounds().highRightBoundary().getY();
        minX = worldMap.getCurrentBounds().lowLeftBoundary().getX();
        minY = worldMap.getCurrentBounds().lowLeftBoundary().getY();
        mapWidth = maxX - minX + 1;
        mapHeight = maxY - minY + 1;

    }

    public void columnsLabels(){
        for(int i = 0; i<mapWidth; i++){

            Label label = new Label(Integer.toString(i + minX));
            mapGrid.add(label,i+1,0);
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(colWidth));
            mapGrid.getRowConstraints().add(new RowConstraints(colHeight));
        }
    }

    public void rowsLabels(){
        for(int i = 0; i<mapHeight; i++){
            Label label = new Label(Integer.toString(i + minY));
            mapGrid.add(label,0,i+1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

    public void addEmlementsToGrid(){

        for(int i = minX; i<=maxX; i++){
            for(int j = minY; j<=maxY; j++){
                Vector2d vector = new Vector2d(i, j);
                if(worldMap.isOccupied(vector)){
                    Label label = new Label(worldMap.objectAt(vector).toString());
                    mapGrid.add(label, i+1 - minX, j+1 -minY);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                else {
                    Label label = new Label(" ");
                    mapGrid.add(label, i+1 -minX, j+1 -minY);
                    GridPane.setHalignment(label, HPos.CENTER);
                }

            }
        }

    }
    private void clearGrid() {
        if (!mapGrid.getChildren().isEmpty()) {
            mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        } // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void drawMap(){
        setMapGrid(mapGrid);
        getBounds();
        columnsLabels();
        rowsLabels();
        addEmlementsToGrid();
    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        this.setWorldMap(worldMap);
        Platform.runLater(()->{
            clearGrid();
            drawMap();
        });

    }
    @FXML
    public void onSimulationStartClicked() {
       // System.out.println("Button clicked!");
        String directionsList = movesInput.getText();
        java.util.List<MoveDirection> directions = OptionsParser.parse(directionsList.split(" "));
        java.util.List<Vector2d> positions = List.of(new Vector2d(-2, 2), new Vector2d(2, 9));
        //AbstractWorldMap map = new GrassField(10,1);
        AbstractWorldMap map1 = new GrassField(10,1);
        //map1.addMapChangeListener(new ConsoleMapDisplay());
        //map1.addMapChangeListener(new SimulationPresenter());
        map1.addMapChangeListener(this);  // Prezenter jako obserwator mapy

        // Przekazanie mapy do kontrolera

        Simulation simulation = new Simulation(positions, directions, map1);
        SimulationEngine engine = new SimulationEngine(List.of(simulation));

        engine.runAsync();
    }
}
