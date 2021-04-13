import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int OFFSET = 2;
    private int currentImage;
    private int counter;
    private int direction;
    private int lives = 3;
    public Pacman()
    {
        setImage("images/pacman-close.png");
    }

    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveMouth();       
        handleDirection(); 
        if( getX() <= 0){
           setLocation( 640, 225);
        }
        else if(getX() >640){
           setLocation(10, 225);
        }
        if(isTouching(Phantom.class)){
            PacmanLevel1 juego = (PacmanLevel1) getWorld();
            setLocation(140, 225);
            lives = lives - 1; 
            juego.DecreaseLives(lives); 
            if(lives==0){
                Greenfoot.stop();
            }
        }
    }   
    
    public void handleDirection(){
        int x = getX();
        int y = getY();
        
        if(Greenfoot.isKeyDown("right") && isTouching(Wall.class) == false){
                setLocation(x + OFFSET, y);
                direction = 2;
        }
        else if(isTouching(Wall.class)){
            setLocation(x - OFFSET, y);
        }
        
        if(Greenfoot.isKeyDown("left") && isTouching(Wall.class) == false){
                setLocation(x - OFFSET, y);
                direction = 1;
        }
        else if(isTouching(Wall.class)){
            setLocation(x + OFFSET, y);
            
        }        
        
        if(Greenfoot.isKeyDown("down") && isTouching(Wall.class) == false){
                setLocation(x, y + OFFSET);
                direction = 4;
        }
        else if(isTouching(Wall.class)){
            setLocation(x, y - OFFSET);
        }
           
        if(Greenfoot.isKeyDown("up") && isTouching(Wall.class) == false){
                setLocation(x, y - OFFSET);
                direction = 3;
        }
        else if(isTouching(Wall.class)){
             setLocation(x, y + OFFSET);  
        }
    }

    public void moveMouth(){
        if(counter == 0){
            if(currentImage == 0 && direction ==2){
                setImage("images/pacman-close.png");
            } else if(currentImage == 1 && direction == 2){
                setImage("images/pacman-open.png");
            }

            if(currentImage == 0 && direction ==1){
                setImage("images/pacman-close-left.png");
            } else if(currentImage == 1 && direction == 1){
                setImage("images/pacman-open-left.png");
            }
            
            if(currentImage == 0 && direction ==3){
                setImage("images/pacman-close-up.png");
            } else if(currentImage == 1 && direction == 3){
                setImage("images/pacman-open-up.png");
            }
            
            if(currentImage == 0 && direction ==4){
                setImage("images/pacman-close-down.png");
            } else if(currentImage == 1 && direction==4){
                setImage("images/pacman-open-down.png");
            }
            currentImage = (currentImage +1) % 2;
        }
        counter = (counter + 1) % 10;
    }
}
