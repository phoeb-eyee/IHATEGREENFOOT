import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabTrap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KrabbyPatty extends FallingObjects
{
    /**
     * Act - do whatever the CrabTrap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /*
    public void act()
    {
        // Add your action code here.
    }
    */
    
    private int dropSpeed=1;
    private boolean onBottom=false;
     
  public void fall(){
      if (!onBottom) { //new conditional 2
          this.setLocation(getX(),getY()+dropSpeed);
          onBottom=checkBottom();
      }
    }

  public boolean  checkBottom(){
      
      if (getY()>570){ //new conditional 3
          return true;
        }
        else {
        return false;
    }
 }
}
