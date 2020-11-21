
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;


public class runGame extends JPanel implements ActionListener 
{

    int panelWidth = this.getWidth();
    
 
    Rocket myRocket;
    LinkedList <Asteriods> linearAsteriod;
    LinkedList <Asteriods> angledAsteriod;
    Font large = new Font("Helvetica", Font.BOLD, 30);
    FontMetrics fm = getFontMetrics(large);
    

    
    private final int DELAY = 1;
    Timer timer;
    
    public class myKeyListener implements KeyListener
    {
        
        @Override
        public void keyTyped(KeyEvent e)
        {
           
        }
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            myRocket.keyPressed(e);
        }
        
        @Override
        public void keyReleased (KeyEvent e)
        {
           myRocket.keyReleased(e);
        }
    }
    
    
    public runGame()
    {
        
        KeyListener listener = new myKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        myRocket = new Rocket (250,720,20,40,2, 0, 460, 600);
        
        
        linearAsteriod = new LinkedList();
        
        linearAsteriod.add(new Asteriods(0,575, 20, 20,1,0,500));
        linearAsteriod.add(new Asteriods(0,550, 20, 20,2,0,500));
        linearAsteriod.add(new Asteriods(0,525, 20, 20,3,0,500));
        linearAsteriod.add(new Asteriods(0,475, 20, 20,3,0,240));
        linearAsteriod.add(new Asteriods(480,475, 20, 20,3, 260, 500));
        linearAsteriod.add(new Asteriods(230,425, 20, 20,3,0, 250));
        linearAsteriod.add(new Asteriods(250,425, 20, 20,3,250, 500));
        linearAsteriod.add(new Asteriods(0,330, 20, 20,5,0,250));
        linearAsteriod.add(new Asteriods(480,330, 20, 20,5,250,500));
        linearAsteriod.add(new Asteriods(0, 50, 20, 20,5,0,500));
        
        angledAsteriod = new LinkedList();
        
        angledAsteriod.add(new Asteriods(0,275, 20, 20,2,0,500,225,325));
        angledAsteriod.add(new Asteriods(0,150, 20, 20,2,0,500,75,200));
        angledAsteriod.add(new Asteriods(480,150, 20, 20,2,0,500,75,200));
        
        timer = new Timer(DELAY,this);
        timer.start();
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        checkCollision();
        
        
        rocketMove();
        
        updateLinerAstriod();
        updateAngledAstriod();
    
    }
    public void rocketMove()
    {
        myRocket.move();
    }
    
    public void paint (Graphics g)
    {
        
        
        if (myRocket.getY() <= 13)
        {
            timer.stop();
            drawYouWin(g);
        }
        else if (timer.isRunning())
        {
            running(g);
        }
        else 
        {
            drawGameOver(g);
        }
        
        
        
        
        repaint();
        
    }
    public void running(Graphics g)
    {
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        

        g.setColor(new Color(34,139,34));
        g.fillRect(0, 0, this.getWidth(), 15);
        

        
        
        String instruction = "Use arrow keys to move around to the green finish line!";
        Font mini = new Font("Helvetica", Font.BOLD, 12);
        FontMetrics fm = getFontMetrics(mini);

        g.setColor(Color.white);
        g.setFont(mini);
        g.drawString(instruction, (this.getWidth() - fm.stringWidth(instruction)) / 2, 660);
        
        
        
        
        g = myRocket.setColor(g);
        
        g.fillRect(myRocket.getX(), myRocket.getY(), myRocket.getWidth(), myRocket.getHeight());
        
        
        
        
        
        
        for (int i = 0; i < linearAsteriod.size(); i++)
        {
            g = linearAsteriod.get(i).setColor(g);
            g.fillOval(linearAsteriod.get(i).getX(), linearAsteriod.get(i).getY(), linearAsteriod.get(i).getWidth(), linearAsteriod.get(i).getHeight());
        }
        
        for (int i = 0; i < angledAsteriod.size(); i++)
        {
            g = angledAsteriod.get(i).setColor(g);
            g.fillOval(angledAsteriod.get(i).getX(), angledAsteriod.get(i).getY(), angledAsteriod.get(i).getWidth(), angledAsteriod.get(i).getHeight());
        }
        

        
    }
    
    public void updateLinerAstriod()
    {
        for (int i = 0; i < linearAsteriod.size(); i++)
        {
           if(linearAsteriod.get(i).getX() <= linearAsteriod.get(i).getBoundsLeft())
            {
                linearAsteriod.get(i).setDirectionX(1);
            }
            if (linearAsteriod.get(i).getX() >= linearAsteriod.get(i).getBoundsRight() - 20)
            {
                linearAsteriod.get(i).setDirectionX(-1);
            }
        
            linearAsteriod.get(i).move(); 
        }
        

    }

    public void updateAngledAstriod()
    {
        for (int i = 0; i < angledAsteriod.size(); i++)
        {
            if(angledAsteriod.get(i).getX() <= angledAsteriod.get(i).getBoundsLeft())
            {
                 angledAsteriod.get(i).setDirectionX(1);
            }
            if (angledAsteriod.get(i).getX() >= angledAsteriod.get(i).getBoundsRight() - 20)
            {
                angledAsteriod.get(i).setDirectionX(-1);
            }

            if(angledAsteriod.get(i).getY() <= angledAsteriod.get(i).getBoundsTop())
            {
                angledAsteriod.get(i).setDirectionY(1);
            }
            if(angledAsteriod.get(i).getY() >= angledAsteriod.get(i).getBoundsBottom()- 20)
            {
                angledAsteriod.get(i).setDirectionY(-1);
            }

            angledAsteriod.get(i).move(0);
        }
    }    
    public void checkCollision()
    {
        
        Rectangle rocketBounds = myRocket.getBounds();

        Iterator<Asteriods> iKeyL = linearAsteriod.iterator();
        Iterator<Asteriods> iKeyA = angledAsteriod.iterator();
        
        while( iKeyL.hasNext()) 
        {   
            Rectangle asteriodBounds = iKeyL.next().getBounds();
            
            if (rocketBounds.intersects(asteriodBounds))
            {
                timer.stop();
            }
        }
        
        while( iKeyA.hasNext()) 
        {   
            Rectangle asteriodBounds = iKeyA.next().getBounds();
            
            if (rocketBounds.intersects(asteriodBounds))
            {
                timer.stop();
            }
        }
    }
    
    private void drawGameOver(Graphics g) 
    {

        String end = "Game Over";
        

        g.setColor(Color.RED);
        g.setFont(large);
        g.drawString(end, (this.getWidth() - fm.stringWidth(end)) / 2, 630);
    }
    public void drawYouWin(Graphics g)
    {
        String message = "YOU WIN!";

        g.setColor(Color.GREEN);
        g.setFont(large);
        g.drawString(message, (this.getWidth() - fm.stringWidth(message)) / 2, 630);
    }
    
    
}
