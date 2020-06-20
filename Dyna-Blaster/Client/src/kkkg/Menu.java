package kkkg;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is responsible for menu system functionality
 */

public class Menu extends MouseAdapter  {

    /**
     * Enumeration that determines the menu states
     */
    public enum MenuState {

      MainMenu, DifficultyLevel, Nick;

    }
    public static MenuState State;
    /**
     * Reference to the main game frame
     */
    private MyFrame frame;
    /**Reference to a actual user of a game*/
    private User user;
    /**Reference to GameManager that manages the game*/
    private GameManager manager;
    public Menu(MyFrame frame,User user, GameManager manager)
    {


        State = MenuState.MainMenu;
        this.frame = frame;
        this.user = user;
        this.manager = manager;



    }

    /**
     * It's a method that in overall operates the whole menu, it's called when user click somewhere,
       When user click on the particular button, this method changes game or menu state or/and take
       some actions
     * @param e Variable that stores information of coordinates where moused was pressed
     */
    public void mousePressed(MouseEvent e)
    {
        int mx = e.getX();
        int my = e.getY();
        // provide scale
        int menuBarheight = (int)((double)Config.MenuBarHeight*frame.Vertical_scale());
        int menuBarwidth = (int)((double)Config.MenuBarWidth*frame.Horizontal_scale());
        int menuBarX = (int)((double)Config.MenuBarX*frame.Horizontal_scale());
        int menuBarY1 = (int)((double)Config.MenuBarY_1*frame.Vertical_scale());
        int menuBarY2 = (int)((double)Config.MenuBarY_2*frame.Vertical_scale());
        int menuBarY3 = (int)((double)Config.MenuBarY_3*frame.Vertical_scale());
        int menuBarY4 =  (int)((double)Config.MenuBarY_4*frame.Vertical_scale());

        int PauseButtonX = (int)((double)Config.PauseButton_X*frame.Horizontal_scale());
        int PauseButtonY =  (int)((double)Config.PauseButton_Y*frame.Vertical_scale());
        int PauseButtonWidth = (int)((double)Config.PauseButton_Size*frame.Horizontal_scale());
        int PauseButtonHeight = (int)((double)Config.PauseButton_Size*frame.Vertical_scale());

        int ReturnButtonX = (int)((double)Config.ReturnButton_X*frame.Horizontal_scale());
        int ReturnButtonY = (int)((double)Config.ReturnButton_Y*frame.Vertical_scale());
        int ReturnButtonWidth = (int)((double)Config.ReturnWidth*frame.Horizontal_scale());
        int ReturnButtonHeight = (int)((double)Config.ReturnHeight*frame.Vertical_scale());

        int PlayAgainButtonX = (int)((double)Config.PlayAgainButton_X*frame.Horizontal_scale());
        int MenuBackButtonX = (int)((double)Config.MenuBackButton_X*frame.Horizontal_scale());

        int EndGameButtonY = (int)((double)Config.GameEndButton_Y*frame.Vertical_scale());
        int EndGameButtonWidth = (int)((double)Config.GameEndButtonWidth*frame.Horizontal_scale());

        int NickInputX = (int)((double)Config.NickInputX*frame.Horizontal_scale());
        int NickInputY =  (int)((double)Config.NickInputY*frame.Vertical_scale());
        int NickInputWidth = (int)((double)Config.NickInputWidth*frame.Horizontal_scale());
        int NickInputHeight = (int)((double)Config.NickInputHeight*frame.Vertical_scale());

        int SubmitButtonX = (int)((double)Config.SubmitButton_X*frame.Horizontal_scale());
        int SubmitButtonY =  (int)((double)Config.SubmitButton_Y*frame.Vertical_scale());
        int SubmitButtonWidth = (int)((double)Config.SubmitButtonWidth*frame.Horizontal_scale());
        int SubmitButtonHeight = (int)((double)Config.SubmitButtonHeight*frame.Vertical_scale());

    if(GameManager.State == GameState.Menu) {
        if(State == MenuState.MainMenu) {
            if (MouseBound(mx, my, menuBarX, menuBarY1,  menuBarwidth, menuBarheight)) {


                State = MenuState.DifficultyLevel;


            }
            if (MouseBound(mx, my, menuBarX, menuBarY2,  menuBarwidth, menuBarheight)){

                frame.getFrame().setResizable(false);
                if(Client.Connected) {
                    GameManager.State = GameState.Ranking;
                    new Properties();
                }
                else
                JOptionPane.showMessageDialog(frame.getFrame(), "Offline mode, can't load ranking table","Error", JOptionPane.ERROR_MESSAGE);

            }
            if (MouseBound(mx, my,menuBarX, menuBarY3,  menuBarwidth, menuBarheight)) {

                GameManager.State = GameState.Help;
                new Properties();

            }
            if (MouseBound(mx, my, menuBarX, menuBarY4,  menuBarwidth, menuBarheight)) {


                System.exit(0);

            }
        }

        else if (State == MenuState.DifficultyLevel) {
            if (MouseBound(mx, my, menuBarX, menuBarY1,  menuBarwidth, menuBarheight)) {
                GameManager.Difficulty = DifficultyLevel.EASY;

                frame.activateTextField();
                State = MenuState.Nick;
                frame.getFrame().setResizable(false);
                frame.getTextField().setBounds(NickInputX,NickInputY,NickInputWidth,NickInputHeight);


            }
            if (MouseBound(mx, my, menuBarX, menuBarY2,  menuBarwidth, menuBarheight)) {

                GameManager.Difficulty = DifficultyLevel.MEDIUM;
                frame.activateTextField();
                State = MenuState.Nick;
                frame.getFrame().setResizable(false);
                frame.getTextField().setBounds(NickInputX,NickInputY,NickInputWidth,NickInputHeight);



            }
            if (MouseBound(mx, my, menuBarX, menuBarY3,  menuBarwidth, menuBarheight)) {

                GameManager.Difficulty = DifficultyLevel.HARD;
                frame.activateTextField();
                State = MenuState.Nick;
                frame.getFrame().setResizable(false);
                frame.getTextField().setBounds(NickInputX,NickInputY,NickInputWidth,NickInputHeight);


            }

        }
        else if(State == MenuState.Nick)
        {
            if (MouseBound(mx, my, SubmitButtonX,SubmitButtonY,SubmitButtonWidth,SubmitButtonHeight)) {


                user.setNick(frame.getTextField().getText());
                frame.deactivateTextField();
                GameManager.State = GameState.SetLevel;
                frame.getFrame().setResizable(true);

            }

        }
    }

    else if(GameManager.State == GameState.Play)
    {

        if (MouseBound(mx, my, PauseButtonX, PauseButtonY, PauseButtonWidth, PauseButtonHeight)) {


            GameManager.State = GameState.Pause;



        }
        if(GameManager.State != GameState.Pause) {
            if (MouseBound(mx, my, ReturnButtonX, ReturnButtonY, ReturnButtonWidth, ReturnButtonHeight)) {


                manager.resetGame();
                GameManager.State = GameState.Menu;
                State = MenuState.MainMenu;


            }
        }



    }
    else if(GameManager.State == GameState.Pause)
    {
        if(MouseBound(mx, my, PauseButtonX, PauseButtonY, PauseButtonWidth, PauseButtonHeight)) {


            GameManager.State = GameState.Play;



          }

    }
    else if(GameManager.State == GameState.GameOver||GameManager.State == GameState.GameCompleted)
    {

        if(MouseBound(mx, my, PlayAgainButtonX, EndGameButtonY, EndGameButtonWidth, menuBarheight)) {




            manager.resetGame();
            GameManager.State = GameState.SetLevel;



        }

        if(MouseBound(mx, my, MenuBackButtonX, EndGameButtonY, EndGameButtonWidth, menuBarheight)) {

            manager.resetGame();
            GameManager.State = GameState.Menu;
            State = MenuState.MainMenu;


        }

    }


    }
    public void mouseReleased(MouseEvent e)
    {



    }

        /**
         * Determines if the user clicked on the button specified by the parameters of method
         * @param mx x coordinate of where user clicked
         * @param my y coordinate of where user clicked
         * @param x x coordinate of the button
         * @param y y coordinate of the button
         * @param width width of the button
         * @param height height of the button
         * @return It returns true if user clicked on the button or false if not
         */
    public boolean MouseBound(int mx,int my,int x,int y,int width, int height)
    {
        if (mx > x && mx < width + x && my > y && my < y + height)
            return true;
        else
            return false;

    }

}
