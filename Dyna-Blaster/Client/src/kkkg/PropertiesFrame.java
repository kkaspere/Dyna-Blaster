package kkkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Frame for displaying ranking and help
 */
public class PropertiesFrame extends Canvas implements WindowListener {

    private Properties properties;

    public PropertiesFrame(Properties properties) {
        this.properties = properties;
        JFrame frame = new JFrame();
        if(GameManager.State == GameState.Ranking) {
            frame.setTitle("Ranking");
            frame.setIconImage(Config.GoldCupimage);
            frame.setSize(new Dimension(Config.PropertiesFrameRankingWidth, Config.PropertiesFrameRankingHeight));
        }
        else {
            frame.setTitle("Help");
            frame.setIconImage(Config.QuestionMarkimage);
            frame.setSize(new Dimension(Config.PropertiesFrameHelpWidth, Config.PropertiesFrameHelpHeight));
        }




        frame.addWindowListener(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(properties);
        frame.setVisible(true);
        properties.start();

    }
    public void windowClosed(WindowEvent e) {


    }
    public void windowDeactivated(WindowEvent e) {


    }
    public void windowActivated(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {

             properties.stop();

    }

    public void windowDeiconified(WindowEvent e) {

    }
    public void windowIconified(WindowEvent e) {

    }
    public void windowOpened(WindowEvent e) {

    }

}
