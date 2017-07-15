import java.awt.*;

/**
 * Class that draws rectangles in JFrame
 */
public class MyRect extends MyBoundedShape {


    public MyRect() {
        super();
    }

    public MyRect(int x1, int x2, int y1, int y2, Color color, boolean filled) {
        super(x1, x2, y1, y2, color, filled);

    }

    /**
     * Draw method inherited from MyShape
     *
     * @param g graphics object
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        // if we want a coloured filled shape
        if (getFilled())
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }

}

