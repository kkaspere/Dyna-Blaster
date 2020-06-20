package kkkg;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

/**
 * Main class in which the main thread is being run
 */

public class Game extends Canvas implements Runnable{

    /** Game's main thread */
    private Thread thread;
    /** Stores information whether application is running or not*/
    private boolean running = false;
    /**Main application frame */
    private static MyFrame frame;
    private Menu menu;
    private static User user;
    private static Player player;
    private Client client;
    /** Stores all objects used in game */
    private static Handler handler;
    /**Manages application */
    private GameManager manager;


    public Game()
    {
        GameManager.State = GameState.ReadData;
        client = new Client();
        user = new User();
        handler = new Handler();
        manager = new GameManager(user,handler);
        frame = new MyFrame(this,user);
        menu = new Menu(frame,user,manager);
        this.addKeyListener(new KeyImput(manager));
        this.addMouseListener(menu);
        player = new Player(0,Config.BarHeight,ID.Player);



    }
    /**Starts game thread */
    public void start()
    {

        thread = new Thread(this);
        thread.start();
        running = true;


    }
    /**Runs game thread */
    public void run()
    {


        while(running) {

            try {

                tick();
                thread.sleep(10); // to provide constant fps
                render();

            }
            catch(NullPointerException e)
            {
                e.printStackTrace();

            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }



        }
        return;

    }
    /**Game tick method which takes action depends on the actual game state
     * It provides executing tick methods for client (if application is in online mode) and for handler*/
    public void tick()  {

        if(Client.Connected)
            client.tick();
        if(GameManager.State == GameState.Play) {
            handler.tick();
        }
        if(GameManager.State == GameState.SetLevel)
            manager.setGame();

    }
    /** Renders all graphics for the game */
    private void render() throws NullPointerException  {

        BufferStrategy bs = this.getBufferStrategy();
       if(bs==null) {

            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        frame.render(handler, g);

        g.dispose();
        bs.show();

    }
    public void stop()
    {
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public static MyFrame getFrame()
    {
        return frame;

    }
    /**Respawns player */
    public static void PlayerRespawn()
    {
        if(user.getLifes()!=0)
            user.setLifes(user.getLifes() - 1);
        else
            GameManager.State = GameState.GameOver;
        player.setX(0);
        player.setY(Config.BarHeight);
        handler.add(player);
        GameManager.isPlayerAlive = true;

    }

    public static Player getPlayer()
    {
        return player;
    }
    public static User getUser() {return user;}
    public static Handler getHandler() {return handler;}
    public static void main (String args[]) throws IOException
    {

        new Game();


    }
}
