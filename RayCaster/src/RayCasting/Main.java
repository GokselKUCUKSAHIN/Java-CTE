package RayCasting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;


public class Main extends Application
{

    static final int NUMBER_OF_WALLS = 10;

    public static void main(String[] args)
    {
        launch();//init window
    }

    static Random rand = new Random();
    ArrayList<Boundary> walls = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        Rectangle backFill = new Rectangle(900, 900);
        backFill.setFill(Color.BLACK);
        backFill.setLayoutX(0);
        backFill.setLayoutY(0);
        root.getChildren().add(backFill);

        //
        //RayCast Things
        //
        //Boundary bound = new Boundary(400, 150, 400, 400);
        for (int i = 0; i < 6; i++)
        {
            int x1 = rand.nextInt(800) + 50;
            int y1 = rand.nextInt(800) + 50;
            int x2 = rand.nextInt(800) + 50;
            int y2 = rand.nextInt(800) + 50;
            walls.add(new Boundary(x1, y1, x2, y2));
        }
        //BORDERS
        walls.add(new Boundary(0, 0, 900, 0));
        walls.add(new Boundary(900, 0, 900, 900));
        walls.add(new Boundary(900, 900, 0, 900));
        walls.add(new Boundary(0, 900, 0, 0));
        //
        Particle p = new Particle();
        p.setWalls(walls);
        //
        root.setOnMouseDragged(e -> {
            p.update(e.getX(), e.getY());
        });
        for (int i = 0; i < NUMBER_OF_WALLS; i++)
        {
            root.getChildren().add(walls.get(i));
        }
        root.getChildren().addAll(p);
        //
        stage.setScene(new Scene(root, 890, 890));
        stage.setTitle("RayCasting Jellybeanci!");
        stage.setResizable(false);
        stage.show();
    }
    //END OF THE LINE @JellyBeanci
}