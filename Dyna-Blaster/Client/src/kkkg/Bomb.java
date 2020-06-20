package kkkg;


import java.awt.*;

/**
 * Describes a Bomb
 */
// done
public class Bomb extends GameObject{


    /** Stores information whether bomb should be rendered, when it's false the flame is rendered*/
    private boolean isBombVisible;
    /** Boolean variable that stores information if flame 1 intersects indestructible objects*/
    private boolean flame1Collision;
    /** Boolean variable that stores information if flame 2 intersects indestructible objects*/
    private boolean flame2Collision;
    /** Boolean variable that stores information if flame 3 intersects indestructible objects*/
    private boolean flame3Collision;
    /** Boolean variable that stores information if flame 4 intersects indestructible objects*/
    private boolean flame4Collision;
    /** Boolean variable that stores information if bomb killed player or not*/
    private boolean isBombKillPlayer;
    /**Time of creating the bomb*/
    private long CreationTime;
    /**Temporary handler using in destroying objects*/
    private Handler temphandler;
    /**Bomb constructor*/
    public Bomb(int x, int y,ID type)
    {
        super(x,y,type);
        temphandler = new Handler();
        isBombVisible = true;
        flame1Collision = false;
        flame2Collision = false;
        flame3Collision = false;
        flame4Collision = false;
        isBombKillPlayer = false;
        CreationTime = System.currentTimeMillis();


    }
    /**Tick bomb's method */
    public void tick()
    {
        isFlameCollision(Game.getHandler());
        if(System.currentTimeMillis() - CreationTime>=4000) {
            isBombVisible = false;
            Destroy(Game.getHandler());
        }
        if(System.currentTimeMillis() - CreationTime>=4500) {
            Game.getHandler().delete(this);
            if(isBombKillPlayer)
                Game.PlayerRespawn();
        }

    }
    /**
     * Render graphics for object Bomb
     * @param g Object of Graphics class which is used to render image
     */
    public void render(Graphics g)
    {

        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Game.getFrame().Horizontal_scale(),Game.getFrame().Vertical_scale());
        if (isBombVisible) {

            g2.drawImage(Config.Bombimage, x,y, Config.ObjectDimension,Config.ObjectDimension, null);
        }
        else {

            g2.drawImage(Config.FireCrossimage, x,y, Config.ObjectDimension,Config.ObjectDimension, null);
            if(!flame1Collision)
                g2.drawImage(Config.FireHorizontalimage, x-Config.ObjectDimension,y, Config.ObjectDimension,Config.ObjectDimension, null);
            if(!flame2Collision)
                g2.drawImage(Config.FireHorizontalimage, x+Config.ObjectDimension,y, Config.ObjectDimension,Config.ObjectDimension, null);
            if(!flame3Collision)
                g2.drawImage(Config.FireVerticalimage, x,y+Config.ObjectDimension, Config.ObjectDimension,Config.ObjectDimension, null);
            if(!flame4Collision)
                g2.drawImage(Config.FireVerticalimage, x,y-Config.ObjectDimension, Config.ObjectDimension,Config.ObjectDimension, null);



        }


    }

    /**
     * Destroys objects which intersects bomb's flame (except indestructible objects)
     * @param handler Handles all objects used in game
     */
    public void Destroy(Handler handler)
    {

        temphandler.delete_everything();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = null;
            try {
                tempObject = handler.object.get(i);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (!(tempObject == null)) {
                if (getFlameBoundsV().intersects(tempObject.getBounds()) || getFlameBoundsH().intersects(tempObject.getBounds())) {
                    if (tempObject.getType() == ID.Player) {
                        GameManager.isPlayerAlive = false; // Bomb killed the player!
                        isBombKillPlayer = true;
                        temphandler.add(tempObject);
                    }
                    if (tempObject.getType() == ID.Obstacle)
                        temphandler.add(tempObject);
                    if(tempObject.getType() == ID.Enemy) {
                        Game.getUser().EnemyKilledAddScore();
                        temphandler.add(tempObject);
                    }


                }


            }
        }
        for(int i=0;i<temphandler.object.size();i++) // deleting all intersects objects
        {
            handler.delete(temphandler.object.get(i));
        }
    }

    /**
     * Method that returns flame's vertical bounds (a little bit smaller than its actual size for better functionality of game)
     * @return Flame's vertical bounds in Rectangle type
     */
    public Rectangle getFlameBoundsV()
    {
        int Sx = (int)((double)(x+2)*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)((y+2)-Config.ObjectDimension)*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)(Config.ObjectDimension-4)*Game.getFrame().Horizontal_scale());
        int Objheight = (int)((double)(3*Config.ObjectDimension-4)*Game.getFrame().Vertical_scale());

        return new Rectangle(Sx, Sy, Objwidth, Objheight);

    }
    /**
     * Method that returns flame's horizontal bounds (a little bit smaller than its actual size for better functionality of game)
     * @return Flame's horizontal bounds in Rectangle type
     */
    public Rectangle getFlameBoundsH()
    {

        int Sx = (int)((double)((x+2)-Config.ObjectDimension)*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)(y+2)*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)(3*Config.ObjectDimension -4)*Game.getFrame().Horizontal_scale());
        int Objheight = (int)((double)(Config.ObjectDimension-4)*Game.getFrame().Vertical_scale());

        return new Rectangle(Sx, Sy, Objwidth, Objheight);
    }
    /**
     * Method that returns flame's 1 bounds (a little bit smaller than its actual size for better functionality of game)
     * @return Flame's 1 bounds in Rectangle type
     */
    public Rectangle getFlame1Bounds()
    {

        int Sx = (int)((double)((x+5)-Config.ObjectDimension)*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)(y+5)*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Horizontal_scale());
        int Objheight = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Vertical_scale());
        return new Rectangle(Sx, Sy, Objwidth, Objheight);

    }
    /**
     * Method that returns flame's 2 bounds (a little bit smaller than its actual size for better functionality of game)
     * @return Flame's 2 bounds in Rectangle type
     */
    public Rectangle getFlame2Bounds()
    {
        int Sx = (int)((double)(x+5+Config.ObjectDimension)*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)(y+5)*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Horizontal_scale());
        int Objheight = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Vertical_scale());
        return new Rectangle(Sx, Sy, Objwidth, Objheight);

    }
    /**
     * Method that returns flame's 3 bounds (a little bit smaller than its actual size for better functionality of game)
     * @return Flame's 3 bounds in Rectangle type
     */
    public Rectangle getFlame3Bounds()
    {
        int Sx = (int)((double)(x+5)*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)(y+5+Config.ObjectDimension)*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Horizontal_scale());
        int Objheight = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Vertical_scale());
        return new Rectangle(Sx, Sy, Objwidth, Objheight);

    }
    /**
     * Method that returns flame's 4 bounds (a little bit smaller than its actual size for better functionality of game)
     * @return Flame's 4 bounds in Rectangle type
     */
    public Rectangle getFlame4Bounds()
    {
        int Sx = (int)((double)(x+5)*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)(y+5-Config.ObjectDimension)*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Horizontal_scale());
        int Objheight = (int)((double)(Config.ObjectDimension-15)*Game.getFrame().Vertical_scale());
        return new Rectangle(Sx, Sy, Objwidth, Objheight);
    }

    /**
     * Checks if flame parts intersects indestructible objects and set particular flag if one of the flame part does
     * (particular part of flame is not displayed if it intersects indestructible object)
     */
    public void isFlameCollision(Handler handler)
    {

        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject;
            try {
                tempObject = handler.object.get(i);
            } catch (NullPointerException e) {
                break;
            }
            if (!(tempObject == null)) {
                if (getFlame1Bounds().intersects(tempObject.getBounds())) {
                    if (tempObject.getType() == ID.ConstObstacle) {
                       flame1Collision = true;
                    }
                }

                if (getFlame2Bounds().intersects(tempObject.getBounds())) {
                    if (tempObject.getType() == ID.ConstObstacle) {
                        flame2Collision = true;
                    }

                }

                if (getFlame3Bounds().intersects(tempObject.getBounds())) {
                    if (tempObject.getType() == ID.ConstObstacle) {
                        flame3Collision = true;
                    }

                }

                }
                if (getFlame4Bounds().intersects(tempObject.getBounds())) {
                    if (tempObject.getType() == ID.ConstObstacle) {
                        flame4Collision = true;
                    }

                }


            }
        }


    }


