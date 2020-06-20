package kkkg;

import java.awt.*;
/**
 * Describes a Player
 */
public class Player extends GameObject  {

    public Player(int x, int y, ID type) {
        super(x, y,type);
        GameManager.isPlayerAlive = true;

    }

    /**
     * Player's tick method which checks throughout the game whether Player was killed by the enemy
     */
    public void tick() {

        Bounds();
        if(KilledByEnemy(Game.getHandler()))
            Game.PlayerRespawn();


    }


    /**
     * Render graphics for object Player
     *
     * @param g Object of Graphics class which is used to render image
     */
    public void render(Graphics g) {


        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Game.getFrame().Horizontal_scale(),Game.getFrame().Vertical_scale());

        if(GameManager.isPlayerAlive)
         g2.drawImage(Config.Playerimage, x, y, Config.ObjectDimension,Config.ObjectDimension, null);


    }

    /**
     * Returns bounds of the player object (a little bit smaller than its actual size for make moving player easier)
     * @return Bounds of the player object in Rectangle type
     */
    public Rectangle getBounds() {

        int Sx = (int)((double)(x+2)*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)(y+2)*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)(Config.ObjectDimension-4)*Game.getFrame().Horizontal_scale()) ; //scale
        int Objheight = (int)((double)(Config.ObjectDimension-4)*Game.getFrame().Vertical_scale()) ; //scale
        return new Rectangle(Sx, Sy, Objwidth, Objheight);
    }

    /**
     * Checks whether player has a collision with an obstacle - used for moving a player
     * @param handler Stores all the objects used in the game
     * @return boolean variable, true when player has collision with an obstacle, false when not
     */
    public boolean isCollision(Handler handler) {
        boolean a = false;
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);
            if (!(tempObject == null)) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (tempObject.getType() == ID.Obstacle || tempObject.getType() == ID.ConstObstacle) {
                        a = true;
                        break;
                    } else
                        a = false;
                }
            }
        }
        return a;

    }
    // trzeba to zabijanie playera przeobić

    /**
     * Checkes whether Player was killed by the enemy
     * @param handler Stores all the objects used in the game
     * @return
     */
    public boolean KilledByEnemy(Handler handler)  {

        boolean a = false;

            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject;
                try {
                    tempObject = handler.object.get(i);
                } catch (NullPointerException e) {
                    break;
                }
                if (!(tempObject == null)) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        if (tempObject.getType() == ID.Enemy) {
                            GameManager.isPlayerAlive = false;
                            Game.getHandler().delete(this);
                            a = true;
                            break;
                        }

                    }

                }
            }




            return a;

    }
    /**
     * This method doesn't allow Player to get out of space game
     */
    public void Bounds()
    {


        if (Game.getPlayer().getX() <= 0)
            Game.getPlayer().setX(0);
        if (Game.getPlayer().getX() >= Config.Width - 17 - Config.ObjectDimension)
            Game.getPlayer().setX(Config.Width - 17 - Config.ObjectDimension);
        if (Game.getPlayer().getY() <= Config.BarHeight)
            Game.getPlayer().setY(Config.BarHeight);
        if (Game.getPlayer().getY() >= Config.Height - 45- Config.ObjectDimension)
            Game.getPlayer().setY(Config.Height - 45- Config.ObjectDimension);


    }


}
