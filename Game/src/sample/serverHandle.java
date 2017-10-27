package sample;

import javafx.application.Platform;

import java.io.BufferedReader;

public class serverHandle implements Runnable{


    BufferedReader bufferedReader ;
    GameController controller;

    public serverHandle(BufferedReader bufferedReader,GameController controller){
        this.controller = controller;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(){

        String message;

        try{
            while((message = bufferedReader.readLine())!= null){
                System.out.println(message);
                String[] data = message.split("-");
                if(data[0].equals("802")) {//set Id player
                    controller.setIdPLayer(Integer.parseInt(data[2]));
                } else if(data[0].equals("600")) {//chat
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            controller.Chat(data[2]+"",data[4]+"");
                        }
                    });

                } else if(data[0].equals("801")) {//set turn
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (data[2].equals("1")) {
                                controller.showPlayerturn(true);
                            }
                            if (data[4].equals("2")) {
                                controller.showPlayerturn(false);
                            }
                        }
                    });
                }else if (data[0].equals("800")){

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
