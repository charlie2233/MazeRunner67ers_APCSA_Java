import greenfoot.*;

public class Aura_Count extends Actor {
    private int value;

    public Aura_Count() {
        setImage(new GreenfootImage("aura.png"));
        int[] choices = {1,3,5};
        value = choices[Greenfoot.getRandomNumber(choices.length)];
    }

    public int getValue() { return value; }
}
