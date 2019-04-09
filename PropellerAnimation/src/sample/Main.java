package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        PropellerPane propeller = new PropellerPane(300, 300, 200);
        EventHandler<ActionEvent> handler = (e) -> {
            propeller.draw();
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), handler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setRate(400);
        animation.play();
        BorderPane root = new BorderPane();
        root.setCenter(propeller);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Propeller Animation - Jellybeanci");
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
