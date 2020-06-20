package kkkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Responsible for proper functionality of game, it's starts, restarts game, sets level, reads config data etc.
 */
public class GameManager {

    private User user;
    private Handler handler;
    private static int seconds = 0;
    private static int minutes = 0;
    /**
     * Responsible for reading data from files (in offline mode)/linked lists (in online mode) etc.
     */
    private DataReader datareader;

    public static boolean flagLevelCompleted = false;
    public static boolean isPlayerAlive = false;
    public static int CurrentLevel = 1;
    public static GameState State;
    public static DifficultyLevel Difficulty;

    /**
     * Timer for game
     */
    private static Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(State == GameState.Play) {
                if (seconds < 59)
                    seconds++;
                else {
                    minutes += 1;
                    seconds = 0;
                }
            }
        }

    });
    public GameManager(User user, Handler handler) {

        this.handler = handler;
        this.user = user;
        datareader = new DataReader();
        ReadGameData();

    }
    /**
     * Reads data game from local files if game is in offline mode or load it from server when game is in
     * online mode
     */
    public void ReadGameData()
    {
        if(Client.Connected) {
            if(Client.isConfigDataReceived) {
                datareader.Data_Read_online();
                State = GameState.Menu;
            }
        }
        else {
            datareader.Data_Read_offline();
            State = GameState.Menu;
        }


    }

    /**
     * Sets game - load level (from local files if offline, from server if online) and then starts game or go to the
     * next level
     */
    public void setGame()
    {

        if(Client.Connected)
        {
            if(Client.isLevelSet) {
                setLevelOnline();
                if(CurrentLevel == 1)
                    startGame();
                else
                    State = GameState.Play; // Game just go to state "play" and it's in the next level
            }
        }
        else {
            setLevelOffline();
            if(CurrentLevel == 1)
                startGame();
            else
                State = GameState.Play; // Game just go to state "play" and it's in the next level
        }



    }

    /**
     * Sets difficulty level depend on the user's choice
     */
    public void setDifficultyLevel()
    {
        if(Difficulty == DifficultyLevel.EASY) {
            user.setLifes(Config.Lifes_Easy);

        }
        else if(Difficulty == DifficultyLevel.MEDIUM) {
            user.setLifes(Config.Lifes_Medium);

        }
        else {

            user.setLifes(Config.Lifes_Hard);
        }

    }

    /**
     * Resets game
     */
    public void resetGame()
    {
        CurrentLevel = 1;
    }

    /**
     * Starts game
     */
    public void startGame()
    {
        setDifficultyLevel();
        user.setScore(0);
        start_timer();
        State = GameState.Play;

    }

    /**
     * Sets level in online mode using data received from server
     */
    public void setLevelOnline()
    {

        Game.getPlayer().setX(0);
        Game.getPlayer().setY(Config.BarHeight);
        handler.delete_everything();
        datareader.readLevelDataOnline();
        handler.add(Game.getPlayer());



    }

    /**
     * Sets level offline using local files
     */
    public void setLevelOffline()
    {

        Game.getPlayer().setX(0);
        Game.getPlayer().setY(Config.BarHeight);
        handler.delete_everything();
        datareader.readLevelDataOffline();
        handler.add(Game.getPlayer());



    }
    /**
     * Sets final score - it depends on the time and difficulty level
     */
    public void setFinalScore()
    {

        user.ScoreForTimeAdder(minutes);
        user.ScoreMultipier();

    }
    public static void start_timer()
    {
        seconds = 0;
        minutes = 0;
        timer.setInitialDelay(1000);
        timer.start();

    }
    public static int getSec()
    {
        return seconds;
    }
    public static int getMin()
    {
        return minutes;
    }

    public User getUser() {
        return user;
    }

}
