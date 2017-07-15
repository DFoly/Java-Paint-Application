import javax.swing.*;

/**
 * Created by danfoley on 08/07/2017.
 */
public class TestDraw {
    public static void main(String[] args) {
        JLabel statusLabel = new JLabel();
        DrawFrame application = new DrawFrame(statusLabel);
        //Sets up the window.
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setSize( 500, 500 );
        application.setVisible( true );

    }
}
