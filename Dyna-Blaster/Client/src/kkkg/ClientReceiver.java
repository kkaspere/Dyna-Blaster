package kkkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Contains definitions of receiving data from server methods
 */
public class ClientReceiver {

    /**
     * Receives config data sent by server
     * @param bf BufferedReader connected with socket's input stream
     * @param data Container which stores received data in String type
     * @throws IOException
     */
    public void ReceiveConfigData(BufferedReader bf, LinkedList<String> data) throws IOException
    {


        String line_read;
        while(true) {
            line_read = bf.readLine();
            if (!line_read.equals(Protocol.SENT_CONFIG_DATA)) {
                data.add(line_read);

            }
            else {
                Client.isConfigDataReceived = true;
                GameManager.State = GameState.Menu;
                break;

            }
        }


    }

    /**
     * Receives level data sent by server
     * @param bf BufferedReader connected with socket's input stream
     * @param data Container which stores received data in String type
     * @throws IOException
     */
    public void ReceiveLevelData(BufferedReader bf,LinkedList<String> data) throws IOException
    {
        data.clear();
        String line_read;
        while(true) {
            line_read = bf.readLine();
            if (!line_read.equals(Protocol.SENT_LEVEL_DATA)) {
                data.add(line_read);

            }
            else {
                Client.isLevelSet = true;
                break;

            }
        }





    }

    /**
     * Receives Ranking Table sent by server
     * @param bf BufferedReader connected with socket's input stream
     * @param data Container which stores received data in String type
     * @throws IOException
     */
    public void ReceiveRankingTable(BufferedReader bf,LinkedList<String> data) throws IOException
    {

        data.clear();
        String line_read;
        while(true) {
            line_read = bf.readLine();
            if (!line_read.equals(Protocol.SENT_LEVEL_DATA)) {
                data.add(line_read);

            }
            if(line_read.equals(Protocol.RANKING_SENT)) {
                Client.isRankingReceived = true;
                break;
            }
        }

    }

    /**
     * Receives ACK from server with information that score was received by server successfully
     * @param bf BufferedReader connected with socket's input stream
     */
    public void ReceiveScoreReceivedACK(BufferedReader bf)
    {
        String line_read = null;
        try {
            line_read = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(line_read.equals(Protocol.SCORE_RECEIVED)) {

            Client.isScoreSent = true;
        }

    }


}
