package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameController {
    Socket serversocket;
    String address = "localhost";
    PrintWriter writer;
    BufferedReader reader;
    int idPLayer;

    public GameController(){
        connect();
    }

    public void connect(){

        System.out.println("Connect to Server");
        try{
            serversocket = new Socket(address,11111);
            writer = new PrintWriter(serversocket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));

            sentMessageToSever("700","Greeting","HelloServer",idPLayer+"");

            Thread s = new Thread(new serverHandle(reader,this));
            s.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setIdPLayer(int i){
        idPLayer = i;
        System.out.println(idPLayer);
    }

    public void sentMessageToSever(String statusCode,String statusPhrase,String message,String ID){
        writer.println(statusCode+"-"+statusPhrase+"-"+message+"-"+ID);
        writer.flush();
    }

    @FXML
    public Button b00,b01,b02,b03,b04,b05,b06,b07,b08;
    @FXML
    public Button b10,b11,b12,b13,b14,b15,b16,b17,b18;
    @FXML
    public Button b20,b21,b22,b23,b24,b25,b26,b27,b28;
    @FXML
    public Button b30,b31,b32,b33,b34,b35,b36,b37,b38;
    @FXML
    public Button b40,b41,b42,b43,b44,b45,b46,b47,b48;
    @FXML
    public Button b50,b51,b52,b53,b54,b55,b56,b57,b58;
    @FXML
    public TextArea chatarea;
    @FXML
    public TextField chatfield;
    @FXML
    Label Hit1,Hit2,playerTurn;


    String bomb;
    Button[] buttons;
    int countRound;
    boolean turn = true;
    int inUseplayer = 1;
    /*
    @FXML
    public void initialize(){
        Hit1.setText("P1: 0");
        Hit2.setText("P2: 0");
        Button[] button = {b00,b01,b02,b03,b04,b05,b06,b07,b08,b10,b11,b12,b13,b14,b15,b16,b17,b18,b20,b21,b22,b23,b24,b25,b26,b27,b28
                ,b30,b31,b32,b33,b34,b35,b36,b37,b38,b40,b41,b42,b43,b44,b45,b46,b47,b48,b50,b51,b52,b53,b54,b55,b56,b57,b58};
        buttons = button;
        showPlayerturn(inUseplayer);
    }
    */

    @FXML
    public void PressButton(ActionEvent event){
        Button b = (Button) event.getSource();
        for (int i = 0; i < buttons.length; i++) {
            if(b.equals(buttons[i])){
                if(bomb.charAt(i) == '0'){
                    countRound++;
                    sentMessageToSever("720","Hit",countRound+"",idPLayer+"");
                }
                sentMessageToSever("712","Set Button",i+"",idPLayer+"");

//                sentMessageToSever("714","Player Turn",inUseplayer+"",idPLayer+"");
            }
        }
    }

    /*
    public void setbuttons(int set){ // set button to other
        String word = Character.toString(bomb.charAt(set));
        if(word.equals("0")) {
            buttons[set].setStyle("-fx-text-fill: red");
            buttons[set].setText(bomb.charAt(set) + "");
            buttons[set] = null;
        }else{
            buttons[set].setStyle("-fx-text-fill: black");
            buttons[set].setText(bomb.charAt(set) + "");
            buttons[set] = null;
        }
    }
    */

    public void setInUseplayer(int inUseplayer) {
        this.inUseplayer = inUseplayer;
    }

    public void showPlayerturn(int status){
        if(status == 1){
            playerTurn.setText("Player 1's turn");
        }
        if(status == 2){
            playerTurn.setText("Player 2's turn");
        }
    }

    public void setHitlabel(String hit,String player){ // set player hit
        if(player.equals("1")) {
            Hit1.setText("P1: "+hit);
        }
        if(player.equals("2")) {
            Hit2.setText("P2: "+hit);
        }
    }


    public void handleButtonSend(){ // ChatField
        if(!chatfield.getText().equals("")) {
            sentMessageToSever("718","Chat",chatfield.getText()+"",idPLayer+"");
            chatfield.clear();
        }
    }

    public void Chat(String message,String player){ // chat
        chatarea.appendText("Player"+player+":" + " "+message + "\n");
    }




}
