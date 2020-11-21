
import java.awt.Color;
import java.awt.Graphics;

public class Asteriods extends flyingObject
{
    private int BoundsTop;
    private int BoundsBottom;
    
    int DirectionX;
    int DirectionY;
    
    
    public Asteriods(int x, int y, int width, int height, int speed, int left, int right)
    {
        super( x, y, width, height, speed, left, right);
        DirectionX =1;
        DirectionY = 1;
       
    }
    
    public Asteriods(int x, int y, int width, int height, int speed, int left, int right, int top, int bottom)
    {
        super( x, y, width, height, speed, left, right);
        
        this.BoundsTop = top;
        this.BoundsBottom = bottom;
        DirectionX =1;
        DirectionY = 1;
    }
    
    
    
    
    public void move() 
    {
        
        
        this.X += getSpeed() * DirectionX;
    }
    
    
    public void move(int differ) 
    {
        
        
        this.X += getSpeed() * DirectionX;
        this.Y += getSpeed() * DirectionY;
    }
    
    public void setDirectionX(int num)
    {
        DirectionX = num;
    }
    public void setDirectionY(int num)
    {
        DirectionY = num;
    }
    public int getBoundsTop()
    {
        return this.BoundsTop;
    }
    public int getBoundsBottom()
    {
        return this.BoundsBottom;
    }
    
    public Graphics setColor (Graphics g)
    {
        Color rocketColor = new Color (153,101,21);
        g.setColor(rocketColor);
        
        return g;
    }
    
    
    
}
