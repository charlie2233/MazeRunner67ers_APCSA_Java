import greenfoot.*; //add import just in case.
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // instance variables - replace the example below with your own
    private int x = 0,y = 0;// change later
    private mapAura mapAura;
    private static final int SPEED = 5;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        mapAura = new mapAura();
        GreenfootImage img67ers = new GreenfootImage("accesories/" + "siz_Seven_Kid.jpg");//fixed routes
        setImage(img67ers);
    }

    // /**
    //  * An example of a method - replace this comment with your own
    //  * 
    //  * @param  y   a sample parameter for a method
    //  * @return     the sum of x and y 
    //  */int sampleMethod
    public void act() // right/left/up/down movement (speed constant)
    {
        if (Greenfoot.isKeyDown("right")) {
            if (mapAura.get(getX() + SPEED, getY()) == false) // check if wall
                setLocation(getX() + SPEED, getY());
        } else if (Greenfoot.isKeyDown("left")) {
            if (mapAura.get(getX() - SPEED, getY()) == false) 
                setLocation(getX() - SPEED, getY());
        } else if (Greenfoot.isKeyDown("up")) {
            if (mapAura.get(getX(), getY() - SPEED) == false)
                setLocation(getX(), getY() - SPEED);
        } else if (Greenfoot.isKeyDown("down")) {
            if (mapAura.get(getX(), getY() + SPEED) == false) 
                setLocation(getX(), getY() + SPEED);
        }
    }
}

//example code from greendfoot docs for movement
// // Check if the right arrow key is pressed
// if (Greenfoot.isKeyDown("right")) {
//     // Move the actor to the right by a certain amount (e.g., 3 pixels)
//     setLocation(getX() + 3, getY());
// }

// // Check if the left arrow key is pressed
// if (Greenfoot.isKeyDown("left")) {
//     // Move the actor to the left by a certain amount (e.g., 3 pixels)
//     setLocation(getX() - 3, getY());
// }