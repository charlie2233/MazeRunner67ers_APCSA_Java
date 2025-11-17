import greenfoot.*; //add import just in case.
import java.util.*;
/**
 * Write a description of class enemy_Lebron_67 here.
 * Spawns enemey attack the user using shortest path
 * @author Charlie
 * @11/13/2025
 */
public class enemy_Lebron_67 extends Actor
{
    // instance variables - replace the example below with your own
    // private int x;
    // private int y; I think there are built in position trackers.
    private static final int SPEED = 2;//constant speed, static final makes it constant
    private Player target;

    private static final String[] ENEMYIMAGES = {//static final make const
    "enemy_Ashton_Hall.jpg",
    "enemy_Hoopify.avif",
    "enemy_Speed_Homeless.jpg",
    "enemy_Evil_Kaicenat.jpg",
    "lebron_Scare.jpg",
    "lebron_Stare_Miami.jpg"//LEbroonnnnnnn
};
    //set random image from array
    private void setRandomImage()
    {
        int index = Greenfoot.getRandomNumber(6);
        //get random image of enemy
        GreenfootImage img = new GreenfootImage("enemy/" + ENEMYIMAGES[index]);//fixed routes
        setImage(img);
    }

    /**
     * Constructor for objects of class enemy_Lebron_67
     */
    public enemy_Lebron_67(Player p)
    {
        target = p;
        setRandomImage();
    }
    // public boolean in(int x,int y){//check if reached out of bounds
    //     return x >= 0 && y >= 0 && x < mapAura.getLength() && y < mapAura.getLength() && !mapAura.get(x,y);
    //     //get returns true when wall is there., wall not declared yet change later.
    // }
    
    //method for outside ezizer to call and not mess up
    public void act()
    {
        if(target == null){
            console.log("Enemy has no target!");
            return;//no target no movement, barelly happens,console log.
        }
        int enemyX = getX();
        int enemyY = getY();
        int targetX = target.getX();
        int targetY = target.getY();
        
        //calculate direction to move
        int deltaX = targetX - enemyX;
        int deltaY = targetY - enemyY;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        
        if(distance == 0) return; //already at target
        
        //normalize direction
        double moveX = (deltaX / distance) * SPEED;//move formula
        double moveY = (deltaY / distance) * SPEED;
        
        //update position
        setLocation((int)(enemyX + moveX), (int)(enemyY + moveY));
    }
    

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    // public int sampleMethod(int y)
    // {
    //         // put your code here
    // }
}
