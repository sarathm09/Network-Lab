import java.net.*;
import java.io.*;
import java.util.*;

public class Broadcastclient{
public static final int PORT = 2000;
public static void main(String args[])throws Exception{
   MulticastSocket sckt;
   DatagramPacket pckt;
   InetAddress adrs;
   while(true){ 
    adrs=InetAddress.getByName("231.4.2.3");
	sckt = new MulticastSocket(PORT);
	sckt.joinGroup(adrs);
	byte[] data=new byte[100];
	pckt = new DatagramPacket(data,data.length);
	sckt.receive(pckt);
	String str=new String(pckt.getData());
	System.out.println(pckt.getAddress()+"Message : "+str);
   }
  }
 } 