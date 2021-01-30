import java.io.*;

import java.net.*;

class Serverr{

        ServerSocket server;
        Socket socket;
        BufferedReader br;
        PrintWriter out;

        public Serverr(){
        try{
            server=new ServerSocket(7777);
            System.out.println("Server is ready to accept connection");
            System.out.println("waiting...");
            socket=server.accept();
            br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());
            startReading();
            startWriting();


             }catch(Exception e){
        e.printStackTrace();
    
    }

}


public void startReading(){
    Runnable r1=()->{

        System.out.println("Reader Started");
        while(true){

            try{
            String msg=br.readLine();
            if(msg.equals("exit")){
                System.out.println("Saransh terminated the chat");
                break;
            }
            System.out.println("Saransh: "+msg);
        }catch(Exception e){
            e.printStackTrace();

        }
        }

    };
    new Thread(r1).start();
}


public void startWriting(){
 Runnable r2=()->{
    System.out.println("Writer Started...");




    while(true){

        try{
            BufferedReader br1=new BufferedReader(new 
            InputStreamReader(System.in));

            String content=br1.readLine();
            out.println(content);
            out.flush();
       }catch(Exception e){
        e.printStackTrace();
        }
    }
    };
    new Thread(r2).start();

}



    

public static void main(String[] args){
    System.out.println("this is server...going to start server");
    new Serverr();


}
}