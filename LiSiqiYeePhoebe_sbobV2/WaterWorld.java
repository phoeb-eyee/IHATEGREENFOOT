import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class WaterWorld here.
 * 
 */
public class WaterWorld extends World
{
    private ArrayList<String> texts = new ArrayList<>();
    private int timer = 0;

    /**
     * Constructor for objects of class WaterWorld.
     * 
     */
    public WaterWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
        Greenfoot.setSpeed(50); // Adjust game speed
        
        // Add initial text elements
        texts.add("Score: 0");
        texts.add("Speed: 1");
        updateTexts();
    }
    
    public void act()
    {
        if (timer % 60 == 0) { // Adjust timing
            dropGold();
        }
        if (timer % 180 == 0) { // Adjust timing
            dropKrabbyPatty();
        }
        if (timer % 360 == 0) { // Adjust timing
            dropCrabTrap();
        }
        timer++;
    }
    
    public void dropGold(){
        PirateGold g = new PirateGold();
        addObject(g, Greenfoot.getRandomNumber(getWidth() - 100), 10);
    }
    
    public void dropKrabbyPatty(){
        KrabbyPatty k = new KrabbyPatty();
        addObject(k, 50 + Greenfoot.getRandomNumber(getWidth() - 100), 10);
    }
    
    public void dropCrabTrap(){
        CrabTrap t = new CrabTrap();
        addObject(t, 50 + Greenfoot.getRandomNumber(getWidth() - 100), 10);
    }
    
    public void prepare()
    {
        Sbob sbob = new Sbob();
        addObject(sbob, 399, 527);
    }
    
    public void updateText(String text, int x, int y, String identifier) {
        if (identifier.equals("score")) {
            texts.set(0, text);
        } else if (identifier.equals("speed")) {
            texts.set(1, text);
        }
        updateTexts();
    }
    
    private void updateTexts() {
        // Clear previous text
        showText("", 0, 0);
        
        // Display all texts
        for (int i = 0; i < texts.size(); i++) {
            showText(texts.get(i), 100 + i * 150, 20);
        }
    }
}
