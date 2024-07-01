import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sbob here.
 * 
 */
public class Sbob extends Actor
{
    private int gold = 0;
    private int speed = 1; // Default speed is 1
    private static final int maxSpeed = 10; // Maximum allowed speed
    private int score = 0;
    private boolean gameRunning = true;

    public void act()
    {
        if (gameRunning) {
            if (canCatchGold()) {
                catchGold();
                score += 1; // Increase score by 1 for each coin
            }
            if (canCatchKrabbyPatty()) {
                catchKrabbyPatty();
                speed += 1; // Increase speed by 1 for Krabby Patty
                if (speed > maxSpeed) {
                    speed = maxSpeed; // Limit speed to maxSpeed
                }
            }
            if (canCatchCrabTrap()) { //new conditional 4
                catchCrabTrap();
                speed = Math.max(1, speed - 1); // Decrease speed by 1 for Crab Trap but not less than 1
            }
            if (score >= 50) {
                gameRunning = false;
                Greenfoot.stop(); // Stop the game when score reaches 50
            }
            updateText();
            
            if (Greenfoot.isKeyDown("right")) {
                setLocation(getX() + speed, getY());
            }
            
            if (Greenfoot.isKeyDown("left")) {
                setLocation(getX() - speed, getY());
            }
        }
    }
    
    private void updateText() {
        WaterWorld world = (WaterWorld) getWorld();
            world.updateText("Score: ".concat(String.valueOf(score)), 100, 20, "score"); //new string method
            world.updateText("Speed: ".concat(String.valueOf(speed)), 700, 20, "speed"); //new string method

    }
    
    private boolean canCatchGold() {
        Actor gold = getOneObjectAtOffset(0, 0, PirateGold.class);
        return gold != null;
    }
    
    private void catchGold() {
        Actor gold = getOneObjectAtOffset(0, 0, PirateGold.class);
        if (gold != null) {
            Greenfoot.playSound("cha_ching.wav");
            getWorld().removeObject(gold);
        }
    }

    private boolean canCatchKrabbyPatty() {
        Actor krabbyPatty = getOneObjectAtOffset(0, 0, KrabbyPatty.class);
        return krabbyPatty != null;
    }
    
    private void catchKrabbyPatty() {
        Actor krabbyPatty = getOneObjectAtOffset(0, 0, KrabbyPatty.class);
        if (krabbyPatty != null) {
            Greenfoot.playSound("chomp.wav");
            getWorld().removeObject(krabbyPatty);
        }
    }

    private boolean canCatchCrabTrap() {
        Actor trap = getOneObjectAtOffset(0, 0, CrabTrap.class);
        return trap != null;
    }
    
    private void catchCrabTrap() {
        Actor trap = getOneObjectAtOffset(0, 0, CrabTrap.class);
        if (trap != null) {
            Greenfoot.playSound("bonk.wav");
            getWorld().removeObject(trap);
            score -= 1; // Decrease score by 1 for Crab Trap
        }
    }
}
