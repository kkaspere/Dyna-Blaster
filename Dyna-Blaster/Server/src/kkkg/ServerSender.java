package kkkg;

import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Defines methods of sending data to client
 */
public class ServerSender {

    /**
     * Sends particular level data to client
     * @param LevelNumber Number of level which data is supposed to be read
     * @param dataReader Responsible for reading particular level data from file
     * @param printwriter Responsible for sending level data to the client
     * @param Level_Data LinkedList that stores String data in which level data read from file is put
     */
    public void SendLevelData(int LevelNumber, DataReader dataReader, PrintWriter printwriter, LinkedList<String> Level_Data)
    {
        dataReader.ReadLevelData(LevelNumber, Level_Data);
        for (int i = 0; i < Level_Data.size(); i++) {
            printwriter.println(Level_Data.get(i));

        }

        printwriter.println(Protocol.SENT_LEVEL_DATA);
        System.out.println("Server: " + Protocol.SENT_LEVEL_DATA);
        printwriter.flush();
        System.out.println("Listen for connection...\n");


    }

    /**
     * Sends game config data to client
     * @param Config_Game_Data LinkedList that stores String data in which game config data read from file is put
     * @param printwriter Responsible for sending game config data to the client
     */
    public void SendConfigData(LinkedList<String> Config_Game_Data,PrintWriter printwriter){

        for (int i = 0; i < Config_Game_Data.size(); i++) {
            printwriter.println(Config_Game_Data.get(i));
        }

        printwriter.println(Protocol.SENT_CONFIG_DATA);
        System.out.println("Server: " + Protocol.SENT_CONFIG_DATA);
        printwriter.flush();
        System.out.println("Listen for connection...\n");



    }

    /**
     * Sends 10 best users data with best scores
     * @param users Linkedlist that stores users with best scores which data is sending to the client
     * @param printwriter Responsible for sending ranking data to the client
     */
    public void SendRankingTable(LinkedList<User> users, PrintWriter printwriter) {

       for(int i=0 ;i <users.size();i++)
       {
           printwriter.println(users.get(i).getNick());
           printwriter.println(users.get(i).getScore());

       }

       printwriter.flush();


    }

    /**
     * Sends confirmation (ACK) to client that score was received successfully by server
     * @param printwriter Responsible for sending ACK to client
     */
    public void SendScoreReceivedACK(PrintWriter printwriter){

        printwriter.println(Protocol.SCORE_RECEIVED);
        System.out.println("Server: " + Protocol.SCORE_RECEIVED);
        printwriter.flush();
        System.out.println("Listen for connection...\n");


    }

    /**
     * Sends confirmation (ACK) that score ranking table was successfully sended to the client
     * @param printwriter Responsible for sending ACK to client
     */
    public void SendRankingTableSentACK(PrintWriter printwriter)
    {

        printwriter.println(Protocol.RANKING_SENT);
        System.out.println("Server: " + Protocol.RANKING_SENT);
        printwriter.flush();
        System.out.println("Listen for connection...\n");

    }




}
