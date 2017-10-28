package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.PrintWriter;
import java.util.ArrayList;

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

    }

    public void sendMessageToClient(String statusCode,String statusPhrase,String message,int i,String set){
        PrintWriter p = writers.get(i);
        p.println(statusCode+"-"+statusPhrase+"-"+message+"-"+(i+"")+"-"+set);
        p.flush();
    }

}

class Check {
    
}
