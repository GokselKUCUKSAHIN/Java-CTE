package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Main extends Application
{

    public static void main(String[] args)
    {
        launch();//common main
    }
    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        //
        for (int i = 0; i < 360; i++)
        {
            Point nextPoint = endPoint(300,300,i,500);
            root.getChildren().add(new Line(300,300,nextPoint.getX(),nextPoint.getY()));
        }


        //
        stage.setScene(new Scene(root,600,600));
        stage.setTitle("360 Cast!");
        stage.setResizable(false);
        stage.show();
    }
    private Point endPoint(double x, double y, double angle, double size)
    {
        x += (int) (size * Math.cos(angleToRadian(angle)));
        y -= (int) (size * Math.sin(angleToRadian(angle)));
        return new Point(x, y);
    }

    private double calculateAngle(double p1X, double p1Y, double p2X, double p2Y)
    {
        double dx = Math.abs(p1X - p2X);
        double dy = Math.abs(p1Y - p2Y);
        //System.out.println(dx+": "+dy);
        double a = radianToAngle(Math.atan(dy / dx));
        if (p1X - p2X >= 0)
        {
            //II - III
            if (p1Y - p2Y >= 0)
            {
                //II Region
                return 180 - a;
            } else
            {
                //III Region
                return 180 + a;
            }
        } else
        {
            // I - IV
            if (p1Y - p2Y >= 0)
            {
                //I Region
                return a;
            } else
            {
                //IV Region
                return 360 - a;
            }
        }
    }

    private double angleToRadian(double angle)
    {
        return (Math.PI / 180.0) * angle;
    }
    private double radianToAngle(double radian)
    {
        return radian * (180 / Math.PI);
    }

}
