import greenfoot.*;

public class Player extends Actor {
    private int speed = 3;
    private int auraTotal = 0;

    public Player() { setImage(new GreenfootImage("player.png")); }

    public void act() {
        handleMove();
        checkAura();
        checkEnemy();
    }

    private void handleMove() {
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) dx -= 1;
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) dx += 1;
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) dy -= 1;
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) dy += 1;
        setLocation(getX() + dx * speed, getY() + dy * speed);
    }

    private void checkAura() {
        Aura_Count a = (Aura_Count)getOneIntersectingObject(Aura_Count.class);
        if (a != null) {
            auraTotal += a.getValue();
            ((Map_Aura_Coins)getWorld()).addAuraPoints(a.getValue());
            getWorld().removeObject(a);
        }
    }

    private void checkEnemy() {
        if (isTouching(Kid_67_Aura.class)) {
            ((Map_Aura_Coins)getWorld()).endGame(false);
        }
    }
}
