package mweinberger.controller;

import java.io.IOException;
import java.net.*;
import java.io.*;

import mweinberger.model.Config;

/**
 *
 * Ein Client fuer den MaturaChat
 *
 * Created by mweinberger on 12.05.16.
 */
public class Client {

    public static void main(String[] args) {

            try {

                Socket client = new Socket(Config.serveradr, Config.portnummer);
                System.out.println("Erfolgreich verbunden mit " + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                InputStream inFromServer = client.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);
                System.out.println(in.readUTF());
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
