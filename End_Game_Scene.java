import greenfoot.*;

public class End_Game_Scene extends World {
    private int finalScore;
    private boolean didWin;

    public End_Game_Scene(int finalScore, boolean didWin) {
        super(600, 400, 1);
        this.finalScore = finalScore;
        this.didWin = didWin;
        updateText();
    }

    private void updateText() {
        String msg = didWin ? "YOU REACHED 67!" : "CAUGHT BY ENEMY!";
        showText(msg, getWidth()/2, getHeight()/2 - 10);
        showText("Final Aura: " + finalScore, getWidth()/2, getHeight()/2 + 15);
        showText("Press SPACE to restart", getWidth()/2, getHeight()/2 + 40);
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Map_Aura_Coins());
        }
    }
}
