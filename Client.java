import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client{
    public static void main(String args[]) throws IOException{
        Socket s = new Socket("localhost",4999);
        DataOutputStream data = new DataOutputStream(s.getOutputStream()); // for sending the msg to server
        DataInputStream dt = new DataInputStream(s.getInputStream()); // for reading the msg from server
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter message:");
        while(true){
            String st = br.readLine();
            data.writeUTF(st);   // method of DataOutputStram
            if(st.equalsIgnoreCase("exit"))
                break;

            String msg = dt.readUTF();   // method of DataInputStream
            System.out.println("Server: "+msg);
            if(msg.equalsIgnoreCase("exit"))
                break;
        }
    s.close();
    }
    
}