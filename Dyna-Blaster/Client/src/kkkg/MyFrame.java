package kkkg;

import javax.swing.*;
import java.awt.*;

/**
 * Class which is game main frame
 */
public class MyFrame extends Canvas {

    /**Text field which is used to enter a nick by user*/
    private JTextField Nick_input;
    /**Main frame of the game*/
    private JFrame frame;
    /**Reference to an actual user of a game*/
    private User user;
    /**Used for display game parameters*/
    private ParamDisplay paramDisplay;

    public MyFrame(Game game,User user) {

        frame = new JFrame(Config.GameTitle);
        this.user = user;
        paramDisplay = new ParamDisplay(0,0,user);
        Nick_input = new JTextField("");

        frame.add(Nick_input);
        Nick_input.setBounds(Config.NickInputX,Config.NickInputY,Config.NickInputWidth,Config.NickInputHeight);
        Nick_input.setVisible(false);
        Nick_input.setEditable(true);

        frame.setSize(new Dimension(Config.Width,Config.Height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setIconImage(Config.Bombimage);
        frame.setVisible(true);
        game.start();


    }
    public JTextField getTextField()
    {
        return  Nick_input;
    }
    public JFrame getFrame(){return frame;}
    /**Deactivates text field (makes it invisible etc.)*/
    public void deactivateTextField()
    {

       Nick_input.setVisible(false);
       frame.setResizable(true);
       Nick_input.setText("");
       frame.revalidate();
       frame.repaint();

    }
    /**Activates text field*/
    public void activateTextField()
    {
        Nick_input.setVisible(true);
        frame.setResizable(false);
        frame.revalidate();
        frame.repaint();

    }

    /**
     * Renders the graphics in the main frame depends on the state that the game actually has
     * @param handler Stores all objects used in game
     * @param g bject of Graphics class which is used to render images and graphics
     */
    public void render(Handler handler, Graphics g)
    {

        Graphics2D g2 = (Graphics2D)g.create();
        g2.scale(Horizontal_scale(),Vertical_scale());
        Font fontbutton = new Font("Gothic", 1, 20);
        Font fonttext = new Font("Gothic", 1, 50);

        if(GameManager.State == GameState.Menu || GameManager.State == GameState.Ranking)
        {

            if(Menu.State == Menu.MenuState.MainMenu) {

                g.fillRect(0,0,Config.Width,Config.Height);

                g2.drawImage(Config.Background, 0, 0, Config.Width, Config.Height, null);
                g2.drawImage(Config.Title, Config.Title_X, Config.Title_Y,null);

                g2.setColor(Color.black);
                g2.setFont(fontbutton);
                g2.fillRect(Config.MenuBarX, Config.MenuBarY_1, Config.MenuBarWidth, Config.MenuBarHeight);
                g2.fillRect(Config.MenuBarX, Config.MenuBarY_2 , Config.MenuBarWidth, Config.MenuBarHeight);
                g2.fillRect(Config.MenuBarX, Config.MenuBarY_3 ,Config.MenuBarWidth, Config.MenuBarHeight);
                g2.fillRect(Config.MenuBarX,Config.MenuBarY_4, Config.MenuBarWidth, Config.MenuBarHeight);
                g2.setColor(Color.white);
                g2.drawString("PLAY", Config.String_Play_X, Config.String_Menu_Y1);
                g2.drawString("RANKING", Config.String_Ranking_X, Config.String_Menu_Y2);
                g2.drawString("HELP", Config.String_Help_X, Config.String_Menu_Y3);
                g2.drawString("EXIT", Config.String_Exit_X,  Config.String_Menu_Y4);
            }
            else if(Menu.State == Menu.MenuState.DifficultyLevel)
            {
                g2.fillRect(0,0,Config.Width, Config.Height);
                g2.setColor(Color.black);
                g2.setFont(fontbutton);
                g2.fillRect(Config.MenuBarX,Config.MenuBarY_1 , Config.MenuBarWidth, Config.MenuBarHeight);
                g2.fillRect(Config.MenuBarX, Config.MenuBarY_2,Config.MenuBarWidth, Config.MenuBarHeight);
                g2.fillRect(Config.MenuBarX,Config.MenuBarY_3 ,Config.MenuBarWidth, Config.MenuBarHeight);

                g2.setColor(Color.white);
                g2.drawString("EASY", Config.String_Easy_X,  Config.String_Menu_Y1);
                g2.drawString("MEDIUM", Config.String_Medium_X,  Config.String_Menu_Y2);
                g2.drawString("HARD", Config.String_Hard_X, Config.String_Menu_Y3);


            }
            else if (Menu.State == Menu.MenuState.Nick)
            {

                g2.fillRect(0,0,Config.Width,Config.Height);
                g2.setFont(fontbutton);


                g2.setColor(Color.BLACK);
                g2.fillRect(Config.SubmitButton_X,Config.SubmitButton_Y,Config.SubmitButtonWidth,Config.SubmitButtonHeight);
                g2.setColor(Color.white);
                g2.drawString("Put your Nickname:",Config.Command1Str_X,Config.Command1Str_Y);
                g2.drawString("SUBMIT",Config.SubmitStr_X,Config.SubmitStr_Y);


            }


        }
        else if (GameManager.State == GameState.Play) {
            g2.setColor(Color.darkGray);
            g2.fillRect(0, Config.BarHeight, Config.Width, Config.Height);
            handler.render(g);
            paramDisplay.render(g);
        }
        else if(GameManager.State == GameState.GameCompleted){


            g2.drawImage(Config.Background2,0,0,Config.Width,Config.Height,null);
            g2.setColor(Color.black);
            g2.fillRect(Config.PlayAgainButton_X,Config.GameEndButton_Y,Config.GameEndButtonWidth,Config.MenuBarHeight);
            g2.fillRect(Config.MenuBackButton_X,Config.GameEndButton_Y,Config.GameEndButtonWidth,Config.MenuBarHeight);
            g2.setFont(fonttext);

            g2.setColor(new Color(85,223,57));
            g2.drawString("Game completed!",Config.GameCompletedStr_X,Config.Inform1Str_Y);
            g2.setColor(Color.white);
            g2.drawString("Your score:",Config.YourScoreStr_X ,Config.Inform2Str_Y);
            String Score2 = Config.customFormat("000000",user.getScore());
            g2.drawString(Score2,Config.ScoreStr_X,Config.ScoreStr_Y);
            g2.setFont(fontbutton);
            g2.drawString("Play again",Config.PlayAgainStr_X,Config.GameEndStrButton_Y);
            g2.drawString("Menu back", Config.MenuBackStr_X,Config.GameEndStrButton_Y);
            if(Client.Connected)
             g2.drawString("Your score is sending to server...", Config.GameCompletedStr_X,Config.Inform1Str_Y-50);
        }
        else if(GameManager.State == GameState.GameOver)
        {

            g2.setColor(Color.gray);
            g2.drawImage(Config.Background2,0,0,Config.Width,Config.Height,null);
            g2.setColor(Color.black);
            g2.fillRect(Config.PlayAgainButton_X,Config.GameEndButton_Y,Config.GameEndButtonWidth,Config.MenuBarHeight);
            g2.fillRect(Config.MenuBackButton_X,Config.GameEndButton_Y,Config.GameEndButtonWidth,Config.MenuBarHeight);
            g2.setFont(fonttext);

            g2.setColor(new Color(191,5,5));
            g2.drawString("You lost!",Config.YouLostStr_X,Config.Inform1Str_Y);
            g2.setColor(Color.white);
            g2.drawString("Your score:",Config.YourScoreStr_X ,Config.Inform2Str_Y);
            String Score2 = Config.customFormat("000000",user.getScore());
            g2.drawString(Score2,Config.ScoreStr_X ,Config.ScoreStr_Y);

            g2.setFont(fontbutton);
            g2.drawString("Play again",Config.PlayAgainStr_X,Config.GameEndStrButton_Y);
            g2.drawString("Menu back", Config.MenuBackStr_X,Config.GameEndStrButton_Y);


        }
        if(GameManager.State == GameState.Pause)
        {

            g2.setColor(Color.black);
            g2.fillRect(Config.GamePausedLabel_X,Config.GamePausedLabel_Y,Config.GamePausedLabelWidth,Config.GamePausedLabelHeight);
            g2.setFont(fontbutton);
            g2.setColor(Color.white);
            g2.drawString("GAME PAUSED",Config.GamePausedStr_X,Config.GamePausedStr_Y);


        }



    }
    /**
     * Determines horizontal scale depends on actual size of the frame
     * @return double variable of calculated horizontal scale
     */
    public double Horizontal_scale()
    {
        double frame_width = frame.getSize().width-17;
        double scale_width = frame_width/((double)Config.Width-17);
        return scale_width;

    }

    /**
     * Determines vertical scale depends on actual size of the frame
     * @return double variable of calculated vertical scale
     */
    public double Vertical_scale()
    {
        double frame_height = frame.getSize().height-45;
        double scale_height = frame_height/((double)Config.Height-45);
        return scale_height;
    }



}