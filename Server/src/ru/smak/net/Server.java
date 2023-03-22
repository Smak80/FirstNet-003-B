package ru.smak.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int _port;
    public Server(int port){
        _port = port;
    }

    public void start(){
        try {
            ServerSocket ss = new ServerSocket(_port);
            Socket s = ss.accept();
            var br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String clientData = br.readLine();
            System.out.println("Клиент прислал: "+clientData);
            var pw = new PrintWriter(s.getOutputStream());
            pw.println("Привет в ответ!");
            pw.flush();
            s.close();
        } catch (IOException e) {
        }
    }
}
