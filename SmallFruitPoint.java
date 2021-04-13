import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class SmallFruitPoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallFruitPoint extends Points
{
    public SmallFruitPoint(int variable){
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
            score = score + 30; 
            juego.removeObject(this);
            juego.IncrementScore(score);
        } 
    }   
}
