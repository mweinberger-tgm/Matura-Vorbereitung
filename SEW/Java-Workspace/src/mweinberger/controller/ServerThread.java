package mweinberger.controller;

import java.io.*;
import java.net.*;

/**
 *
 *
 *
 * Created by mweinberger on 13.05.16.
 */
public class ServerThread implements Runnable {

    private Socket server;

    public ServerThread(Socket in) {
        this.server = in;
    }

    @Override
    public void run() {

        try {
            System.out.println("Verbunden mit " + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Hallo");
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
