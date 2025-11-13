/**
 * Write a description of class enemy_Lebron_67 here.
 * Spawns enemey attack the user using shortest path
 * @author Charlie
 * @11/13/2025
 */
public class enemy_Lebron_67  
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class enemy_Lebron_67
     */
    public enemy_Lebron_67(int a,int b)
    {
        x=a;
        y=b;
    }
    public boolean in(int x,int y){//check if reached out of bounds
        return x >= 0 && y >= 0 && x < mapAura.getLength() && y < mapAura.getLength() && !mapAura.get(x,y);//get returns true when wall is there.
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
            // put your code here
    }
}
