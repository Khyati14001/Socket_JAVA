import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Server{
    public static void main(String args[]) throws IOException{
        ServerSocket ser = new ServerSocket(4999);
        Socket s = ser.accept();
        DataInputStream data = new DataInputStream(s.getInputStream());  //for reading the msg from client
        DataOutputStream dt = new DataOutputStream(s.getOutputStream()); // For sending the msg to client
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Client Connected");
        while(true){
            String msg = data.readUTF(); // method of DataInputStream
            System.out.println("Client: "+msg);
            if(msg.equalsIgnoreCase("exit"))
                break;

            
            String st = bf.readLine();
            dt.writeUTF(st); // method of DataOutputStram
            if(st.equalsIgnoreCase("exit"))
                break;
        }
        s.close();

    }
}