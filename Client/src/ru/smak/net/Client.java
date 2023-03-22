package ru.smak.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String _host;
    private int _port;
    public Client(String host, int port){
        _host = host;
        _port = port;
    }

    public void start(){
        try {
            Socket s = new Socket(_host, _port);
            var pw = new PrintWriter(s.getOutputStream());
            pw.println("Привет!");
            pw.flush();
            var br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            var reply = br.readLine();
            System.out.println(reply);
            s.close();
        } catch (IOException e) {
        }
    }
}
