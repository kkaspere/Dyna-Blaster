package kkkg;

import java.awt.*;

/**
 * Describes a Bonus Point
 */
public class BonusPoint extends GameObject {

    public BonusPoint(int x,int y,ID type)
    {
        super(x,y,type);
    }

    /**
     * Tick method of a bonus points, it checks throughout the game whether player collects it
     */
    public void tick()
    {
        if(wasPointCollected()) {
            if(type == ID.BonusPointGold)
                Game.getUser().AddBonusPointsGold();
            else if(type == ID.BonusPointSilver)
                Game.getUser().AddBonusPointsSilver();
            else
                Game.getUser().AddBonusPointsBrown();

            Game.getHandler().delete(this);
        }

    }

    /**
     * Render graphics for an Bonus Point object (depends on the Bonus Point's ID)
     * @param g Object of Graphics class which is used to render image
     */
    public void render(Graphics g)
    {

        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Game.getFrame().Horizontal_scale(),Game.getFrame().Vertical_scale());
        if(type == ID.BonusPointGold)
          g2.drawImage(Config.BonusPointGoldimage,x,y,Config.ObjectDimension,Config.ObjectDimension,null);
        else if(type == ID.BonusPointSilver)
            g2.drawImage(Config.BonusPointSilverimage,x,y,Config.ObjectDimension,Config.ObjectDimension,null);
        else
            g2.drawImage(Config.BonusPointBrownimage,x,y,Config.ObjectDimension,Config.ObjectDimension,null);


    }

    /**
     * Checks whether was collected or not
     * @return true if was collected, false then not
     */
    public boolean wasPointCollected()
    {
        boolean a = false;


        if (getBounds().intersects(Game.getPlayer().getBounds()))
            a = true;
        else
            a = false;

        return a;

    }
}


