import java.net.*;
import java.io.*;
import java.util.*;

public class Multicastclient{
 public static final int PORT = 4000;
  public static void main(String args[])throws Exception  {
   MulticastSocket sckt;
   DatagramPacket pckt;
   InetAddress adrs;
   while(true)   { 
    adrs=InetAddress.getByName("232.2.2.2");
  	sckt = new MulticastSocket(PORT);
  	sckt.joinGroup(adrs);
  	byte[] data=new byte[100];
  	pckt = new DatagramPacket(data,data.length);
  	sckt.receive(pckt);
  	String str=new String(pckt.getData());
  	System.out.println(pckt.getAddress()+" : "+str);
   }
  }
 } 