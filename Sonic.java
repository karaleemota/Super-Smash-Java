import greenfoot.*;

/**
 * Write a description of class Sonic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sonic extends Fighter
{
    private int moveSpeed;
    private int moveCounter1 = 0;
    static GreenfootImage rightJump1;
    static GreenfootImage rightJump2;
    static GreenfootImage rightJump3;
    static GreenfootImage leftJump1;
    static GreenfootImage leftJump2;
    static GreenfootImage leftJump3;
    /**
     * Act - do whatever the Sonic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        groundHeight = getImage().getHeight()/2;//update image to use for gravity in fighter class
       applyGravity();
        animate();
        jump(13);
        lightAttack(5,2);
        moveRight(moveSpeed);
        moveLeft(moveSpeed);
        labelFollow();
        fallOffEdge();
        Player2Wins();
    }    
    public Sonic()
    {
        rightStand1 = new GreenfootImage("sonicRightStand1.gif");
        rightStand2 = new GreenfootImage("sonicRightStand2.gif");
        rightStand3 = new GreenfootImage("sonicRightStand3.gif");
        leftStand1 = new GreenfootImage("sonicLeftStand1.gif");
        leftStand2 = new GreenfootImage("sonicLeftStand2.gif");
        leftStand3 = new GreenfootImage("sonicLeftStand3.gif");
        moveRight1 = new GreenfootImage("sonicMoveRight1.gif");
        moveRight2 = new GreenfootImage("sonicMoveRight2.gif");
        moveRight3 = new GreenfootImage("sonicMoveRight3.gif");
        moveLeft1 = new GreenfootImage("sonicMoveLeft1.gif");
        moveLeft2 = new GreenfootImage("sonicMoveLeft2.gif");
        moveLeft3 = new GreenfootImage("sonicMoveLeft3.gif");
        rightPunch1 = new GreenfootImage("sonicRightPunch1.gif");
        rightPunch2 = new GreenfootImage("sonicRightPunch2.gif");
        rightPunch3 = new GreenfootImage("sonicRightPunch3.gif");
        rightPunch4 = new GreenfootImage("sonicRightPunch4.gif");
        leftPunch1 = new GreenfootImage("sonicLeftPunch1.gif");
        leftPunch2 = new GreenfootImage("sonicLeftPunch2.gif");
        leftPunch3 = new GreenfootImage("sonicLeftPunch3.gif");
        leftPunch4 = new GreenfootImage("sonicLeftPunch4.gif");
        rightJump1 = new GreenfootImage("sonicRightJump1.gif");
        rightJump2 = new GreenfootImage("sonicRightJump2.gif");
        rightJump3 = new GreenfootImage("sonicRightJump3.gif");
        leftJump1 = new GreenfootImage("sonicLeftJump1.gif");
        leftJump2 = new GreenfootImage("sonicLeftJump2.gif");
        leftJump3 = new GreenfootImage("sonicLeftJump3.gif");
        punchSound = new GreenfootSound("sonicPunch.wav");
        setImage(rightStand1);
        moveSpeed = 7;
        p1 = new P1();
        healthBar = (new Bar("Sonic","HP",100,100));
    }
    public void jump(int height)
    {
          
          if(Greenfoot.isKeyDown("w") )
          {
              if(isFacedRight())
                {
                    moveCounter1++;
                    if(moveCounter1 == 6 )
                     {
                        if ((getImage()  != rightJump1 && getImage() !=rightJump2 && getImage() != rightJump3) || isOnGround())
                        {
                            setImage(rightJump1);
                        }
                        else if (getImage() == rightJump1 )
                        {
                            setImage(rightJump2);
                        }
                        else if(getImage() == rightJump2 )
                        {
                            setImage(rightJump3);
                        }
                        else if ( getImage() != rightJump3 )
                        {
                            setImage(rightJump1);
                        }
                        moveCounter1 = 0;
                    }
                }
                else if(!isFacedRight())
                {
                    moveCounter1++;
                    if(moveCounter1 == 6 )
                    {
                        if ((getImage()  != leftJump1 && getImage() !=leftJump2 && getImage() != leftJump3) || isOnGround())
                        {
                            setImage(leftJump1);
                        }
                        else if (getImage() == leftJump1 )
                        {
                            setImage(leftJump2);
                        }
                        else if(getImage() == leftJump2 )
                        {
                            setImage(leftJump3);
                        }
                        else if ( getImage() != leftJump3 )
                        {
                            setImage(leftJump1);
                        }
                        moveCounter1 = 0;
                    }
                }
              setLocation(getX(),getY()-height);
          }
    }
    protected void addedToWorld(World world)
    {
        world.addObject(healthBar, 125, 30);
        world.addObject(p1,getX(),getY()-getImage().getHeight()/2-15);
    }
    public Bar getHealthBar()
    {
        return healthBar;
    }
    public void specialAttack()
    {
    }
    public void labelFollow()
    {
        p1.setLocation(this.getX(),this.getY()-getImage().getHeight()/2-15);
    }
    
}

