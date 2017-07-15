import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by dfoley on 05/07/2017.
 * Creating the GUI where users can select
 * shapes and color to draw and adds
 * buttons for clearing last shape, all shapes
 * checkbox to have a filled shape or not
 */
public class DrawFrame extends JFrame {
    private BorderLayout layout;
    private JPanel buttonPanel;

    private JButton undo;
    private JButton clear;

    private String[] colors = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
            "Pink", "Red", "White", "Yellow"};
    private String[] shapes = {"Line", "Oval", "Rectangle"};

    private JComboBox colorJButton;
    private JComboBox shapeJComboBox;
    private JCheckBox fillChooser;

    private JLabel statusLabel;
    private DrawPanel drawPanel;

    // usefull for color dropdown button.
    private Color colorArray[] =
            {Color.BLACK, Color.BLUE, Color.CYAN, Color.darkGray, Color.GRAY,
                    Color.GREEN, Color.lightGray, Color.MAGENTA, Color.ORANGE,
                    Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};


    /**
     * Creates buttons and labels for user to interact with
     *
     * @param statusLabel
     */
    public DrawFrame(JLabel statusLabel) {
        super("SuperPaint");
        layout = new BorderLayout(3, 1);
        setLayout(layout);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        statusLabel = new JLabel();
        drawPanel = new DrawPanel(statusLabel);

        undo = new JButton("Undo");
        clear = new JButton("Clear");


        colorJButton = new JComboBox(colors);
        shapeJComboBox = new JComboBox(shapes);

        fillChooser = new JCheckBox("Filled");

        buttonPanel.add(undo);
        buttonPanel.add(clear);
        buttonPanel.add(colorJButton);
        buttonPanel.add(shapeJComboBox);
        buttonPanel.add(fillChooser);

        add(buttonPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        ButtonHandler buttonHandler = new ButtonHandler();
        CheckBoxHandler checkHandler = new CheckBoxHandler();
        ComboBoxHandler comboHandler = new ComboBoxHandler();
        undo.addActionListener(buttonHandler);
        clear.addActionListener(buttonHandler);
        fillChooser.addItemListener(checkHandler);
        colorJButton.addItemListener(comboHandler);
        shapeJComboBox.addItemListener(comboHandler);
    }

    /**
     * Handler for the buttons
     */
    private class ButtonHandler implements ActionListener {
        /**
         * Handles undo and clear shapes buttons
         *
         * @param event
         */
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == undo) {
                drawPanel.clearLastShape();
            } else {
                drawPanel.clearDrawing();
            }

        }

    }

    /**
     * Handler for fill check box
     */
    private class CheckBoxHandler implements ItemListener {
        /**
         * Set shape to be filled or not
         *
         * @param event
         */
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == 1) {
                drawPanel.setFilledShape(true);
            } else {
                drawPanel.setFilledShape(false);
            }
        }

    }


    /**
     * Hanlder for the color dropdown and shape dropdown selections
     */
    private class ComboBoxHandler implements ItemListener {
        /**
         * Checks the dropdown menus for color and shape
         *
         * @param event
         */
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                if (event.getSource() == colorJButton) {
                    drawPanel.setCurrentColor(colorArray[colorJButton.getSelectedIndex()]);

                } else if (event.getSource() == shapeJComboBox) {
                    drawPanel.setCurrentShapeType(shapeJComboBox.getSelectedIndex());
                }
            }
        }

    }

}
