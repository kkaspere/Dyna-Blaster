package kkkg;

import java.io.PrintWriter;
/**
 * Contains definitions of sending data to server methods
 */
public class ClientSender {

    /**
     * Sends request to server for level data
     * @param LevelNumber Number of level that data is supposed to be sent to client
     * @param printwriter PrintWriter connected with socket's output stream
     */
    public void SendLevelDataRequest(int LevelNumber, PrintWriter printwriter)
    {

        try {

            printwriter.println(Protocol.GET_LEVEL_DATA + LevelNumber);
            printwriter.flush();



        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }


    }

    /**
     * Sends request to server for game configuration data
     * @param printwriter PrintWriter connected with socket's output stream
     */
     public void SendConfigDataRequest(PrintWriter printwriter)
    {

        printwriter.println(Protocol.GET_CONFIG_DATA);
        printwriter.flush();


    }

    /**
     * Sends request to server for ranking table
     * @param printwriter PrintWriter connected with socket's output stream
     */
    public void SendRankingTableRequest(PrintWriter printwriter)
    {
        try {

            printwriter.println(Protocol.GET_RANKING);
            printwriter.flush();
            Client.isRankingRequestSent = true;


        }
        catch(NullPointerException e)
        {
            System.out.println("Tryb offline, nie udało się pobrać rankingu");
        }


    }

    /**
     * Sends information to server of sending score to it
     * @param printwriter PrintWriter connected with socket's output stream
     */
    public void SendScoreToServerInformation(PrintWriter printwriter)
    {

        try {

            printwriter.println(Protocol.SEND_SCORE);
            printwriter.flush();


        }
        catch(NullPointerException e)
        {
            e.printStackTrace();

        }

    }

    /**
     * Sends score to server
     * @param printwriter PrintWriter connected with socket's output stream
     */
    public void SendScoreToServer(PrintWriter printwriter)
    {


            printwriter.println(Game.getUser().getNick());
            printwriter.println(Game.getUser().getScore());
            printwriter.flush();



    }
}
