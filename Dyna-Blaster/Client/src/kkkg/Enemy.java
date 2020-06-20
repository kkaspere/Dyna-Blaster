package kkkg;

import java.awt.*;

/**
 * Describes an Enemy
 */

public class Enemy extends GameObject {


    private int velX;
    private int velY;
    public Enemy(int x,int y,ID type, int velX, int velY)
    {
        super(x,y,type);
        this.velX = velX;
        this.velY = velY;



    }
    public void setVelX(int velX) { this.velX = velX; }
    public void setVelY(int velY)
    {
        this.velY = velY;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }

    /**
     * Tick enemy's method which provides enemy movement and bouncing off
     */
    public void tick()
    {

            x += velX;
            y += velY;
            bounce(Game.getHandler());


    }

    /**
     * Render graphics for object Enemy
     * @param g Object of Graphics class which is used to render image
     */
    public void render(Graphics g) {


        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Game.getFrame().Horizontal_scale(),Game.getFrame().Vertical_scale());
        g2.drawImage(Config.Enemyimage, x,y, Config.ObjectDimension, Config.ObjectDimension,null);



    }

    /**
     * Method that provides enemy is bouncing off the obstacles and window frame
     * @param handler Handles all the objects of the game
     */
    public void bounce(Handler handler)
    {
        for (int i = 0; i < handler.object.size(); i++) {


            GameObject tempObject;
            try {
                tempObject = handler.object.get(i);
            } catch (NullPointerException e) {
                break;
            }
            if(tempObject!=null) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (tempObject.getType() == ID.Obstacle || tempObject.getType() == ID.ConstObstacle) {
                        velX = -velX;
                        velY = -velY;

                    }
                }
            }


        }

        double x = (double)this.getX()*Game.getFrame().Horizontal_scale(); //Provide scale
        double y = (double)this.getY()*Game.getFrame().Vertical_scale(); //Provide scale
        if((int)x <= -1 || (int)x >= (int)(((double)(Config.Width - 17 -  Config.ObjectDimension))*Game.getFrame().Horizontal_scale())) {
            velX = -velX;

        }
        if((int)y <= (int)((double)Config.BarHeight*Game.getFrame().Vertical_scale()) || (int)y >= (int)(((double)(Config.Height- Config.ObjectDimension-45)*Game.getFrame().Vertical_scale())))
            velY = -velY;

    }

}
