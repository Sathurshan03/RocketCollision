
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocket extends flyingObject
{
    int directionX = 0;
    int directionY = 0;
    int BoundsBottom;
    
    Rocket(int x, int y, int width, int height, int speed, int left, int right, int bottom)
    {
        super( x, y, width, height, speed, left, right);
        this.BoundsBottom = bottom;
        
    }
    
    public void move()
    {
        this.X += getSpeed() * directionX;
        this.Y += getSpeed() * directionY;
        
        if (X <= getBoundsLeft())
        {
            X = getBoundsLeft();
        }
        if(X >= getBoundsRight())
        {
            X = getBoundsRight();
        }
        if (Y >= BoundsBottom )
        {
            Y = BoundsBottom;
        }
    }
    
    public Graphics setColor (Graphics g)
    {
        Color rocketColor = new Color (192,192,192);
        g.setColor(rocketColor);
        
        return g;
    }
    
    public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                directionX = -1;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                directionX = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                directionY = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                directionY = -1;
            }
        }
    
    public void keyReleased(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                directionX = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                directionX = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                directionY = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                directionY = 0;
            }
        }
}