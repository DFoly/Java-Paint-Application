import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by danfoley on 08/07/2017.
 * Creates Panel for drawing the shapes
 */
public class DrawPanel extends JPanel {

    private ArrayList<MyShape> shapeObjects;        // holds shape objects
    private int currentShapeType;                   // type line, rect or oval
    private MyShape currentShape;                   // currentshape
    private MyShape oldShape;                       // last shape - for undo button
    private Color currentColor;
    private boolean filledShape;
    private JLabel statusLabel;

    // Constructor
    public DrawPanel(JLabel label) {
        statusLabel = label;
        shapeObjects = new ArrayList<MyShape>(100);
        currentShapeType = 0;
        currentColor = Color.BLACK;
        setBackground(Color.WHITE);

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    // Draws components on the screen.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // loop through arraylist to draw shapes
        for (int element = 0; element < shapeObjects.size(); element++) {
            shapeObjects.get(element).draw(g);
        }
        if (currentShape != null) {
            currentShape.draw(g);
        }

    }

    // setters
    public void setCurrentShapeType(int shape) {
        currentShapeType = shape;
    }


    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }


    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }

    /**
     * This method deletes the last shape drawn
     */
    public void clearLastShape() {
        if (shapeObjects.size() != 0) {
            oldShape = shapeObjects.get(shapeObjects.size() - 1);
            shapeObjects.remove(shapeObjects.size() - 1);
            repaint();
        }
    }

    /**
     * This method clears all the shapes from the screen
     */
    public void clearDrawing() {
        oldShape = null;
        shapeObjects.clear();
        repaint();
    }

    /**
     * This method handles all mouse events
     * which enables user to draw shapes using the mouse
     */
    private class MouseHandler extends MouseAdapter implements MouseMotionListener {

        /**
         * When mouse is pressed down - create shape that user chooses
         *
         * @param event
         */
        public void mousePressed(MouseEvent event) {
            int x1 = event.getX();
            int y1 = event.getY();

            // 0 fo Line
            if (currentShapeType == 0) {
                currentShape = new MyLine(x1, x1, y1, y1, currentColor);

            }
            // 1 for Oval
            else if (currentShapeType == 1) {
                currentShape = new MyOval(x1, x1, y1, y1, currentColor, filledShape);

            }
            // 2 for Rectangle
            else if (currentShapeType == 2) {
                currentShape = new MyRect(x1, x1, y1, y1, currentColor, filledShape);

            }
        }

        /**
         * When mouse is released set current coordinates and add to shape arrayList
         *
         * @param event
         */
        public void mouseReleased(MouseEvent event) {
            try {
                int x2 = event.getX();
                int y2 = event.getY();

                currentShape.setX2(x2);
                currentShape.setY2(y2);

                shapeObjects.add(currentShape);
                currentShape = null;
                repaint();
            } catch (NullPointerException ex) {
            }

        }

        /**
         * When mouse is moved we record coordinates and display on screen
         *
         * @param event
         */
        public void mouseMoved(MouseEvent event) {
            String display = String.format("(%d, %d)", event.getX(), event.getY());
            statusLabel.setText(display);
        }

        /**
         * Mouse dragged we set second point of current shape to mouse
         * position and then repaint
         *
         * @param event
         */
        public void mouseDragged(MouseEvent event) {
            try {

                int x2 = event.getX();
                int y2 = event.getY();
                currentShape.setX2(x2);
                currentShape.setY2(y2);

                String display = String.format("(%d, %d)", event.getX(), event.getY());
                statusLabel.setText(display);
                repaint();
            } catch (NullPointerException ex) {
            }
        }

    }

}



