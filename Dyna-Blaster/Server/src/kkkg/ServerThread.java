package kkkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * Describes thread for each client, sends data to the client and receives data from it
 */
public class ServerThread implements Runnable {

    private boolean running = false;
    private Thread serverthread;
    private Socket socket;
    private int threadID;
    /**
     * InputStreamReader which read data from input stream
     */
    private InputStreamReader in;
    /**
     * BufferedReader which receives data from client
     */
    private BufferedReader bf;
    /**
     * PrintWriter through which data is sent to client
     */
    private PrintWriter printwriter;
    private ServerSender sender;
    private ServerReceiver receiver;
    private DataReader datareader;

    public ServerThread(Socket s, int ID, DataReader datareader) {
        sender = new ServerSender();
        receiver = new ServerReceiver();
        this.threadID = ID;
        this.socket = s;
        this.datareader = datareader;

    }

    /**
     * Connects with the client
     */
    public void Connect()
    {

        try {
            in = new InputStreamReader(socket.getInputStream());
            bf = new BufferedReader(in);
            printwriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Connected to Client " + threadID);

    }

    public void start() {

            Connect();
            serverthread = new Thread(this);
            serverthread.start();
            running = true;

    }

    public void run() {

        while (running) {
            String s = null;
            try {
                s = bf.readLine();
                System.out.println("Client " + threadID + ": " + s); // Prints what server receives from client
                if (s != null) {
                    if (s.equals(Protocol.GET_CONFIG_DATA)) {
                        sender.SendConfigData(Server.ConfigGameData, printwriter);
                    } else if (s.equals(Protocol.GET_RANKING)) {
                        sender.SendRankingTable(Server.RankingTable, printwriter);
                        sender.SendRankingTableSentACK(printwriter);
                    } else if (s.equals(Protocol.SEND_SCORE)) {
                        receiver.ReceiveScoreFromClient(bf, Server.UserReceived, threadID);
                        if (Server.UserReceived != null) {
                            sender.SendScoreReceivedACK(printwriter);
                            datareader.WriteScoreToFile(Server.RankingTable, Server.UserReceived, Config.HighScoresFileUrl);
                        }
                    } else if (s.equals(Protocol.GET_LEVEL1_DATA)) {
                        sender.SendLevelData(1, datareader, printwriter, Server.LevelData);
                    } else if (s.equals(Protocol.GET_LEVEL2_DATA)) {
                        sender.SendLevelData(2, datareader, printwriter, Server.LevelData);
                    }
                    else if(s.equals(Protocol.GET_LEVEL3_DATA))
                    {
                        sender.SendLevelData(3, datareader, printwriter, Server.LevelData);

                    }
                }


            } catch (SocketException ex) {

                System.out.println("Lost connection with Client " + threadID);
                System.out.println("Listen for connection...");
                stop();


            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }
    public void stop()
    {
         running = false;
    }
}
