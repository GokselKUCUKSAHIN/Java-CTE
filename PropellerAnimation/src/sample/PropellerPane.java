package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class PropellerPane extends Pane
{

    private double angle = 0;
    private int length;
    private final int x;
    private final int y;

    public double getAngle()
    {
        return angle;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getLength()
    {
        return length;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public PropellerPane(int x, int y, int length)
    {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    public void draw()
    {
        Arc arc1 = new Arc(x, y, length, length, angle, 45);
        Arc arc2 = new Arc(x, y, length, length, angle + 90, 45);
        Arc arc3 = new Arc(x, y, length, length, angle + 180, 45);
        Arc arc4 = new Arc(x, y, length, length, angle + 270, 45);
        arc1.setType(ArcType.ROUND);
        arc2.setType(ArcType.ROUND);
        arc3.setType(ArcType.ROUND);
        arc4.setType(ArcType.ROUND);
        getChildren().clear();
        getChildren().addAll(arc1, arc2, arc3, arc4);
        angle -= 0.1;
    }
}
