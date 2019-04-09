import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BallPane extends Pane
{

    private int radius;
    private Color color;
    private Color outlineColor;

    public BallPane(int radius)
    {
        this.radius = radius;
        drawBall();
    }

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
       if(radius < 5)
       {
           this.radius = 5;
       }
       else
       {
           this.radius = radius;
       }
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        if(color == null)
        {
            this.color = Color.BLUE; //default
        }
        else
        {
            this.color = color;
        }
    }

    public Color getOutlineColor()
    {
        return outlineColor;
    }

    public void setOutlineColor(Color outlineColor)
    {
        this.outlineColor = outlineColor;
    }

    public void drawBall()
    {

    }
    @Override
    protected  void setWidth(double value)
    {
        super.setWidth(value);
        drawBall();
    }
    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
        drawBall();
    }
}