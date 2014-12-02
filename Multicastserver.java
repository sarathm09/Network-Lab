import java.net.*;
import java.io.*;
import java.util.*;

public class Multicastserver{
 public static final int PORT = 4000;
  public static void main(String args[])throws Exception{
   MulticastSocket sckt;
   DatagramPacket pckt;
   InetAddress adrs;
   while(true){ 
    adrs=InetAddress.getByName("232.2.2.2");
  	sckt = new MulticastSocket();
  	byte[] data;
  	System.out.println("Enter the msg : ");
  	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
  	String str=b.readLine();
  	data = str.getBytes();
  	pckt = new DatagramPacket(data,str.length(),adrs,PORT);
  	sckt.send(pckt);
    }
  }
 } 