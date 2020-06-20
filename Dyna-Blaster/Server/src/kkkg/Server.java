package kkkg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Server main class in which the main server thread is being run
 */
public class Server implements Runnable {


    private ServerSocket serversocket;
    private Socket socket;
    private Thread thread;

    /**
     * Stores information whether server application is running or not
     */
    private boolean running = false;
    /**
     * Stores game configuration data which is sent through socket
     */
    public static LinkedList<String> ConfigGameData = new LinkedList<String>();
    /**
     * Stores level data which is sent through socket
     */
    public static LinkedList<String> LevelData = new LinkedList<String>();
    /**
     * Stores ranking data which is sent through socket
     */
    public static LinkedList<kkkg.User> RankingTable = new LinkedList<kkkg.User>();

    private static DataReader dataReader;
    /**
     * Stores User parsed from received data from Client
     */
    public static kkkg.User UserReceived;
    /**
     * Using to distinguish the clients
     */
    private int ID = 1;

    public Server() throws IOException {


        dataReader = new DataReader();
        dataReader.ReadServerConfigData(Config.configURL);
        UserReceived = new User();
        dataReader.ReadGameConfigData(ConfigGameData, Config.game_configURL);
        dataReader.ReadRankingData(RankingTable, Config.HighScoresFileUrl);
        serversocket = new ServerSocket(Config.Port);
        System.out.println("Welcome to Dyna Blaster Server!\n");
        start();

    }
    public void start()
    {
        running = true;
        thread = new Thread(this);
        thread.start();

    }
    public void run()
    {
        while(running)
        {
            try {
                System.out.println("Listen for connection...\n");
                socket = serversocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ServerThread st = new ServerThread(socket,ID,dataReader);
            st.start();
            ID++;
        }


    }


    public static void main (String [] args) throws IOException {
        new Server();

    }
}
