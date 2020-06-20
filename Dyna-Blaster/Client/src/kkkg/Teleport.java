package kkkg;

import java.awt.*;
/**
 * Describes a teleport - it's an object which transfer player to another level
 */

public class Teleport extends GameObject {


    public Teleport(int x,int y,ID type)
    {
        super(x,y,type);
    }
    /** Teleport's tick method - it checks throughout game if Player completed the level*/
    public void tick()
    {
        if(isPlayerOnTeleport())
        {
            GameManager.flagLevelCompleted = true;
        }
        else
            GameManager.flagLevelCompleted = false;

    }

    /**
     * Render graphics for object Obstacle
     * @param g Object of Graphics class which is used to render image
     */
    public void render(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Game.getFrame().Horizontal_scale(),Game.getFrame().Vertical_scale());;
        g2.setColor(Color.magenta);
        g2.fillRect(x, y, Config.ObjectDimension, Config.ObjectDimension);


    }

    /**
     * Chcecks whether Player stands on the teleport or not
     * @return Boolean variable, it's true when Player is on the teleport, it's false when not
     */
    public boolean isPlayerOnTeleport()
    {
        boolean a = false;

        if (getBounds().intersects(Game.getPlayer().getBounds())) {
            a = true;
        }
             return a;

    }

}
