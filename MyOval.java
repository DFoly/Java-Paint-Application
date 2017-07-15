import java.awt.*;

/**
 * Created by danfoley on 10/06/2017.
 * Class to draw ovals.  Part 3 of practical project
 */
public class MyOval extends MyBoundedShape {


    public MyOval() {
        super();
    }

    public MyOval(int x1, int x2, int y1, int y2, Color color, boolean filled) {
        super(x1, x2, y1, y2, color, filled);
    }

    /**
     * This is an inherited method from MyShape
     *
     * @param g graphics object
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        // if we want a coloured filled shape
        if (getFilled())
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
}
