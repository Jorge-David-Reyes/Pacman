import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanLevel1 extends World
{
    private int counter;
    private int numberPhantoms;
    private int speed;
    Score score = new Score("Score: " );
    Score lives = new Score("lives: " );
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanLevel1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 450, 1);
        speed = 2;
        
        buildWall();
        buildPoints();
        buildFruits();
        addObject(new Pacman(), 140, 225);
        phantoms();
        addObject(score, 550, 15);
        addObject(lives, 100, 15);
    }
    
    public int getRandomNumber(int start, int end){
       int direction = Greenfoot.getRandomNumber(end-start+1);
       return direction+start;
    }
    
    public void buildWall(){
        for(int x = 20; x < 650; x+=38){
                this.addObject(new Wall(), x, 435);  
                this.addObject(new Wall(), x, 15);  
                if(x>=228 && x<=422){
                    if(x<=268 || x>=372){
                        this.addObject(new Wall(), x, 141);
                    }
                    this.addObject(new Wall(), x, 309);
                }                    
        }
        
        for(int y = 16; y < 450; y+=28){
            if(y<=209 || y>=241){
                this.addObject(new Wall(), 15, y);  
                this.addObject(new Wall(), 635, y);
            }
            if(y>=112 && y<=310){
                this.addObject(new Wall(), 210, y+13);
                this.addObject(new Wall(), 438, y+13);
            } 
        }  
    }
    
    public void phantoms(){
        int direction;
        int color=1;
        for(int i=0; i<4; i++){
            direction = getRandomNumber(1, 4);
            
            if(color == 1){
                addObject(new Phantom(speed, direction, color),70, 390);
            }
            else if( color == 2){
                addObject(new Phantom(speed, direction, color),580, 70);
            }
            else if(color == 3){
                addObject(new Phantom(speed, direction, color),580, 375);
            }
            else if(color == 4){
                addObject(new Phantom(speed, direction, color),325, 225);
            }
            numberPhantoms++;
            color++;
        }
    }
    
    public void buildPoints(){
        lives.add(3);
        for(int x = 61; x < 580; x+=38){
            if(x>70){
                this.addObject(new SmallPoints(), x, 393);   
                this.addObject(new SmallPoints(), x, 60);  
            }  
        }
        
        for(int y = 80; y < 380; y+=50){            
            if(y<=200 || y>=280){
                this.addObject(new SmallPoints(), 61, y);  
                this.addObject(new SmallPoints(), 588, y);
            }
            else{
                this.addObject(new BigPoints(), 61, 225);
                this.addObject(new BigPoints(), 588, 225);
            }
        } 
    }  
    
    public void buildFruits(){
        int variable = getRandomNumber(1, 3);      
        addObject(new BigFruitPoint(variable), 325, 225);
        variable = getRandomNumber(1, 3);
        addObject(new SmallFruitPoint(variable), 325, 340);
    }
    
    public void IncrementScore(int points){
        score.add(points);  
    }
    public void DecreaseLives(int vidas){
        lives.subtract(vidas);        
    }
}
