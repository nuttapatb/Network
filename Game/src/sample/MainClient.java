package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
        primaryStage.setTitle("TICTACTOE");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 654, 437));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
