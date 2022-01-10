
// import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MouseEvents extends JFrame implements MouseListener, MouseMotionListener {
    JTextField txt1;

    MouseEvents() {
        setSize(500, 500);
        // setLayout(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt1 = new JTextField(30);
        add(txt1);
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }

    // MouseMotionListener Mothods
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        txt1.setText("Mouse Moved " + e.getX() + "," + e.getY());

    }
    // MouseListener Mothods

    @Override
    public void mouseClicked(MouseEvent e) {
        txt1.setText("Mouse Clicked " + e.getX() + "," + e.getY());
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        MouseEvents mouseEvents = new MouseEvents();
    }
}
