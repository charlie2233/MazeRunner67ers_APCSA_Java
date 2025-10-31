import greenfoot.*;
import java.util.*;

public class Kid_67_Aura extends Actor {
    private int speed = 2;
    private Player target;
    // simple tile grid for BFS (v0.1) — 0=open,1=wall; later replace with real maze
    private int tileSize = 20;
    private int cols, rows;

    public Kid_67_Aura(Player target) {
        this.target = target;
        setImage(new GreenfootImage("enemy.png"));
    }

    public void addedToWorld(World w) {
        cols = w.getWidth() / tileSize;
        rows = w.getHeight() / tileSize;
    }

    public void act() {
        if (target == null || getWorld() == null) return;
        int[][] grid = new int[cols][rows]; // all open for now
        Point start = toCell(getX(), getY());
        Point goal = toCell(target.getX(), target.getY());
        java.util.List<Point> path = Path_Finder.bfsPath(grid, start, goal);
        if (path != null && path.size() > 1) {
            Point next = path.get(1); // step toward next tile
            moveTowardCell(next);
        } else {
            // fallback: direct homing
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

    private Point toCell(int x, int y) {
        return new Point(x / tileSize, y / tileSize);
    }

    private void moveTowardCell(Point cell) {
        int cx = cell.x * tileSize + tileSize/2;
        int cy = cell.y * tileSize + tileSize/2;
        int dx = cx - getX();
        int dy = cy - getY();
        double angle = Math.atan2(dy, dx);
        int vx = (int)Math.round(speed * Math.cos(angle));
        int vy = (int)Math.round(speed * Math.sin(angle));
        setLocation(getX() + vx, getY() + vy);
    }

    // minimal Point class to avoid java.awt dependency in APCSA
    static class Point { int x,y; Point(int x,int y){this.x=x;this.y=y;} }
}
