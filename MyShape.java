import java.awt.Color;
import java.awt.Graphics;

abstract class MyShape
{
    private int x1; // x coordinate of first endpoint
    private int y1; // y coordinate of first endpoint
    private int x2; // x coordinate of second endpoint
    private int y2; // y coordinate of second endpoint
    private Color myColor; // color of this shape

    // no arg constructor
    public MyShape() {
        this(0, 0, 0, 0, Color.BLACK);
    }


    // Constructor given input. Takes in integers x1, x2, y1, y2, and Color object color.
    public MyShape (int x1, int x2, int y1, int y2, Color color)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        myColor = color;
    }


    // getters and setters
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1 >= 0 ? x1 : 0;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1 >= 0 ? y1 : 0;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2 >= 0 ? x2 : 0;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2 >= 0 ? y2 : 0;
    }

    public Color getColor() {
        return myColor;
    }

    public void setColor(Color color) {
        this.myColor = color;
    }

    /**
     * Draw method is abstract
     *
     * @param g graphics object
     */
    public abstract void draw(Graphics g);
}
