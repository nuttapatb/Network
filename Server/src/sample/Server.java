package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{

    ArrayList<PrintWriter> writers;
    Controller controller;
    ServerSocket serverSocket;

    public Server(ArrayList<PrintWriter> writers,Controller controller){
        this.writers = writers;
        this.controller = controller;
    }

    @Override
    public void run(){
        System.out.println("Connect");
        try{
            serverSocket = new ServerSocket(11111);

            while (true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writers.add(writer);

                Thread c = new Thread(new clientHandle(reader,controller));
                c.start();


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
