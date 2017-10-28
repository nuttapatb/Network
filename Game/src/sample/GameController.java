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
    String playerO = "O";
    String playerX = "X";

    public GameController(){
        connect();
    }

    public void connect(){

        System.out.println("Connect to Server");
        try{
            serversocket = new Socket(address,11111);
            writer = new PrintWriter(serversocket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));

            sentMessageToSever("900","Greeting","HelloServer",idPLayer+"",null);

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

    public void sentMessageToSever(String statusCode,String statusPhrase,String message,String ID,String Index){
        writer.println(statusCode+"-"+statusPhrase+"-"+message+"-"+ID+"-"+Index);
        writer.flush();
    }

    @FXML
    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9, send;
    @FXML
    public TextField message;
    @FXML
    public TextArea chat;
    @FXML
    public Label text1, text2;

    private boolean playerTurn = true;
    private boolean player1 = false;
    private boolean player2 = false;
    private int count = 9;
    private boolean playing = true;

    private boolean inUseplayer = false;

    @FXML
    public void ActionBtn1(ActionEvent event){
        if (button1.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button1.setText("X");
                sentMessageToSever("800","Player",playerX+"-","1","1");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;

            } else {
                sentMessageToSever("800","Player",playerO+"-","2","1");
                button1.setText("O");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;
            }
        }
//        count--;
        this.check();

    }
    @FXML
    public void ActionBtn2(ActionEvent event){
        if (button2.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button2.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"-","1","2");

            } else {
                button2.setText("O");
                sentMessageToSever("800","Player",playerO+"-","2","2");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;

            }
        }
//        count--;
        this.check();

    }

    @FXML
    public void ActionBtn3(ActionEvent event){
        if (button3.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button3.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"-","1","3");

            } else {
                button3.setText("O");
                sentMessageToSever("800","Player",playerO+"-","2","3");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;

            }
        }
//        count--;
        this.check();

    }
    @FXML
    public void ActionBtn4(ActionEvent event){
        if (button4.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button4.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"-","1","4");
            } else {
                button4.setText("O");
                sentMessageToSever("800","Player",playerO+"-","2","4");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;
            }
        }
//        count--;
        this.check();

    }

    @FXML
    public void ActionBtn5(ActionEvent event){
        if (button5.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button5.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"-","1","5");
            } else {
                button5.setText("O");
                sentMessageToSever("800","Player",playerO+"-","2","5");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;
            }
        }
//        count--;
        this.check();
    }

    @FXML
    public void ActionBtn6(ActionEvent event){
        if (button6.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button6.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"-","1","6");
            } else {
                button6.setText("O");
                sentMessageToSever("800","Player",playerO+"-","2","6");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;
            }
        }
//        count--;
        this.check();
    }

    @FXML
    public void ActionBtn7(ActionEvent event){
        if (button7.getText().equals("") && count > 0 && playing){

            if (playerTurn == true){
                button7.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"-","1","7");
            } else {
                button7.setText("O");
                sentMessageToSever("800","Player",playerO+"-","2","7");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;
            }
        }
//        count--;
        this.check();
    }

    @FXML
    public void ActionBtn8(ActionEvent event){
        if (button8.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button8.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"-","1","8");
            } else {
                button8.setText("O");
                sentMessageToSever("800","Player",playerO+"-","2","8");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;
            }
        }
//        count--;
        this.check();
    }

    @FXML
    public void ActionBtn9(ActionEvent event) {
        if (button9.getText().equals("") && count > 0 && playing){
            if (playerTurn == true){
                button9.setText("X");
                playerTurn = false;
                showPlayerturn(true);
                inUseplayer = false;
                sentMessageToSever("800","Player",playerX+"","1","9");
            } else {
                button9.setText("O");
                sentMessageToSever("800","Player",playerO+"","2","9");
                playerTurn = true;
                showPlayerturn(false);
                inUseplayer = true;
            }
        }
//        count--;
        this.check();
    }
    public void setButton(String name,int button){

    }

    @FXML
    public void check(){
        if (count == 0 || playing == false){
            text1.setText("End Game !");
            text2.setText("Equal Score");
        }
        if (button1.getText().equals("X")){
            if (button2.getText().equals("X")){
                if (button3.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button4.getText().equals("X")){
            if (button5.getText().equals("X")){
                if (button6.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button7.getText().equals("X")){
            if (button8.getText().equals("X")){
                if (button9.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button1.getText().equals("X")){
            if (button4.getText().equals("X")){
                if (button7.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button2.getText().equals("X")){
            if (button5.getText().equals("X")){
                if (button8.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button3.getText().equals("X")){
            if (button6.getText().equals("X")){
                if (button9.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button1.getText().equals("X")){
            if (button5.getText().equals("X")){
                if (button9.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button3.getText().equals("X")){
            if (button5.getText().equals("X")){
                if (button7.getText().equals("X")){
                    player1 = true;
                    player2 = false;
                    playing = false;
                    text2.setText("Player 1 Win!");
                    text1.setText("End Game !");
                }
            }
        }


        if (button1.getText().equals("O")){
            if (button2.getText().equals("O")){
                if (button3.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button4.getText().equals("O")){
            if (button5.getText().equals("O")){
                if (button6.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button7.getText().equals("O")){
            if (button8.getText().equals("O")){
                if (button9.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button1.getText().equals("O")){
            if (button4.getText().equals("O")){
                if (button7.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button2.getText().equals("O")){
            if (button5.getText().equals("O")){
                if (button8.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button3.getText().equals("O")){
            if (button6.getText().equals("O")){
                if (button9.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button1.getText().equals("O")){
            if (button5.getText().equals("O")){
                if (button9.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

        if (button3.getText().equals("O")){
            if (button5.getText().equals("O")){
                if (button7.getText().equals("O")){
                    player1 = false;
                    player2 = true;
                    playing = false;
                    text2.setText("Player 2 Win!");
                    text1.setText("End Game !");
                }
            }
        }

    }

    public boolean isPlayer1() {
        return player1;
    }

    public void setPlayer1(boolean player1) {
        this.player1 = player1;
    }

    public boolean isPlayer2() {
        return player2;
    }

    public void setPlayer2(boolean player2) {
        this.player2 = player2;
    }



    public void setInUseplayer(boolean inUseplayer) {
        this.inUseplayer = inUseplayer;
    }

    public void showPlayerturn(boolean status){
        if(status == false){
            text1.setText("Player 1's turn");


        }
        if(status == true){
            text1.setText("Player 2's turn");

        }
    }


    public void handleButtonSend(){ // ChatField
        if(!message.getText().equals("")) {
            sentMessageToSever("600","Chat",message.getText()+"",idPLayer+"",null);
            message.clear();
        }
    }


    public void Chat(String message,String player){ // chat
        chat.appendText("Player"+player+":" + " "+message + "\n");
    }




}
