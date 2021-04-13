import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmallPoints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallPoints extends Points
{
    public SmallPoints(){
        setImage("images/puntos.png");
    }
    /**
     * Act - do whatever the SmallPoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Pacman.class)){
            PacmanLevel1 juego = (PacmanLevel1) getWorld();
            score = score + 10; 
            juego.removeObject(this);
            juego.IncrementScore(score);
        }
    }
}
