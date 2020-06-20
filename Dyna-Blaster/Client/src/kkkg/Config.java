package kkkg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Stores all configuration data and images used in the application
 */
public class Config {

    private static DataReader datareader = new DataReader();
    /**
     * Stores title which is showed on the top of window frame
     */
    public static String GameTitle;
    /**
     * Contains URL adress of file containing basic configuration data (offline)
     */
    public static String MainProperties = "resources/config.properties";
    /**
     * Contains URL adress of file containing level 1 configuration data (offfline)
     */
    public static String Level1Properties = "resources/level1.properties";
    /**
     * Contains URL adress of file containing level 2 configuration data (offfline)
     */
    public static String Level2Properties = "resources/level2.properties";
    /**
     * Contains URL adress of file containing level 3 configuration data (offfline)
     */
    public static String Level3Properties = "resources/level3.properties";
    /**
     * Contains URL adress of file containing client configuration data
     */
    public static String ClientConfigProperties = "resources/client-config.properties";

    //Client config
    public static String Host;
    public static int Port;

    static {
        try {
            Host = datareader.setStringValue("#HOST",ClientConfigProperties);
            Port = datareader.setNumericValue("#PORT", ClientConfigProperties);
        } catch (FileNotFoundException e) {
            Host = "localhost";
            Port = 1000;
            e.printStackTrace();
        }
    }

    // Frame Dimensions
    public static int GameHeight;
    public static int Width;
    public static int ObjectDimension;
    public static int BarHeight;
    public static int Height;
    public static int MenuBarHeight;
    public static int MenuBarWidth;

    //Camponents positions and dimensions
    public static int MenuBarX;
    public static int MenuBarY_1;
    public static int MenuBarY_2;
    public static int MenuBarY_3;
    public static int MenuBarY_4;
    public static int String_Menu_Y1;
    public static int String_Menu_Y2;
    public static int String_Menu_Y3;
    public static int String_Menu_Y4;
    public static int String_Play_X;
    public static int String_Ranking_X;
    public static int String_Help_X;
    public static int String_Exit_X;
    public static int String_Easy_X;
    public static int String_Medium_X;
    public static int String_Hard_X;
    public static int ParamDisplayY;
    public static int ParamDisplayX_1;
    public static int ParamDisplayX_2;
    public static int ParamDisplayX_3;

    public static int PauseButton_X;
    public static int PauseButton_Y;
    public static int PauseButton_Size;

    public static int ReturnButton_X;
    public static int ReturnButton_Y;
    public static int ReturnWidth;
    public static int ReturnHeight;
    public static int ReturnString_X;
    public static int ReturnString_Y;

    public static int Title_X;
    public static int Title_Y;

    public static int SubmitButton_X;
    public static int SubmitButton_Y;
    public static int SubmitButtonWidth;
    public static int SubmitButtonHeight;

    public static int SubmitStr_X;
    public static int SubmitStr_Y;
    public static int Command1Str_X;
    public static int Command1Str_Y;

    public static int PlayAgainButton_X;
    public static int GameEndButton_Y;
    public static int GameEndButtonWidth;
    public static int MenuBackButton_X;

    public static int GameCompletedStr_X;
    public static int YourScoreStr_X;
    public static int YouLostStr_X;

    public static int PlayAgainStr_X;
    public static int MenuBackStr_X;
    public static int Inform1Str_Y;
    public static int Inform2Str_Y;
    public static int ScoreStr_X;
    public static int ScoreStr_Y;
    public static int GameEndStrButton_Y;

    public static int GamePausedStr_X;
    public static int GamePausedStr_Y;

    public static int GamePausedLabel_X;
    public static int GamePausedLabel_Y;
    public static int GamePausedLabelWidth;
    public static int GamePausedLabelHeight;

    public static int NickInputX;
    public static int NickInputY;
    public static int NickInputWidth;
    public static int NickInputHeight;

    public static int Top10StringX;
    public static int Top10StringY;
    public static int RankingStringX;
    public static int RankingStringY;
    public static int RankingStringGap;
    public static int RankingNotReceivedStringX;
    public static int RankingNotReceivedStringY;

    public static int PropertiesFrameRankingWidth;
    public static int PropertiesFrameRankingHeight;
    public static int PropertiesFrameHelpWidth;
    public static int PropertiesFrameHelpHeight;

    public static int LevelStringX;
    public static int LevelStringY;
    public static int NickStringX;
    public static int NickStringY;


