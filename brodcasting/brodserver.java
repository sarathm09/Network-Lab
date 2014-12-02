import java.net.*;
import java.io.*;
class brodserver extends Thread
{
	DatagramPacket p;
	DatagramSocket s;
	InetAddress addr;
	byte[] data;
	BufferedReader br;
	
	brodserver()
	{
		try
		{
		addr = addr.getByName("192.168.1.255");
		s = new DatagramSocket(2500);
		this.start();
		}
		catch(Exception e)
                {
                        System.out.println("Error:"+e);
                }
	}
	void broadcast(byte[] data)
	{
		try
		{
		p = new DatagramPacket(data,data.length,addr,1234);
		s.send(p);
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
		String str = "start";
		do
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			str = br.readLine();
			data = str.getBytes();
			broadcast(data);
			if(str.equals("bye"))
			{
				System.out.println("Server stopped");
				System.exit(0);
			}
		}while(!str.equals("bye"));	
		s.close();
		}
		catch(Exception e)
                {
                        System.out.println("Error:"+e);
                }
	}
	public static void main(String args[])
	{
		
		brodserver obj = new brodserver();
	}
}			