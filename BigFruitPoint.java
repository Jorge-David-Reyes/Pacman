import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FuritsPoints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigFruitPoint extends Points
{
    public BigFruitPoint(int variable){
        if(variable == 1)
            setImage("images/banana.png");
        else if(variable == 2)
            setImage("images/cherries.png");
        else if(variable == 3)
            setImage("images/strowberry.png");
    }
    /**
     * Act - do whatever the FuritsPoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Pacman.class)){
            PacmanLevel1 juego = (PacmanLevel1) getWorld();
            score = score + 40; 
            juego.removeObject(this);
            juego.IncrementScore(score);
        } 
    } 
}
