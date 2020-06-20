package kkkg;

import java.awt.*;

/**
 * Abstract class from which every object in game handler inherits
 */
public abstract class GameObject {

    /**
     * x coordinate of the object
     */
    protected int x;
    /**
     * y coordinate of the object
     */
    protected int y;
    /**
     * object's ID
     */
    protected ID type;
    public GameObject(int x,int y,ID type)
    {
        this.x = x;
        this.y = y;
        this.type = type;

    }
    public abstract void render(Graphics g);
    public abstract void tick();
    public void setX(int x)
    {
        this.x = x;

    }
    public void setY(int y)
    {
        this.y = y;

    }
    public int getX()
    {

        return x;

    }
    public ID getType()
    {
        return type;
    }
    public void setType(ID type)
    {
        this.type = type;

    }
    public int getY()
    {
        return y;
    }

    /** Returns bounds of the object */
    public Rectangle getBounds()
    {
        int Sx = (int)((double)x*Game.getFrame().Horizontal_scale());
        int Sy = (int)((double)y*Game.getFrame().Vertical_scale());
        int Objwidth = (int)((double)Config.ObjectDimension*Game.getFrame().Horizontal_scale());
        int Objheight = (int)((double)Config.ObjectDimension*Game.getFrame().Vertical_scale());
        return new Rectangle(Sx,Sy,Objwidth,Objheight);

    }


}
