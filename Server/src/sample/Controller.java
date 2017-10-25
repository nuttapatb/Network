package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Controller {


    ArrayList<PrintWriter> writers;
    public int[] number = new int[54];
    int count = 0;
    String use = "";
    @FXML
    Label serverstatus;
    @FXML
    public void initialize(){
        serverstatus.setText("Server Ready to Connect");
    }

    public Controller(){
        writers = new ArrayList<>();
        Thread s = new Thread(new Server(writers,this));
        s.start();
        RandomNumber();
    }

    public void sendMessageToClient(String statusCode,String statusPhrase,String message,int i,String set){
        PrintWriter p = writers.get(i);
        p.println(statusCode+"-"+statusPhrase+"-"+message+"-"+(i+"")+"-"+set);
        p.flush();
    }
    public void RandomNumber(){
        Random rn = new Random();
        for(int i = 0;i < 53;i++) {
            int smith = rn.nextInt(10);
            if (smith % 5 == 0 && count < 10) {
                count++;
                number[i] = 0;
            } else {
                number[i] = smith;
            }
        }
        while (count < 10){
            int smith = rn.nextInt(53);
            if (number[smith] != 0) {
                number[smith] = 0 ;
                count++;
            }
        }
        for (int i:number) {
            use += i;
        }
    }
}
