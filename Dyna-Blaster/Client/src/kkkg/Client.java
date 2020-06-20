package kkkg;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;

/**
 * Client class, operates sending and receiving data to/from server
 */
public class Client {


    private Socket socket;
    private PrintWriter printwriter;
    private InputStreamReader in;
    private BufferedReader bf;

    /**Responsible for receiving data*/
    private ClientReceiver receiver;
    /**Responsible for sending data*/
    private ClientSender sender;

    /**Stores configuration data*/
    private static LinkedList<String> Config_data = new LinkedList<String>();
    /**Stores level data*/
    private static LinkedList<String> Level_data = new LinkedList<String>();
    /**Stores 10 best scores*/
    private static LinkedList<String> Ranking_data = new LinkedList<String>();

    /**Stores information whether client is connected to server or not*/
    public static boolean Connected = false;

    /**Stores information whether config data was received or not*/
    public static boolean isConfigDataReceived = false;
    /**Stores information whether request for ranking table was sent or not*/
    public static boolean isRankingRequestSent = false;
    /**Stores information whether ranking table was received or not*/
    public static boolean isRankingReceived = false;
    /**Stores information whether score was sent to server or not*/
    public static boolean isScoreSent = false;
    /**Stores information whether level is set (loaded from server) or not*/
    public static boolean isLevelSet = false;



    public Client()
    {
        receiver = new ClientReceiver();
        sender = new ClientSender();

        MakeConnection();
        // receiving config data
        try {
            if(Connected) {
                if (!isConfigDataReceived) {
                    sender.SendConfigDataRequest(printwriter);
                    receiver.ReceiveConfigData(bf, Config_data);

                }
            }


        }
        catch(SocketException ex)
        {
            Connected = false;
            System.out.println("Couldn't read data, offline mode");
        }
        catch (IOException e) {
            System.out.println("Error, I couldn't receive data!");
            Connected = false;
            e.printStackTrace();
        }


    }
    public static LinkedList<String> getConfigData()
    {
        return Config_data;
    }
    public static LinkedList<String> getLevelData()
    {
        return Level_data;
    }
    public static LinkedList<String> getRankingData()
    {
        return Ranking_data;
    }

    /**
     * Connects with the server
     */
    public void MakeConnection()
    {
        try {

            socket = new Socket(Config.Host,Config.Port);
            printwriter = new PrintWriter(socket.getOutputStream());
            in = new InputStreamReader(socket.getInputStream());
            bf = new BufferedReader(in);
            Connected = true;

        }
        catch(ConnectException e)
        {
            Connected = false;
            System.out.println("Couldn't connect to server, offline mode");
        }
        catch (IOException e) {
            Connected = false;
            System.out.println("Couldn't connect to server, offline mode");
            e.printStackTrace();
        }



    }

    /**
     * Tick method which takes actions (sending or receiving data) depends on actual game state
     */
    public void tick()
    {

         if (GameManager.State == GameState.Ranking) {

            if(!isRankingRequestSent) {
                sender.SendRankingTableRequest(printwriter);
            }
            if(!isRankingReceived) {

                try {
                    receiver.ReceiveRankingTable(bf,Ranking_data);
                }
                catch(SocketException ex)
                {
                    System.out.println("Couldn't read data");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
        else if(GameManager.State == GameState.GameCompleted) {
            if (!isScoreSent) {
                sender.SendScoreToServerInformation(printwriter);
                sender.SendScoreToServer(printwriter);
                receiver.ReceiveScoreReceivedACK(bf);
            }
        }
        else if(GameManager.State == GameState.SetLevel)
        {
            if(!isLevelSet) {
                sender.SendLevelDataRequest(GameManager.CurrentLevel,printwriter);
                try {
                    receiver.ReceiveLevelData(bf,Level_data);

                }
                catch(SocketException ex)
                {
                    Connected = false;
                    System.out.println("Couldn't read data, offline mode");
                }
                catch (IOException e) {
                    System.out.println("Couldn't read data, offline mode");
                    Connected = false;
                    e.printStackTrace();
                }


            }

        }

        else {

            isRankingReceived = false;
            isScoreSent = false;
            isRankingRequestSent = false;
            isLevelSet = false;
        }




    }



}
