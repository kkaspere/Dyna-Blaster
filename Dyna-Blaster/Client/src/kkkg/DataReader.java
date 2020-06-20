package kkkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Reads all the configuration data
 */
public class DataReader {


    public DataReader()
    {


    }

    /**
     * Reads game config data when application is connected to server
     */
    public void Data_Read_online(){


        Config.GameHeight = setIntValue_fromServer(Client.getConfigData(), "#GAMEHEIGHT");
        Config.Width = setIntValue_fromServer(Client.getConfigData(), "#WIDTH");
        Config.ObjectDimension = setIntValue_fromServer(Client.getConfigData(), "#OBJECTDIM");
        Config.BarHeight = setIntValue_fromServer(Client.getConfigData(), "#BARHEIGHT");
        Config.Height = setIntValue_fromServer(Client.getConfigData(), "#HEIGHT");
        Config.Step = setIntValue_fromServer(Client.getConfigData(), "#STEP");
        Config.Lifes_Easy = setIntValue_fromServer(Client.getConfigData(), "#LIFESEASY");
        Config.Lifes_Medium = setIntValue_fromServer(Client.getConfigData(), "#LIFESMEDIUM");
        Config.Lifes_Hard = setIntValue_fromServer(Client.getConfigData(), "#LIFESHARD");

        Config.MenuBarHeight = setIntValue_fromServer(Client.getConfigData(), "#MENUBARHEIGHT");
        Config.MenuBarWidth = setIntValue_fromServer(Client.getConfigData(), "#MENUBARWIDTH");
        Config.MenuBarX = setIntValue_fromServer(Client.getConfigData(), "#MENUBARXPOS");
        Config.MenuBarY_1 = setIntValue_fromServer(Client.getConfigData(), "#MENUBARYPOS");
        Config.MenuBarY_2 = setIntValue_fromServer(Client.getConfigData(), "#MENUBARYPOS2");
        Config.MenuBarY_3 = setIntValue_fromServer(Client.getConfigData(), "#MENUBARYPOS3");
        Config.MenuBarY_4 = setIntValue_fromServer(Client.getConfigData(), "#MENUBARYPOS4");

        Config.PauseButton_X = setIntValue_fromServer(Client.getConfigData(), "#PAUSEX");
        Config.PauseButton_Y = setIntValue_fromServer(Client.getConfigData(), "#PAUSEY");
        Config.PauseButton_Size = setIntValue_fromServer(Client.getConfigData(), "#PAUSESIZE");

        Config.ReturnButton_X = setIntValue_fromServer(Client.getConfigData(), "#RETURNX");
        Config.ReturnButton_Y = setIntValue_fromServer(Client.getConfigData(), "#RETURNY");
        Config.ReturnWidth = setIntValue_fromServer(Client.getConfigData(), "#RETURNWIDTH");
        Config.ReturnHeight = setIntValue_fromServer(Client.getConfigData(), "#RETURNHEIGHT");
        Config.ReturnString_X = setIntValue_fromServer(Client.getConfigData(), "#RETURNSTRX");
        Config.ReturnString_Y = setIntValue_fromServer(Client.getConfigData(), "#RETURNSTRY");

        Config.Title_X = setIntValue_fromServer(Client.getConfigData(), "#TITLEX");
        Config.Title_Y = setIntValue_fromServer(Client.getConfigData(), "#TITLEY");
        Config.SubmitButton_X = setIntValue_fromServer(Client.getConfigData(), "#SUBMITBUTTONX");
        Config.SubmitButton_Y = setIntValue_fromServer(Client.getConfigData(), "#SUBMITBUTTONY");
        Config.SubmitButtonWidth = setIntValue_fromServer(Client.getConfigData(), "#SUBMITBUTTONWIDTH");
        Config.SubmitButtonHeight = setIntValue_fromServer(Client.getConfigData(), "#SUBMITBUTTONHEIGHT");

        Config.SubmitStr_X = setIntValue_fromServer(Client.getConfigData(), "#SUBMITSTRX");
        Config.SubmitStr_Y = setIntValue_fromServer(Client.getConfigData(), "#SUBMITSTRY");
        Config.Command1Str_X = setIntValue_fromServer(Client.getConfigData(), "#COMMAND1X");
        Config.Command1Str_Y = setIntValue_fromServer(Client.getConfigData(), "#COMMAND1Y");

        Config.PlayAgainButton_X = setIntValue_fromServer(Client.getConfigData(), "#PLAYAGAINX");
        Config.GameEndButton_Y = setIntValue_fromServer(Client.getConfigData(), "#GAMEENDY");
        Config.GameEndButtonWidth = setIntValue_fromServer(Client.getConfigData(), "#GAMEENDWIDTH");
        Config.MenuBackButton_X = setIntValue_fromServer(Client.getConfigData(), "#MENUBACKX");

        Config.GameCompletedStr_X = setIntValue_fromServer(Client.getConfigData(), "#GAMECOMPLETEDSTRX");
        Config.YourScoreStr_X = setIntValue_fromServer(Client.getConfigData(), "#YOURSCORESTRX");
        Config.PlayAgainStr_X = setIntValue_fromServer(Client.getConfigData(), "#PLAYAGAINSTRX");
        Config.MenuBackStr_X = setIntValue_fromServer(Client.getConfigData(), "#MENUBACKSTRX");
        Config.Inform1Str_Y = setIntValue_fromServer(Client.getConfigData(), "#INFORMSTR1Y");
        Config.Inform2Str_Y = setIntValue_fromServer(Client.getConfigData(), "#INFORMSTR2Y");
        Config.ScoreStr_X = setIntValue_fromServer(Client.getConfigData(), "#SCORESTRX");
        Config.ScoreStr_Y = setIntValue_fromServer(Client.getConfigData(), "#SCORESTRY");
        Config.GameEndStrButton_Y = setIntValue_fromServer(Client.getConfigData(), "#GAMEENDSTRY");
        Config.YouLostStr_X = setIntValue_fromServer(Client.getConfigData(), "#YOULOSTSTRX");

        Config.GamePausedStr_X = setIntValue_fromServer(Client.getConfigData(), "#GAMEPAUSEDSTRX");
        Config.GamePausedStr_Y = setIntValue_fromServer(Client.getConfigData(), "#GAMEPAUSEDSTRY");

        Config.GamePausedLabel_X = setIntValue_fromServer(Client.getConfigData(), "#GAMEPAUSEDLABELX");
        Config.GamePausedLabel_Y = setIntValue_fromServer(Client.getConfigData(), "#GAMEPAUSEDLABELY");
        Config.GamePausedLabelWidth = setIntValue_fromServer(Client.getConfigData(), "#GAMEPAUSEDLABELWIDTH");
        Config.GamePausedLabelHeight =  setIntValue_fromServer(Client.getConfigData(), "#GAMEPAUSEDLABELHEIGHT");


        Config.String_Play_X = setIntValue_fromServer(Client.getConfigData(), "#STRINGPLAYPOSX");
        Config.String_Ranking_X = setIntValue_fromServer(Client.getConfigData(), "#STRINGRANPOSX");
        Config.String_Help_X = setIntValue_fromServer(Client.getConfigData(), "#STRINGHELPPOSX");
        Config.String_Exit_X = setIntValue_fromServer(Client.getConfigData(), "#STRINGEXITPOSX");
        Config.String_Easy_X = setIntValue_fromServer(Client.getConfigData(), "#STRINGEASYPOSX");
        Config.String_Medium_X = setIntValue_fromServer(Client.getConfigData(), "#STRINGMEDPOSX");
        Config.String_Hard_X = setIntValue_fromServer(Client.getConfigData(), "#STRINGHARDPOSX");

        Config.ParamDisplayY = setIntValue_fromServer(Client.getConfigData(), "#PARAMDISPLAYY");
        Config.ParamDisplayX_1 = setIntValue_fromServer(Client.getConfigData(), "#PARAMDISPLAYX_1");
        Config.ParamDisplayX_2 = setIntValue_fromServer(Client.getConfigData(), "#PARAMDISPLAYX_2");
        Config.ParamDisplayX_3 = setIntValue_fromServer(Client.getConfigData(), "#PARAMDISPLAYX_3");

        Config.EnemyKillScore = setIntValue_fromServer(Client.getConfigData(), "#KILLSCORE");
        Config.Bonus_1 = setIntValue_fromServer(Client.getConfigData(), "#BONUS1");
        Config.Bonus_2 = setIntValue_fromServer(Client.getConfigData(), "#BONUS2");
        Config.Bonus_3 = setIntValue_fromServer(Client.getConfigData(), "#BONUS3");
        Config.TimeBonus = setIntValue_fromServer(Client.getConfigData(), "#TIMEBONUS");
        Config.MultEasy = setIntValue_fromServer(Client.getConfigData(), "#MULTE");
        Config.MultMedium = setIntValue_fromServer(Client.getConfigData(), "#MULTM");
        Config.MultHard = setIntValue_fromServer(Client.getConfigData(), "#MULTH");

        Config.GameTitle = setStringValue_fromServer(Client.getConfigData(), "#GAMETITLE");

        Config.NickInputX = setIntValue_fromServer(Client.getConfigData(), "#NICKINPUTX");
        Config.NickInputY = setIntValue_fromServer(Client.getConfigData(), "#NICKINPUTY");
        Config.NickInputWidth = setIntValue_fromServer(Client.getConfigData(), "#NICKINPUTWIDTH");
        Config.NickInputHeight = setIntValue_fromServer(Client.getConfigData(), "#NICKINPUTHEIGHT");

        Config.Top10StringX = setIntValue_fromServer(Client.getConfigData(), "#TOP10STRINGX");
        Config.Top10StringY = setIntValue_fromServer(Client.getConfigData(), "#TOP10STRINGY");
        Config.RankingStringX = setIntValue_fromServer(Client.getConfigData(), "#RANKINGSTRINGX");
        Config.RankingStringY =setIntValue_fromServer(Client.getConfigData(), "#RANKINGSTRINGY");
        Config.RankingStringGap = setIntValue_fromServer(Client.getConfigData(), "#RANKINGSTRINGGAP");
        Config.RankingNotReceivedStringX = setIntValue_fromServer(Client.getConfigData(), "#RANKINGNOTSTRINGX");
        Config.RankingNotReceivedStringY = setIntValue_fromServer(Client.getConfigData(), "#RANKINGNOTSTRINGY");


        Config.PropertiesFrameRankingWidth = setIntValue_fromServer(Client.getConfigData(),"#FRAMERANWIDTH");
        Config.PropertiesFrameRankingHeight = setIntValue_fromServer(Client.getConfigData(),"#FRAMERANHEIGHT");
        Config.PropertiesFrameHelpWidth = setIntValue_fromServer(Client.getConfigData(),"#FRAMEHELPWIDTH");
        Config.PropertiesFrameHelpHeight = setIntValue_fromServer(Client.getConfigData(),"#FRAMEHELPHEIGHT");

        Config.LevelStringX = setIntValue_fromServer(Client.getConfigData(),"#LEVELSTRINGX");
        Config.LevelStringY = setIntValue_fromServer(Client.getConfigData(),"#LEVELSTRINGY");
        Config.NickStringX = setIntValue_fromServer(Client.getConfigData(),"#NICKSTRINGX");
        Config.NickStringY = setIntValue_fromServer(Client.getConfigData(),"#NICKSTRINGY");

        Config.String_Menu_Y1 = setIntValue_fromServer(Client.getConfigData(),"#MENUSTRY1");
        Config.String_Menu_Y2 = setIntValue_fromServer(Client.getConfigData(),"#MENUSTRY2");
        Config.String_Menu_Y3 = setIntValue_fromServer(Client.getConfigData(),"#MENUSTRY3");
        Config.String_Menu_Y4 = setIntValue_fromServer(Client.getConfigData(),"#MENUSTRY4");



    }
    /**
     * Reads game config data when application is not connected to server
     */
    public void Data_Read_offline(){


            try {
                Config.GameHeight = setNumericValue("#GAMEHEIGHT",Config.MainProperties);
                Config.Width = setNumericValue("#WIDTH",Config.MainProperties);
                Config.ObjectDimension = setNumericValue("#OBJECTDIM",Config.MainProperties);
                Config.BarHeight = setNumericValue("#BARHEIGHT",Config.MainProperties);
                Config.Height = setNumericValue("#HEIGHT",Config.MainProperties);
                Config.Step = setNumericValue("#STEP",Config.MainProperties);
                Config.Lifes_Easy = setNumericValue("#LIFESEASY",Config.MainProperties);
                Config.Lifes_Medium = setNumericValue("#LIFESMEDIUM",Config.MainProperties);
                Config.Lifes_Hard = setNumericValue("#LIFESHARD",Config.MainProperties);

                Config.MenuBarHeight = setNumericValue("#MENUBARHEIGHT",Config.MainProperties);
                Config.MenuBarWidth = setNumericValue("#MENUBARWIDTH",Config.MainProperties);
                Config.MenuBarX = setNumericValue("#MENUBARXPOS",Config.MainProperties);
                Config.MenuBarY_1 = setNumericValue("#MENUBARYPOS",Config.MainProperties);
                Config.MenuBarY_2 = setNumericValue("#MENUBARYPOS2",Config.MainProperties);
                Config.MenuBarY_3 = setNumericValue("#MENUBARYPOS3",Config.MainProperties);
                Config.MenuBarY_4 = setNumericValue("#MENUBARYPOS4",Config.MainProperties);
                Config.String_Play_X = setNumericValue("#STRINGPLAYPOSX",Config.MainProperties);
                Config.String_Ranking_X = setNumericValue("#STRINGRANPOSX",Config.MainProperties);
                Config.String_Help_X = setNumericValue("#STRINGHELPPOSX",Config.MainProperties);
                Config.String_Exit_X = setNumericValue("#STRINGEXITPOSX",Config.MainProperties);
                Config.String_Easy_X = setNumericValue("#STRINGEASYPOSX",Config.MainProperties);
                Config.String_Medium_X =  setNumericValue("#STRINGMEDPOSX",Config.MainProperties);
                Config.String_Hard_X = setNumericValue("#STRINGHARDPOSX",Config.MainProperties);
                Config.PauseButton_X = setNumericValue("#PAUSEX",Config.MainProperties);
                Config.PauseButton_Y = setNumericValue("#PAUSEY",Config.MainProperties);
                Config.PauseButton_Size = setNumericValue("#PAUSESIZE",Config.MainProperties);

                Config.ReturnButton_X = setNumericValue("#RETURNX",Config.MainProperties);
                Config.ReturnButton_Y = setNumericValue("#RETURNY",Config.MainProperties);
                Config.ReturnWidth = setNumericValue("#RETURNWIDTH",Config.MainProperties);
                Config.ReturnHeight = setNumericValue("#RETURNHEIGHT",Config.MainProperties);
                Config.ReturnString_X = setNumericValue("#RETURNSTRX",Config.MainProperties);
                Config.ReturnString_Y = setNumericValue("#RETURNSTRY",Config.MainProperties);

                Config.Title_X = setNumericValue("#TITLEX",Config.MainProperties);
                Config.Title_Y = setNumericValue("#TITLEY",Config.MainProperties);
                Config.SubmitButton_X = setNumericValue("#SUBMITBUTTONX",Config.MainProperties);
                Config.SubmitButton_Y = setNumericValue("#SUBMITBUTTONY",Config.MainProperties);
                Config.SubmitButtonWidth = setNumericValue("#SUBMITBUTTONWIDTH",Config.MainProperties);
                Config.SubmitButtonHeight = setNumericValue("#SUBMITBUTTONHEIGHT",Config.MainProperties);

                Config.SubmitStr_X = setNumericValue("#SUBMITSTRX",Config.MainProperties);
                Config.SubmitStr_Y = setNumericValue("#SUBMITSTRY",Config.MainProperties);
                Config.Command1Str_X = setNumericValue("#COMMAND1X",Config.MainProperties);
                Config.Command1Str_Y = setNumericValue("#COMMAND1Y",Config.MainProperties);

                Config.PlayAgainButton_X = setNumericValue("#PLAYAGAINX",Config.MainProperties);
                Config.GameEndButton_Y = setNumericValue("#GAMEENDY",Config.MainProperties);
                Config.GameEndButtonWidth = setNumericValue("#GAMEENDWIDTH",Config.MainProperties);
                Config.MenuBackButton_X = setNumericValue("#MENUBACKX",Config.MainProperties);

                Config.GameCompletedStr_X = setNumericValue("#GAMECOMPLETEDSTRX",Config.MainProperties);
                Config.YourScoreStr_X = setNumericValue("#YOURSCORESTRX",Config.MainProperties);
                Config.PlayAgainStr_X = setNumericValue("#PLAYAGAINSTRX",Config.MainProperties);
                Config.MenuBackStr_X = setNumericValue("#MENUBACKSTRX",Config.MainProperties);
                Config.Inform1Str_Y = setNumericValue("#INFORMSTR1Y",Config.MainProperties);
                Config.Inform2Str_Y = setNumericValue("#INFORMSTR2Y",Config.MainProperties);
                Config.ScoreStr_X = setNumericValue("#SCORESTRX",Config.MainProperties);
                Config.ScoreStr_Y = setNumericValue("#SCORESTRY",Config.MainProperties);
                Config.GameEndStrButton_Y = setNumericValue("#GAMEENDSTRY",Config.MainProperties);
                Config.YouLostStr_X = setNumericValue("#YOULOSTSTRX",Config.MainProperties);

                Config.GamePausedStr_X = setNumericValue("#GAMEPAUSEDSTRX",Config.MainProperties);
                Config.GamePausedStr_Y = setNumericValue("#GAMEPAUSEDSTRY",Config.MainProperties);

                Config.GamePausedLabel_X = setNumericValue("#GAMEPAUSEDLABELX",Config.MainProperties);
                Config.GamePausedLabel_Y = setNumericValue("#GAMEPAUSEDLABELY",Config.MainProperties);
                Config.GamePausedLabelWidth = setNumericValue("#GAMEPAUSEDLABELWIDTH",Config.MainProperties);
                Config.GamePausedLabelHeight =  setNumericValue("#GAMEPAUSEDLABELHEIGHT",Config.MainProperties);

                Config.ParamDisplayY = setNumericValue("#PARAMDISPLAYY",Config.MainProperties);
                Config.ParamDisplayX_1 = setNumericValue("#PARAMDISPLAYX_1",Config.MainProperties);
                Config.ParamDisplayX_2 = setNumericValue("#PARAMDISPLAYX_2",Config.MainProperties);
                Config.ParamDisplayX_3 = setNumericValue("#PARAMDISPLAYX_3",Config.MainProperties);

                Config.EnemyKillScore = setNumericValue("#KILLSCORE",Config.MainProperties);
                Config.Bonus_1 = setNumericValue("#BONUS1",Config.MainProperties);
                Config.Bonus_2 = setNumericValue("#BONUS2",Config.MainProperties);
                Config.Bonus_3 = setNumericValue("#BONUS3",Config.MainProperties);
                Config.TimeBonus = setNumericValue("#TIMEBONUS",Config.MainProperties);
                Config.MultEasy = setNumericValue("#MULTE",Config.MainProperties);
                Config.MultMedium = setNumericValue("#MULTM",Config.MainProperties);
                Config.MultHard = setNumericValue("#MULTH",Config.MainProperties);

                Config.GameTitle = setStringValue("#GAMETITLE",Config.MainProperties);
                Config.NickInputX = setNumericValue("#NICKINPUTX",Config.MainProperties);
                Config.NickInputY = setNumericValue("#NICKINPUTY",Config.MainProperties);
                Config.NickInputWidth = setNumericValue("#NICKINPUTWIDTH",Config.MainProperties);
                Config.NickInputHeight = setNumericValue("#NICKINPUTHEIGHT",Config.MainProperties);

                Config.Top10StringX = setNumericValue( "#TOP10STRINGX",Config.MainProperties );
                Config.Top10StringY = setNumericValue("#TOP10STRINGY",Config.MainProperties);
                Config.RankingStringX = setNumericValue("#RANKINGSTRINGX",Config.MainProperties);
                Config.RankingStringY = setNumericValue("#RANKINGSTRINGY",Config.MainProperties);
                Config.RankingStringGap = setNumericValue("#RANKINGSTRINGGAP",Config.MainProperties);
                Config.RankingNotReceivedStringX = setNumericValue( "#RANKINGNOTSTRINGX",Config.MainProperties);
                Config.RankingNotReceivedStringY = setNumericValue("#RANKINGNOTSTRINGY",Config.MainProperties);

                Config.PropertiesFrameRankingWidth = setNumericValue("#FRAMERANWIDTH",Config.MainProperties);
                Config.PropertiesFrameRankingHeight = setNumericValue("#FRAMERANHEIGHT",Config.MainProperties);
                Config.PropertiesFrameHelpWidth = setNumericValue("#FRAMEHELPWIDTH",Config.MainProperties);
                Config.PropertiesFrameHelpHeight = setNumericValue("#FRAMEHELPHEIGHT",Config.MainProperties);

                Config.LevelStringX = setNumericValue("#LEVELSTRINGX",Config.MainProperties);
                Config.LevelStringY = setNumericValue("#LEVELSTRINGY",Config.MainProperties);
                Config.NickStringX = setNumericValue("#NICKSTRINGX",Config.MainProperties);
                Config.NickStringY = setNumericValue("#NICKSTRINGY",Config.MainProperties);

                Config.String_Menu_Y1 = setNumericValue("#MENUSTRY1",Config.MainProperties);
                Config.String_Menu_Y2 = setNumericValue("#MENUSTRY2",Config.MainProperties);
                Config.String_Menu_Y3 = setNumericValue("#MENUSTRY3",Config.MainProperties);
                Config.String_Menu_Y4 = setNumericValue("#MENUSTRY4",Config.MainProperties);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }
    /**
     * Reads level config data when application is not connected to server
     */
    public void readLevelDataOffline() {
        try {
            if (GameManager.CurrentLevel == 1) {

                ReadObjectsFromFile(Game.getHandler(), Config.Level1Properties);
            } else if (GameManager.CurrentLevel == 2) {

                ReadObjectsFromFile(Game.getHandler(), Config.Level2Properties);
            }
            else
                ReadObjectsFromFile(Game.getHandler(), Config.Level3Properties);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    /**
     * Reads level config data when application is connected to server
     */
    public void readLevelDataOnline()
    {

        ReadObjectsFromServer(Client.getLevelData(),Game.getHandler());

    }
    /**
     * Method which sets the variable in int type by data loaded from the config file
     * @param data Indicate on particular data we will load from file
     * @param FileName URL of the config file from which data is loaded
     * @return Data with which we will initialize particular variable
     * @throws FileNotFoundException
     */
    public static int setNumericValue(String data,String FileName)  throws FileNotFoundException
    {

        String dataRead = ReadFromFile(data,FileName);

        int value = Integer.parseInt(dataRead);
        return value;

    }

    /**
     * Method which sets the variable in String type by data loaded from the config file
     * @param data Indicate on particular data we will load from file
     * @param FileName URL of the config file from which data is loaded
     * @return Data with which we will initialize particular variable
     * @throws FileNotFoundException
     */
    public static String setStringValue(String data,String FileName)  throws FileNotFoundException
    {

        String dataRead = ReadFromFile(data,FileName);
        return dataRead;
    }

    /**
     * Method for read config data from the file (offline)
     * @param data Indicate on particular data we will load from file
     * @param FileName URL of the config file from which data is loaded
     * @return Data parsed from file in a String type
     * @throws FileNotFoundException
     */
    public static String ReadFromFile(String data,String FileName) throws FileNotFoundException
    {

        Scanner in = new Scanner(new File(FileName));
        String read = null;
        while(true)
        {
            read = in.nextLine();
            if(read.equals(data)) {
                read = in.nextLine();
                break;
            }
            else
                read = in.nextLine();

        }
        return read;
    }

    /**
     * Method for read objects data from file and load them to the handler (offline)
     * @param h Handler of our game objects
     * @param FileName URL of the config file from which data is loaded
     */
    public static void ReadObjectsFromFile(Handler h,String FileName) throws FileNotFoundException
    {

        Scanner in = new Scanner(new File(FileName));
        GameObject temp;
        String x,y;
        String vx, vy;
        String read = null;
        while(in.hasNextLine())
        {
            read = in.nextLine();
            if(read.equals("#ENEMY")) {

                x = in.nextLine();
                y = in.nextLine();
                vx = in.nextLine();
                vy= in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                int velx = Integer.parseInt(vx);
                int vely = Integer.parseInt(vy);
                temp = new Enemy(valuex,valuey,ID.Enemy,velx,vely);
                h.add(temp);

            }
            if(read.equals("#OBSTACLE")) {

                x = in.nextLine();
                y = in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                temp = new Obstacle(valuex,valuey,ID.Obstacle);
                h.add(temp);

            }
            if(read.equals("#PLAYER")) {

                x = in.nextLine();
                y = in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                temp = new Player(valuex,valuey,ID.Player);
                h.add(temp);

            }
            if(read.equals("#COBSTACLE")) {

                x = in.nextLine();
                y = in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                temp = new Obstacle(valuex,valuey,ID.ConstObstacle);
                h.add(temp);

            }
            if(read.equals("#TELEPORT")) {

                x = in.nextLine();
                y = in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                temp = new Teleport(valuex,valuey,ID.Teleport);
                h.add(temp);

            }
            if(read.equals("#BONUSPOINTGOLD")) {

                x = in.nextLine();
                y = in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                temp = new BonusPoint(valuex,valuey,ID.BonusPointGold);
                h.add(temp);

            }
            if(read.equals("#BONUSPOINTSILVER")) {

                x = in.nextLine();
                y = in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                temp = new BonusPoint(valuex,valuey,ID.BonusPointSilver);
                h.add(temp);

            }
            if(read.equals("#BONUSPOINTBROWN")) {

                x = in.nextLine();
                y = in.nextLine();
                int valuex = Integer.parseInt(x);
                int valuey = Integer.parseInt(y)+Config.BarHeight;
                temp = new BonusPoint(valuex,valuey,ID.BonusPointBrown);
                h.add(temp);

            }

        }
    }
    /**
     * Method which is responsible for transfer information of
     * object data in String type (received from server) to GameObject type and
     * put them in the Handler
     * @param s Linked list received from server which stores information about game objects in String
     * @param handler Stores all objects in the game
     */
    public static void ReadObjectsFromServer(LinkedList<String> s, Handler handler)
    {
        GameObject temp;
        for(int i=0;i<s.size();i++)
        {
            if(s.get(i).equals("#ENEMY"))
            {

                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                int vx =  Integer.parseInt(s.get(i+3));
                int vy =  Integer.parseInt(s.get(i+4));
                temp = new Enemy(x,y,ID.Enemy,vx,vy);
                handler.add(temp);

            }
            else if(s.get(i).equals("#OBSTACLE"))
            {
                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                temp = new Obstacle(x,y,ID.Obstacle);
                handler.add(temp);

            }
            else if(s.get(i).equals("#COBSTACLE"))
            {
                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                temp = new Obstacle(x,y,ID.ConstObstacle);
                handler.add(temp);

            }
            else if(s.get(i).equals("#TELEPORT"))
            {
                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                temp = new Teleport(x,y,ID.Teleport);
                handler.add(temp);


            }
            else if(s.get(i).equals("#PLAYER"))
            {

                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                temp = new Player(x,y,ID.Player);
                handler.add(temp);

            }
            else if(s.get(i).equals("#BONUSPOINTGOLD"))
            {

                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                temp = new BonusPoint(x,y,ID.BonusPointGold);
                handler.add(temp);

            }
            else if(s.get(i).equals("#BONUSPOINTSILVER"))
            {

                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                temp = new BonusPoint(x,y,ID.BonusPointSilver);
                handler.add(temp);

            }
            else if(s.get(i).equals("#BONUSPOINTBROWN"))
            {

                int x = Integer.parseInt(s.get(i+1));
                int y = Integer.parseInt(s.get(i+2))+Config.BarHeight;
                temp = new BonusPoint(x,y,ID.BonusPointBrown);
                handler.add(temp);

            }


        }


    }

    /**
     * Reads particular data from linked list of Strings received from server
     * @param s Linked list of String data
     * @param data String data which was supposed to read
     * @return Read String data
     */
    public static String read_Data_Server(LinkedList<String> s, String data)
    {
        String read = null;
        for(int i=0;i<s.size()-1;i++)
        {
            String temp = s.get(i);
            if(temp.equals(data)) {
                read = s.get(i+1);
                break;
            }

        }
        return read;

    }

    /**
     * Reads particular data from the linked list of Strings received from server and parse it into Integer value
     * @param s Linked list of String data
     * @param data String data which is supposed to be parsed into Integer
     * @return Integer value that was parsed from String data which is later assigned to a proper variable
     */
    public static int setIntValue_fromServer(LinkedList<String> s, String data)
    {
        String d = null;

        d = read_Data_Server(s,data);
        int result = Integer.parseInt(d);
        return result;

    }

    /**
     * Reads particular data from the linked list of Strings received from server and assign it to another String type variable
     * @param s Linked list of String data
     * @param data String data which was supposed to read
     * @return Read String data which is later assigned to a proper variable
     */
    public static String setStringValue_fromServer(LinkedList<String> s, String data)
    {
        String d = null;
        d = read_Data_Server(s,data);
        return d;

    }

}
