import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phantom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phantom extends Actor
{
    private int direction;
    private int speed;
    private int color;
    public Phantom(int speed, int direction, int color){
        this.speed = speed;
        this.direction = direction;
        this.color=color;
        
        if(color == 1){
            setImage("images/blue-phantom-left.png");
        }
        else if(color == 2){
            setImage("images/orange-phantom-left.png");
        }
        else if(color == 3){
            setImage("images/red-phantom-left.png");
        }
        else if(color == 4){
            setImage("images/pink-phantom-left.png");
        }
    }
    
    public int getRandomNumber(int start, int end){
       int direction = Greenfoot.getRandomNumber(end-start+1);
       return direction+start;
    }
    /**
     * Act - do whatever the Phantom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
              
        if(direction ==1 && isTouching(Wall.class)== false){
            setLocation(x - speed, y); 
            if(isTouching(Wall.class)){
                setLocation(x + speed, y);    
                direction = 3;
            }
        }
        
        if(direction == 3 && isTouching(Wall.class)== false){
            setLocation(x , y + speed); 
            if(isTouching(Wall.class)){
                setLocation(x , y - speed);               
                direction = 2;
                if(color == 1){
                    setImage("images/blue-phantom-right.png");
                }
            }
        }

        if(direction ==2 && isTouching(Wall.class)== false){
            setLocation(x + speed , y); 
            if(isTouching(Wall.class)){
               setLocation(x - speed , y);
               direction = 4;
            }
        }
        
        if(direction == 4 && isTouching(Wall.class)== false){
            setLocation(x , y - speed); 
            if(isTouching(Wall.class)){
               setLocation(x , y + speed);  
               direction = 1;
               if(color == 1){
                    setImage("images/blue-phantom-left.png");
               }
            }
        }
    }    
}
