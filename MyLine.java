import java.awt.*;

/**
 * This class draws lines in a JFrame
 */
public class MyLine extends MyShape {

    public MyLine() {
        super();     // prefer to explicitly call it
    }

    public MyLine(int x1, int x2, int y1, int y2, Color color) {
        super(x1, x2, y1, y2, color);
    }

    /**
     * Draw method inherited from MyShape
     *
     * @param g graphics object
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
} // end class MyLine


