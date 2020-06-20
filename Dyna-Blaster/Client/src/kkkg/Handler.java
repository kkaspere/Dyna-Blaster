package kkkg;

import java.awt.*;
import java.util.LinkedList;

/**
 * It's a container for all objects in game
 */
public class Handler implements Cloneable {

    /** Linked list which contains GameObject type */
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    public Handler()
    {


    }
    public Handler(Handler handler)
    {

        this.object = handler.object;

    }

    /**
     * Adds object to the handler's linked list
     * @param obj Object supposed to be added to the linked list
     */
    public void add(GameObject obj)
    {
        this.object.add(obj);

    }

    /**
     * Delete object from the handler's linked list
     * @param obj Object supposed to be deleted from the linked list
     */
    public void delete(GameObject obj)
    {
        this.object.remove(obj);


    }

    /**
     * Deletes everything from linked list
     */
    public void delete_everything()
    {

           object.clear();

    }


    /**
     * Render graphics for all objects from the linked list
     * @param g Object of Graphics class which is used to render GameObjects' images
     */
    public void render(Graphics g)
    {
        for(int i=0;i<object.size();i++)
        {
            GameObject tempObject = null;
            try {
                tempObject = this.object.get(i);
            }
            catch(NullPointerException e)
            {
                System.out.println("Null ptr");
            }

            tempObject.render(g);


        }


    }

    /**
     * Tick method of the handler, it provides that objects' (that handler stores) tick methods will be executed
     */
    public void tick()
    {
        for(int i=0;i<object.size();i++)
        {
            GameObject temp = object.get(i);
            temp.tick();

        }

    }
}
