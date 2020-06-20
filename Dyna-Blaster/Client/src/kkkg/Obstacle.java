package kkkg;

import java.awt.*;
/**
 * Describes an Obstacle
 */
public class Obstacle extends GameObject {


    public Obstacle(int x,int y,ID type)
    {
        super(x,y,type);
    }
    public void tick()
    {


    }

    /**
     * Render graphics for an Obstacle object (depends on the obstacle's ID)
     * @param g Object of Graphics class which is used to render image
     */
    public void render(Graphics g)
    {

        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Game.getFrame().Horizontal_scale(),Game.getFrame().Vertical_scale());
        if(type == ID.Obstacle)
            g2.drawImage(Config.Obstacleimage,x,y,Config.ObjectDimension,Config.ObjectDimension,null);

        else
            g2.drawImage(Config.ConstObstacleimage,x,y,Config.ObjectDimension,Config.ObjectDimension,null);

    }

}
