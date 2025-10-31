import greenfoot.*;

public class Aura_Count extends Actor {
    private int value;

    public Aura_Count() {
        setImage(Sprite.loadOrFallback("accesories_MazeRunner67ers_APCSA/you_win_Png2.jpg", "aura.png"));
        int[] choices = {1,3,5};
        value = choices[Greenfoot.getRandomNumber(choices.length)];
    }

    public int getValue() { return value; }
}
