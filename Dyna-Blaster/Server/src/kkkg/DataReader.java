package kkkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Reads server configuration data, high scores data, game data from files
 */
public class DataReader {



    public DataReader()
    {


    }

    /**
     * Reads server config data from file
     * @param Filename File from which data is read
     * @throws FileNotFoundException
     */
    public void ReadServerConfigData(String Filename) throws FileNotFoundException {


        Config.Port = setNumericValue("#PORT", Filename);
        Config.Host = setStringValue("#HOST", Filename);

    }

    /**
     * Reads game config data from file
     * @param s LinkedList that stores String type in which game data is put
     * @param Filename  File from which data is read
     * @throws FileNotFoundException
     */
    public void ReadGameConfigData(LinkedList<String> s, String Filename) throws FileNotFoundException{

        Scanner in = new Scanner(new File(Filename));
        String str;
        while(in.hasNextLine())
        {
            str = in.nextLine();
            s.add(str);

        }


    }

    /**
     * Reads ranking data (highscores) from file
     * @param users Linked List that stores User objects with best scores and in which data read from file is parsed
     * @param Filename File from which data is read
     * @throws FileNotFoundException
     */
    public void ReadRankingData(LinkedList<kkkg.User> users, String Filename) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(Filename));
        String str;
        kkkg.User tempUser = null;
        String data[] = null;

        while(in.hasNextLine())
        {
            str = in.nextLine();
            data = str.split(";");
            tempUser = new User(data[0],Integer.parseInt(data[1]));
            users.add(tempUser);

        }

        in.close();



    }

    /**
     * Clears file
     * @param Filename File which is supposed to be cleared
     * @throws FileNotFoundException
     */
    public void ClearFile(String Filename) throws FileNotFoundException
    {
        PrintWriter printer = new PrintWriter(Filename);
        printer.print("");
        printer.close();

    }
    public void SortRankingTable(LinkedList<kkkg.User> users, kkkg.User user) { //trzeba to jeszcze uzupelnic o przypadek gdy jest duzo takich
        if (users.size() == 0)                                                  //samych wyników
            users.add(user);
        else if(isRankingScore(users,user)) {
            for (int i = 0; i < users.size(); ++i) {
                if (user.getScore() > users.get(i).getScore()) {
                    users.add(i, user);
                    break;


                } else if (i == users.size() - 1) {
                    users.add(user);
                    break;

                }
            }
            if(users.size()>10)
                users.remove(10);
        }

    }

    /**
     * Checks whether received user's score is big enough to be qualified to ranking
     * @param users Linked List that stores User objects with best scores
     * @param user User received from client
     * @return
     */
    public boolean isRankingScore(LinkedList<kkkg.User> users, kkkg.User user)
    {
        if(user.getScore()<=users.get(users.size()-1).getScore() && users.size()>9)
            return false;
        else
            return true;
    }

    /**
     * Write received user's score and nick to file
     * @param users Linked List that stores User objects with best scores
     * @param user User received from client
     * @param Filename File to which data is written
     * @throws FileNotFoundException
     */
    public void WriteScoreToFile(LinkedList<kkkg.User> users, kkkg.User user, String Filename) throws FileNotFoundException
    {

        User tempUser = new User(user.getNick(),user.getScore());
        SortRankingTable(users,tempUser);
        if(isRankingScore(users,tempUser)) {
            ClearFile(Filename); // Clearing the file
            //Writing ranking list in the file
            PrintWriter printer = new PrintWriter(Filename);
            for (int i = 0; i < users.size(); i++) {
                printer.print(users.get(i).getNick() + ";" + Integer.toString(users.get(i).getScore()));
                printer.print("\n");

            }
            printer.close();
        }
    }

    /**
     * Reads level data from file
     * @param levelNumber Number of level which data is supposed to be read
     * @param s LinkedList that stores Strings in which read data is put
     */
    public void ReadLevelData(int levelNumber,LinkedList<String> s)
    {
        String Filename;
        s.clear();
        if(levelNumber == 1)
            Filename = Config.level1ConfigUrl;
         else if(levelNumber == 2)
             Filename = Config.level2ConfigUrl;
         else
            Filename = Config.level3ConfigUrl;
        try {
            ReadGameConfigData(s, Filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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
     * Method for read config data from the file
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


}