    //Fonts


    // Images
    public static BufferedImage Background = null;
    public static BufferedImage Background2 = null;
    public static BufferedImage Title = null;
    public static BufferedImage Bombimage = null;
    public static BufferedImage Enemyimage = null;
    public static BufferedImage Obstacleimage = null;
    public static BufferedImage ConstObstacleimage = null;
    public static BufferedImage Playerimage = null;
    public static BufferedImage ParamDisplayimage = null;
    public static BufferedImage Pauseimage = null;
    public static BufferedImage BonusPointGoldimage = null;
    public static BufferedImage BonusPointSilverimage = null;
    public static BufferedImage BonusPointBrownimage = null;
    public static BufferedImage FireVerticalimage = null;
    public static BufferedImage FireHorizontalimage = null;
    public static BufferedImage FireCrossimage = null;
    public static BufferedImage QuestionMarkimage = null;
    public static BufferedImage GoldCupimage = null;
    public static BufferedImage Helpimage = null;

    //Image - files
    private static File backgroundFile = new File("resources/background2.jpg");
    private static File titleFile = new File("resources/title2.png");
    private static File backgroundFile2 = new File("resources/back6.jpg");
    private static File BombimageFile = new File("resources/bomb.png");
    private static File EnemyimageFile = new File("resources/enemy1.png");
    private static File ObstacleimageFile = new File("resources/obstacle2.png");
    private static File ConstObstacleimageFile = new File("resources/obstacle1.png");
    private static File PlayerimageFile = new File("resources/player.png");
    private static File ParamDisplayimageFile = new File("resources/display.png");
    private static File PauseimageFile = new File("resources/pause.png");
    private static File BonusPointGoldimageFile = new File("resources/coin.jpg");
    private static File BonusPointSilverimageFile = new File("resources/coin2.png");
    private static File BonusPointBrownimageFile = new File("resources/coin3.png");
    private static File FireVerticalimageFile = new File("resources/firev.png");
    private static File FireHorizontalimageFile = new File("resources/fireh.png");
    private static File FireCrossimageFile = new File("resources/flamecross.png");
    private static File QuestionMarkimageFile = new File("resources/question.png");
    private static File GoldCupimageFile = new File("resources/goldcup.png");
    private static File HelpimageFile = new File("resources/help.png");
    // Game properties


    public static int LevelsNumber = 3;
    public static int Lifes_Easy;
    public static int Lifes_Medium;
    public static int Lifes_Hard;
    public static int TimeBonus;
    public static int Step;

    //Points
    public static int EnemyKillScore;
    public static int Bonus_1;
    public static int Bonus_2;
    public static int Bonus_3;
    public static int MultEasy;
    public static int MultMedium;
    public static int MultHard;

    //Reading textutes
    static {
        try {
            Background = ImageIO.read(backgroundFile);
            Background2 = ImageIO.read(backgroundFile2);
            Title = ImageIO.read(titleFile);
            Bombimage = ImageIO.read(BombimageFile);
            Enemyimage = ImageIO.read(EnemyimageFile);
            Obstacleimage = ImageIO.read(ObstacleimageFile);
            ConstObstacleimage = ImageIO.read(ConstObstacleimageFile);
            Playerimage = ImageIO.read(PlayerimageFile);
            Pauseimage = ImageIO.read(PauseimageFile);
            ParamDisplayimage = ImageIO.read(ParamDisplayimageFile);
            BonusPointGoldimage = ImageIO.read(BonusPointGoldimageFile);
            BonusPointSilverimage = ImageIO.read(BonusPointSilverimageFile);
            BonusPointBrownimage = ImageIO.read(BonusPointBrownimageFile);
            FireHorizontalimage = ImageIO.read(FireHorizontalimageFile);
            FireVerticalimage = ImageIO.read(FireVerticalimageFile);
            FireCrossimage = ImageIO.read(FireCrossimageFile);
            QuestionMarkimage = ImageIO.read(QuestionMarkimageFile);
            GoldCupimage = ImageIO.read(GoldCupimageFile);
            Helpimage = ImageIO.read(HelpimageFile);
        } catch (
                IOException e) {
            System.err.println("Reading texture error!");
            e.printStackTrace();
        }


    }

    /**
     * Customize the pattern of displaying Integers
     * @param pattern Describes in what way display data
     * @param value displayed data that will be convert into String
     * @return String in customize pattern
     */
    public static String customFormat(String pattern, int value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }
}

