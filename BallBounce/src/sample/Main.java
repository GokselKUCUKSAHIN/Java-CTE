package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application
{

    private double clr = 1;
    private boolean goLeft = true;
    private boolean goUp = true;
    private boolean isPaused = false;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ball Bounce Jellybeanci");
        //
        Circle ball = new Circle(150, 250, 50);
        ball.setFill(Color.hsb(clr, 1, 1));

        ball.setStroke(Color.rgb(51, 51, 51));
        ball.setStrokeWidth(0.6);
        //

        //
        double speed = 500;
        EventHandler<ActionEvent> handler = e -> {
            double widthLimit = scene.getWidth();
            double heightLimit = scene.getHeight();
            bounce(widthLimit, heightLimit, ball);
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(speed), handler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setRate(50);
        animation.play();
        ball.setOnMouseClicked(e -> {
            if (isPaused == false)
            {
                isPaused = true;
                animation.pause();
            } else
            {
                isPaused = false;
                animation.play();
            }
        });
        //
        Button shrink = new Button("-");
        Button enlarge = new Button("+");
        shrink.setMinHeight(50);
        shrink.setMinWidth(50);
        enlarge.setMinWidth(50);
        enlarge.setMinHeight(50);
        shrink.setStyle("-fx-font: 24 arial;");
        enlarge.setStyle("-fx-font: 24 arial;");
        shrink.setFocusTraversable(false);
        enlarge.setFocusTraversable(false);
        shrink.setOnAction(e -> {
            ball.setRadius(ball.getRadius() - 5);
        });
        enlarge.setOnAction(e -> {
            ball.setRadius(ball.getRadius() + 5);
        });
        HBox box = new HBox();
        box.getChildren().addAll(shrink, enlarge);
        ball.setOnKeyPressed(e -> {
            switch (e.getCode())
            {
                case UP:
                {
                    animation.setRate(animation.getRate() + 3);
                    break;
                }
                case DOWN:
                {
                    animation.setRate(animation.getRate() - 3);
                    break;
                }
            }
        });
        //
        pane.getChildren().addAll(ball);
        root.setCenter(pane);
        root.setBottom(box);
        primaryStage.show();
        ball.requestFocus();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private void bounce(double wLimit, double hLimit, Circle ball)
    {
        ball.setFill(Color.hsb(clr, 1, 1));
        //clr += 0.1;
        if (((ball.getCenterX() - ball.getRadius()) <= 0) && (goLeft))
        {
            goLeft = false;
            clr += 0.1;
        } else if (((ball.getCenterX() + ball.getRadius()) >= wLimit) && (!goLeft))
        {
            goLeft = true;
            clr += 0.1;
        }
        //
        if (((ball.getCenterY() - ball.getRadius()) <= 0) && (goUp))
        {
            goUp = false;
            clr += 0.1;
        } else if (((ball.getCenterY() + ball.getRadius()) >= hLimit) && (!goUp))
        {
            goUp = true;
            clr += 10;
        }
        //
        if (goLeft)
        {
            ball.setCenterX(ball.getCenterX() - 1);
        }else if (!goLeft)
        {
            ball.setCenterX(ball.getCenterX() + 1);
        }
        if (goUp)
        {
            ball.setCenterY(ball.getCenterY() - 1);
        } else if (!goUp)
        {
            ball.setCenterY(ball.getCenterY() + 1);
        }
    }
}
