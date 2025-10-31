import greenfoot.*;

public class Sprite {
    public static GreenfootImage loadOrFallback(String... names) {
        for (String n : names) {
            try {
                return new GreenfootImage(n);
            } catch (Exception e) { /* try next */ }
        }
        GreenfootImage img = new GreenfootImage(20,20);
        img.setColor(java.awt.Color.ORANGE);
        img.fillOval(0,0,20,20);
        return img;
    }
}
