package mweinberger.controller;

import java.io.IOException;
import java.net.*;

import mweinberger.model.Config;

/**
 *
 * Die Serverimplementierung fuer den MaturaChat
 *
 * Created by mweinberger on 12.05.16.
 */
public class Server {

    private ServerSocket serverSocket;

    public Server() {

        try {
            serverSocket = new ServerSocket(Config.portnummer);
            serverSocket.setSoTimeout(10000);
            System.out.println("Warte auf Anfrage auf Port " +
                    serverSocket.getLocalPort() + "...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {

            try {

                Socket server = serverSocket.accept();

                Thread t = new Thread(new ServerThread(server));
                t.start();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Server s = new Server();

    }

}
