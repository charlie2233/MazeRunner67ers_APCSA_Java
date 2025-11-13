/**
 * Write a description of class mapAura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mapAura  
{
    // instance variables - replace the example below with your own
    private int sizes;
    //used mapAura as a reference to the object, will change later.
    /**
     * Constructor for objects of class mapAura
     */
    public mapAura(int s)
    {
        sizes = s;
    }
    private boolean map[][] = new boolean[sizes][sizes];//Map 2D array, true == wall presented
    //size may vary later, make sure use getLength when accessing
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean in(int x,int y){//check if reached out of bounds
        return x >= 0 && y >= 0 && x < mapAura.getLength() && y < mapAura.getLength() && !mapAura.get(x,y);//get returns true when wall is there.
    }
    public int getLength() // return the size of 2D array map
    {
        // put your code here
        return map.length;//may varies later
    }
     public boolean get(int x,int y) // return the size of 2D array map
    {
        // put your code here
        if(mapAura.in(x,y)) return map[x][y];
        return false;//may varies later
    }
}
