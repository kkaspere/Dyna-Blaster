package kkkg;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Operates displaying a properties frame (contains help or ranking) in new window
 */
public class Properties extends Canvas implements Runnable {

    /**Ranking's thread*/
    private Thread PropertiesThread;
    /**Determines whether raning is running or not */
    private boolean PropertiesRunning;
    /**PropertiesFrame in which ranking is displaying*/
    private PropertiesFrame frame;

    public Properties()
    {

        frame = new PropertiesFrame(this);


    }

    /**
     * Starts ranking thread
     */
    public void start()
    {
        PropertiesThread = new Thread(this);
        PropertiesThread.start();
        PropertiesRunning = true;


    }

    /**
     * Runs ranking thread
     */
    public void run()
    {
        while(PropertiesRunning)
            render();
        return;

    }

    /**
     * Stops ranking thread
     */
    public void stop()
    {
        try{


            PropertiesRunning = false;
            GameManager.State = GameState.Menu;
            Game.getFrame().getFrame().setResizable(true);

        }catch(Exception e){
            e.printStackTrace();
        }


    }

    /**
     * Renders top 10 scores in frame
     */
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null) {

            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        if(GameManager.State == GameState.Ranking) {
            g.setColor(Color.gray);
            g.fillRect(0, 0, Config.PropertiesFrameRankingWidth, Config.PropertiesFrameRankingHeight);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 20));
            g.drawString("TOP 10:", Config.Top10StringX, Config.Top10StringY);
            g.setFont(new Font("Georgia", 1, 12));
            // to przerobić na ładną funkcję
            int index = 1;
            if (Client.isRankingReceived) {
                for (int i = 0; i < Client.getRankingData().size()-1; i=i+2) {
                    String number = (index) + ".";
                    index++;
                    String s = number + " " + Client.getRankingData().get(i) + " " + Client.getRankingData().get(i+1);
                    g.drawString(s, Config.RankingStringX, Config.RankingStringY + index * Config.RankingStringGap);
                }
                g.dispose();
            }
            else
                g.drawString("Ranking hasn't received yet", Config.RankingNotReceivedStringX, Config.RankingNotReceivedStringY);
            bs.show();
        }
        else {

            g.drawImage(Config.Helpimage,0,0,null);
            g.dispose();
            bs.show();
        }


    }



}
