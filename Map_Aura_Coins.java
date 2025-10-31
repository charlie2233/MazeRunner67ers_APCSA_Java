import greenfoot.*;  // World, Actor, GreenfootImage, Greenfoot and MouseInfo
import java.util.*;

public class Map_Aura_Coins extends World {
    private int auraCount = 0;
    private final int goalScore = 67;
    private final int[] thresholds = {20, 40, 60};
    private int thresholdIndex = 0;
    private Player player;
    private java.util.List<Kid_67_Aura> enemies = new ArrayList<Kid_67_Aura>();
    private int tick = 0;
    private Music_Manager music = new Music_Manager();

    // Grid for BFS (0 open, 1 wall). Currently all open; hook real walls later.
    private final int tileSize = 20;
    private final int cols;
    private final int rows;
    private final int[][] grid;

    public Map_Aura_Coins() {
        super(600, 400, 1);
        setBackground(Sprite.loadOrFallback("accesories_MazeRunner67ers_APCSA/mazes/Mazes_BrickWalls.webp", "bg.png"));

        cols = getWidth() / tileSize;
        rows = getHeight() / tileSize;
        grid = new int[cols][rows]; // all zeros for now

        player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);

        spawnEnemy();
        for (int i = 0; i < 5; i++) spawnAura();

        music.playCalm();
    }

    public void act() {
        tick++;
        if (tick % 120 == 0) spawnAura();

        if (thresholdIndex < thresholds.length && auraCount >= thresholds[thresholdIndex]) {
            spawnEnemy();
            thresholdIndex++;
            if (auraCount >= 60) music.playIntense();
        }

        if (auraCount >= goalScore) {
            endGame(true);
        }

        showText("Aura: " + auraCount + " / " + goalScore + " | Enemies: " + enemies.size(), 300, 15);
    }

    public int[][] getGrid() { return grid; }
    public int getTileSize() { return tileSize; }

    public void addAuraPoints(int value) { auraCount += value; }

    public void endGame(boolean didWin) {
        Greenfoot.setWorld(new End_Game_Scene(auraCount, didWin));
        music.stopAll();
    }

    public void spawnAura() {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        Aura_Count a = new Aura_Count();
        addObject(a, x, y);
    }

    public void spawnEnemy() {
        int side = Greenfoot.getRandomNumber(4);
        int x = 0, y = 0;
        if (side == 0) { x = 10; y = Greenfoot.getRandomNumber(getHeight()); }
        if (side == 1) { x = getWidth()-10; y = Greenfoot.getRandomNumber(getHeight()); }
        if (side == 2) { y = 10; x = Greenfoot.getRandomNumber(getWidth()); }
        if (side == 3) { y = getHeight()-10; x = Greenfoot.getRandomNumber(getWidth()); }
        Kid_67_Aura e = new Kid_67_Aura(player);
        enemies.add(e);
        addObject(e, x, y);
    }
}
