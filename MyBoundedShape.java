import java.lang.Math;
import java.awt.Color;
/**
 * Created by dfoley on 27/06/2017.
 * Class inherits from MyShape
 */

abstract class MyBoundedShape extends MyShape
{

    private boolean filled;


    public MyBoundedShape()
    {
        super();
        filled = false;
    }


    public MyBoundedShape(int x1, int x2, int y1, int y2, Color color, boolean filled)
    {
        super(x1, x2, y1, y2, color);
        this.filled = filled;
    }


    // getters and setters for filled
    public boolean getFilled(){
        return filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public int getUpperLeftX() {
        return Math.min(getX1(),getX2());
    }

    public int getUpperLeftY() {
        return Math.min(getY1(),getY2());
    }

    public int getWidth() {
        return Math.abs(getX2()-getX1()); }

    public int getHeight() {
        return Math.abs(getY2()-getY1());
    }
}
