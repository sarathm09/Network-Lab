import java.net.*;
import java.io.*;
import java.util.*;

public class Broadcastserver{
 public static final int PORT = 2000;
  public static void main(String args[])throws Exception{
   MulticastSocket sckt;
   DatagramPacket pckt;
   InetAddress adrs;
    System.out.print("Whats on your mind : \n");
   while(true)   { 
    adrs=InetAddress.getByName("255.255.255.255");
  	sckt = new MulticastSocket();
  	byte[] data;
  	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
  	String str=b.readLine();
  	data = str.getBytes();
  	pckt = new DatagramPacket(data,str.length(),adrs,PORT);
  	sckt.send(pckt);
   }
  }
 } 