package kkkg;

import java.awt.*;

/**
 * Shows actual game parameters - score, time, lives
 */
public class ParamDisplay {


    private int x;
    private int y;
    private User user;
    public ParamDisplay(int x,int y, User user)
    {
        this.x=x;
        this.y=y;
        this.user = user;

    }

    /**
     * Renders bar on which game parameters are shown and the parameters
     * @param g Object of Graphics class which is used to render images and graphics
     */
    public void render(Graphics g) {



        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Game.getFrame().Horizontal_scale(),Game.getFrame().Vertical_scale());

        g2.drawImage(Config.ParamDisplayimage, 0, 0,Config.Width,Config.BarHeight, null);

        g2.setColor(Color.black);
        Font myFont = new Font ("Courier New", 1, 30);
        Font myFont2 = new Font ("Arial", 1, 8);
        Font myFont3 = new Font ("Courier New", 1, 13);
        g2.setFont(myFont);
        g2.drawString(Config.customFormat("00:",GameManager.getMin()) + Config.customFormat("00",GameManager.getSec()) ,Config.ParamDisplayX_1,Config.ParamDisplayY);
        g2.drawString(Config.customFormat("000000",user.getScore()),Config.ParamDisplayX_2,Config.ParamDisplayY);
        g2.drawString(Config.customFormat("#",user.getLifes()),Config.ParamDisplayX_3,Config.ParamDisplayY);

        g2.setColor(Color.black);
        g2.drawImage(Config.Pauseimage,Config.PauseButton_X, Config.PauseButton_Y, Config.PauseButton_Size, Config.PauseButton_Size,null);
        g2.fillRect(Config.ReturnButton_X,Config.ReturnButton_Y,Config.ReturnWidth,Config.ReturnHeight);
        g2.setFont(myFont3);
        g2.drawString("Level: "+ GameManager.CurrentLevel,Config.LevelStringX,Config.LevelStringY);
        g2.drawString("Nick: "+ Game.getUser().getNick(),Config.NickStringX,Config.NickStringY);
        g2.setColor(Color.white);
        g2.setFont(myFont2);
        g2.drawString("RETURN",Config.ReturnString_X,Config.ReturnString_Y);



    }

}



