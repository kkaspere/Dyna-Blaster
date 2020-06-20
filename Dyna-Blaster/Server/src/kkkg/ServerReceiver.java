package kkkg;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Defines method of receiving data (more preceisly score) from client
 */
public class ServerReceiver {

    /**
     * Receives Score data from client (User's score and nick)
     * @param bf BufferedReader which is responsible for receiving data
     * @param userReceived User object in which read data is parsed
     * @param ClientID Variable to identify the client
     */
    public void ReceiveScoreFromClient(BufferedReader bf, User userReceived, int ClientID)  {


        String line_read = null;


        for(int i=0; i<2;i++)
        {
            try {
                line_read = bf.readLine();
                System.out.println("Client " + ClientID + ": " + line_read);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(i==0)
                userReceived.setNick(line_read);
            else
                userReceived.setScore(Integer.parseInt(line_read));
        }


    }
}
