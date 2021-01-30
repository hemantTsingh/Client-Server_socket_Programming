import java.io.*;

import java.net.*;

import javax.swing.*;


public class Client extends JFrame {
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    private JLabel heading=new JLabel("Client Area");
    private JTextArea messageArea=new JTextArea();
    private JTextField messageInput=new JTextField();
    private Object Font;
    private Font font=new Font("Roboto",Font.PLAIN,20);

    

    public Client(){


        try{
            // System.out.println("Sending request to server");
            // socket=new Socket("127.0.0.1",7777);
            // System.out.println("Connection done");

            // br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // out=new PrintWriter(socket.getOutputStream());

                createGUI();
            // startReading();
            // startWriting();



        }catch(Exception e){e.printStackTrace();}
    }
    private void createGUI(){

        this.setTitle("MessageUPES");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startReading(){
        Runnable r1=()->{
    
            System.out.println("Reader Started");
            while(true){
    
                try{
                String msg=br.readLine();
                if(msg.equals("exit")){
                    System.out.println("Pratyush terminated the chat");
                    break;
                }
                System.out.println("Pratyush: "+msg);
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
       
       



    public static void main(String[] args)
{

    System.out.println("This is Pratyush");
    new Client();



}    
}
