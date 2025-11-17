import greenfoot.*; //add import just in case.
import java.util.*;
/**
 * Write a description of class mapAura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mapAura extends World
{
    // instance variables - replace the example below with your own

    private static final int SIZES = 25;//size of map 2D array
    private static final int TILE_SIZE = 20;// 20 pixels per tile
    private Player player;
    private arraylist <Player> enemies = new arraylist<Player>();

    //used mapAura as a reference to the object, will change later.
    /**
     * Constructor for objects of class mapAura
     */
    public mapAura()
    {
        super(SIZES * TILE_SIZE, SIZES * TILE_SIZE, 1); // width, height, cellSize
        preprocessing(); //do things at start
        spawnPlayer();
        spawnEnemy(); 
    }
    private boolean[][] grid = new boolean[SIZES][SIZES];//Map 2D array, true == wall presented
    //size may vary later, make sure use getLength when accessing
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

    private void spawnPlayer()
    {
        player = new Player();
        addObject(player, TILE_SIZE * 3, TILE_SIZE * 3);
    }

    private void preprocessing()
    {
        // wil do later, set up aura_point first
    }
    
   public void spawnEnemy()//literally spawns enemy at random location
    {
        enemy_Lebron_67 e = new enemy_Lebron_67(player);
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(e, x, y);
    }
    //the get methods for outside & inside to call and not mess up
    public boolean[][] getGrid()
    {
        return grid;
    }

    public int getTileSize()
    {
        return TILE_SIZE;
    }

    public int getLength() // return the size of the 2D array map
    {
        return grid.length;
    }
     public boolean getWall(int x,int y) // return the size of 2D array map
    {
        // put your code here
        if (x < 0 || y < 0 || x >= SIZES || y >= SIZES) return true;
        return grid[x][y] == true;
    }
    // public boolean in(int x,int y){//check if reached out of bounds
    //     return x >= 0 && y >= 0 && x < this.getLength() && y < this.getLength() && !this.getall(x,y);//get returns true when wall is there.
    // }
}
