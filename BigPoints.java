import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigPoints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigPoints extends Points
{
    public BigPoints(){
           setImage("images/puntosGrandes.png");
    }
    /**
     * Act - do whatever the BigPoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Pacman.class)){
            PacmanLevel1 juego = (PacmanLevel1) getWorld();
            score = score + 50; 
            juego.removeObject(this);
            juego.IncrementScore(score);
        }
    }  
}
