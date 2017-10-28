package sample;

import java.io.BufferedReader;

public class clientHandle implements Runnable {

    BufferedReader bufferedReader ;
    Controller controller;


    public clientHandle(BufferedReader bufferedReader,Controller controller){
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
                if(controller.writers.size() <= 2 ){
                    if(data[0].equals("900")) {// Greeting
                        controller.sendMessageToClient("802", "Set Player", controller.writers.size() + "", controller.writers.size() - 1, "0");
                    }
                    }
//                    if(data[0].equals("712")){//set button
//                        controller.sendMessageToClient("712","Set Button",data[2]+"",0,"0");
//                        controller.sendMessageToClient("712","Set Button",data[2]+"",1,"0");
//                    }

//                    if(data[0].equals("720")) {//set hit
//                        if (data[3].equals("1")) {
//                            controller.sendMessageToClient("720", "Set Hit", data[2] + "", 0, "1");
//                            controller.sendMessageToClient("720", "Set Hit", data[2] + "", 1, "1");
//                        }
//                        if (data[3].equals("2")) {
//                            controller.sendMessageToClient("720", "Set Hit", data[2] + "", 0, "2");
//                            controller.sendMessageToClient("720", "Set Hit", data[2] + "", 1, "2");
//                        }
//                    }
                    if(data[0].equals("801")){ // turn
                        if(data[3].equals("1")){
                            controller.sendMessageToClient("801","Player Turn",data[2]+"",0,"1");
                        }
                        if(data[3].equals("2")){
                            controller.sendMessageToClient("801","Player Turn",data[2]+"",1,"2");
                        }
                    }

                    if (data[0].equals("800")){ //
                        if (data[3].equals("1")){
                            if (data[4].equals("9")){


                            }
                        }
                        if (data[3].equals("2")){
                            if (data[4].equals("9")){


                            }
                        }
                    }




                    if(data[0].equals("600")) {
                        if (data[3].equals("1")) {
                            controller.sendMessageToClient("600", "Chat", data[2]+"", 0, "1");
                            controller.sendMessageToClient("600", "Chat", data[2]+"", 1, "1");
                        }if(data[3].equals("2")){
                            controller.sendMessageToClient("600", "Chat", data[2]+"", 1, "2");
                            controller.sendMessageToClient("600", "Chat", data[2]+"", 0, "2");
                        }

                    }
                    if (data[0].equals("800")){
                        controller.sendMessageToClient("800","Player",data[2]+"",0,"1");
                        controller.sendMessageToClient("800","Player",data[2]+"",1,"2");
                    }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
