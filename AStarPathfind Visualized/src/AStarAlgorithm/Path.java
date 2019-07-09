package AStarAlgorithm;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;

public class Path
{

    Polyline body = new Polyline();
    Color color = Color.rgb(169, 48, 200);
    double witdh = Window.w * 0.4;

    public Polyline getBody()
    {
        this.body.setStroke(color);
        this.body.setStrokeWidth(witdh);
        return this.body;
    }

    public Polyline updatePath(ArrayList<Spot> path)
    {
        double dots[] = new double[path.size() * 2];
        for (int i = 0; i < path.size(); i++)
        {
            dots[2 * i] = path.get(i).getCenterX();
            dots[2 * i + 1] = path.get(i).getCenterY();
        }
        //System.out.println(Arrays.toString(dots));
        this.body = new Polyline(dots);
        this.body.setStroke(color);
        this.body.setStrokeWidth(witdh);
        return this.body;
    }
}