
import java.awt.Graphics;
import java.awt.Rectangle;


public class flyingObject 
{
     int X = 0;
     int Y = 0;
    private int Width;
    private int Height;
    private int Speed;
    Graphics g;
    int BoundsRight;
    int BoundsLeft;
    
    flyingObject(int x, int y, int width, int height, int speed, int left, int right)
    {
        
        this.X = x;
        this.Y = y;
        this.Width = width;
        this.Height = height;
        this.Speed = speed;
        this.BoundsLeft = left;
        this.BoundsRight = right;
    }
    
    public int getX()
    {
        return this.X;
    }
    
    public int getY()
    {
        return this.Y;
    }
    
    public int getWidth()
    {
        return this.Width;
    }
    
    public int getHeight()
    {
        return this.Height;
    }
    public int getSpeed()
    {
        return this.Speed;
    }
    public int getBoundsLeft()
    {
        return this.BoundsLeft;
    }
    public int getBoundsRight()
    {
        return this.BoundsRight;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(X,getY(),getWidth(),getHeight());
    }
    
}
