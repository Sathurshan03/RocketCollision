
import java.awt.Color;
import javax.swing.JFrame;


public class Game 
{
    public static void main (String[] args)
    {
        JFrame window = new JFrame();
        window.setSize(500,700);
        window.setBackground(Color.black);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new runGame());
        window.setResizable(false);
        window.setVisible(true);
    }
}
