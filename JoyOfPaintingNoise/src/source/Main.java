package source;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application
{

    static final String title = "Joy of Painting JellyBeanci";
    static Timeline draw;
    static final int width = 500;
    static final int height = 500;
    //
    static final double res = 0.001;
    static double size = 2;

    Color color = Color.SNOW;
    static double xIn = 0;
    static double yIn = 0;
    static double rIn = 0;
    static double cRIn = 0;
    static double cGIn = 0;
    static double cBIn = 0;
    static double oIn = 0;

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.rgb(51, 51, 51), CornerRadii.EMPTY, Insets.EMPTY)));
        //
        xIn = Math.random() * 11;
        yIn = Math.random() * 13 + xIn;
        rIn = Math.random() * 17;
        cRIn = Math.random() * 23;
        cGIn = Math.random() * 29 + cRIn;
        cBIn = Math.random() * 31 + cGIn;
        oIn = Math.random() * 33;
        //
        draw = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            if (root.getChildren().size() >= 1000)
            {
                root.getChildren().remove(0);
            }
            //do some stuff here
            //double xPos = (Math.random() * width);
            //double yPos = (Math.random() * height);
            double xPos = PerlinNoise.noise(xIn, 0, 0, width, true);
            double yPos = PerlinNoise.noise(yIn, 0, 0, height, true);
            double r = PerlinNoise.noise(rIn, 0, 0.85, 4.65, true);
            double red = PerlinNoise.noise(cRIn, 0, 0, 1, true);
            double green = PerlinNoise.noise(cGIn, 0, 0, 1, true);
            double blue = PerlinNoise.noise(cBIn, 0, 0, 1, true);
            double opacity = PerlinNoise.noise(oIn,0,0.3,0.8,true);
            Circle circle = new Circle(xPos, yPos, r, Color.color(red, green, blue));
            circle.setStrokeWidth(0.05);
            circle.setStroke(Color.WHITE);
            circle.setOpacity(opacity);
            root.getChildren().add(circle);
            //update
            xIn += res;
            yIn += res;
            rIn += res;
            cRIn += res;
            cGIn += res;
            cBIn += res;
        }));
        draw.setAutoReverse(false);
        draw.setRate(50);
        draw.setCycleCount(Timeline.INDEFINITE);

        root.setOnKeyPressed(e -> {
            switch (e.getCode())
            {
                case F1:
                {
                    stage.setTitle(title + " [ON]");
                    draw.play();
                    break;
                }
                case F2:
                {
                    stage.setTitle(title + " [OFF]");
                    draw.pause();
                    break;
                }
                default:
                {
                    break;
                }
            }
        });
        //
        stage.setScene(new Scene(root, width - 10, height - 10));
        stage.setTitle(title + " [Waiting for Command]");
        stage.setResizable(false);
        stage.show();
        root.requestFocus();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
