import java.net.*;
import java.io.*;
class brodclient extends Thread
{
	DatagramPacket pp;
	DatagramSocket ss;
	InetAddress addr;
	byte[] data;
	
	brodclient()
	{
		try
		{
		ss = new DatagramSocket(1234);
		}
		catch(Exception e)
                {
                        System.out.println("Error:"+e);
                }
	}
	public void run()
	{
		try
		{
		String str;
		do
		{
			data = new byte[50];
			pp = new DatagramPacket(data,data.length);
			ss.receive(pp);
			str = new String(data);
			System.out.println("from server :" + str);
		}while(!str.equals("bye"));
		ss.close();
		}
		catch(Exception e)
                {
                        System.out.println("Error:"+e);
                }
	}
	
	public static void main(String args[])
	{
		brodclient obj = new brodclient();
		obj.start();
	}
}	
	