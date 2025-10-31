import greenfoot.*;
import java.util.*;

public class Kid_67_Aura extends Actor {
    private int speed = 2;
    private Player target;

    public Kid_67_Aura(Player target) {
        this.target = target;
        setImage(Sprite.loadOrFallback("accesories_MazeRunner67ers_APCSA/enemy/LEBRONNNNNN.jpg", "enemy.png"));
    }

    public void act() {
        if (target == null || getWorld() == null) return;
        Map_Aura_Coins w = (Map_Aura_Coins)getWorld();
        int[][] grid = w.getGrid();
        int tileSize = w.getTileSize();

        Point start = toCell(getX(), getY(), tileSize);
        Point goal  = toCell(target.getX(), target.getY(), tileSize);
        java.util.List<Point> path = Path_Finder.bfsPath(grid, start, goal);
        if (path != null && path.size() > 1) {
            Point next = path.get(1);
            moveTowardCell(next, tileSize);
        } else {
            directHoming();
        }
    }

    private void directHoming() {
        int dx = target.getX() - getX();
        int dy = target.getY() - getY();
        double angle = Math.atan2(dy, dx);
        int vx = (int)Math.round(speed * Math.cos(angle));
        int vy = (int)Math.round(speed * Math.sin(angle));
        setLocation(getX() + vx, getY() + vy);
    }

    private Point toCell(int x, int y, int tileSize) {
        return new Point(x / tileSize, y / tileSize);
    }

    private void moveTowardCell(Point cell, int tileSize) {
        int cx = cell.x * tileSize + tileSize/2;
        int cy = cell.y * tileSize + tileSize/2;
        int dx = cx - getX();
        int dy = cy - getY();
        double angle = Math.atan2(dy, dx);
        int vx = (int)Math.round(speed * Math.cos(angle));
        int vy = (int)Math.round(speed * Math.sin(angle));
        setLocation(getX() + vx, getY() + vy);
    }

    static class Point { int x,y; Point(int x,int y){this.x=x;this.y=y;} }
}
