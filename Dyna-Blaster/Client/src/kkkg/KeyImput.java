package kkkg;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Operate the key imput for the player's moves
 */
public class KeyImput extends KeyAdapter {

    /**
     * Temporary player using in operate the player's moves
     */
    private Player temp2;
    GameManager manager;
    public KeyImput(GameManager manager)
    {
        this.manager = manager;
        temp2 = new Player(0,0, ID.Player);

    }

    /**
     * Operates the moves of the player and going to the next level
     * @param e Key of the pressed button
     */
    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();
        if(GameManager.State == GameState.Play) {


                int x = Game.getPlayer().getX();
                int y = Game.getPlayer().getY();


                    if (key == KeyEvent.VK_DOWN) {

                        y = y + Config.Step;

                    }
                    if (key == KeyEvent.VK_UP) {

                        y = y - Config.Step;

                    }
                    if (key == KeyEvent.VK_LEFT) {

                        x = x - Config.Step;


                    }
                    if (key == KeyEvent.VK_RIGHT) {


                        x = x + Config.Step;

                    }
                    temp2.setX(x);
                    temp2.setY(y);
                    if (!temp2.isCollision(Game.getHandler())) {
                        Game.getPlayer().setX(x);
                        Game.getPlayer().setY(y);
                    }
                    if (key == KeyEvent.VK_SPACE) {
                        GameObject bomb = new Bomb(Game.getPlayer().getX(), Game.getPlayer().getY(), ID.Bomb);
                        Game.getHandler().add(bomb);

                    }
                    if (key == KeyEvent.VK_ENTER) {

                        if(GameManager.flagLevelCompleted)
                        {

                            if(GameManager.CurrentLevel != Config.LevelsNumber) {
                                GameManager.CurrentLevel += 1;


                                GameManager.State = GameState.SetLevel;
                            }

                            else {

                                manager.setFinalScore();
                                GameManager.State = GameState.GameCompleted;
                            }


                        }

                     }



            }
        }



    public void keyReleased(KeyEvent e){

    }

}
