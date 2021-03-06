   import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class clientgui extends JFrame implements ActionListener,Runnable
{
	JButton b1;
	JTextField t1;
	JTextArea t2;
	JLabel l1,l2;
	Socket s;
	Thread th1=null;
	BufferedReader fc,fs;
	PrintWriter pw1;
	String msg=null;

	public clientgui()
	{
	try
	{
		s=new Socket("localhost",3000);
		System.out.println("Client ready to send message");
		
		b1=new JButton("Send");
		b1.setBounds(350,10,80,20);

		Container cont = getContentPane();
			
		t1=new JTextField();
		t2=new JTextArea();
		t2.setBorder(BorderFactory.createLineBorder( Color.black ));
		t1.setBounds(110,10,200,20);
		t2.setBounds(10,140,250,100);
		
		JScrollPane scroller = new JScrollPane(t2);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		
		l1=new JLabel("Enter Text ");
		l2=new JLabel("Messages received");
		l1.setBounds(10,0,80,40);
		l2.setBounds(10,100,170,100);
		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		pane.add(b1);
		pane.add(t1);
		pane.add(t2);
		pane.add(l1);
		pane.add(l2);
		cont.add(pane);
		
		JFrame frame=new JFrame("CLIENT");
		frame.add(pane);
		frame.setBounds(0,00,500,400);
		frame.setVisible(true);
		
		b1.addActionListener(this);
		fs=new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw1=new PrintWriter(s.getOutputStream(),true);
		fc=new BufferedReader(new InputStreamReader(System.in));
		
		}
		catch(Exception e)
		{
		}
	}

	public void run()
	{
		String msg;
		try
		{
				do
				{
					msg=fs.readLine();
					t2.append("SERVER:"+msg+"\n");
				}
				while(!msg.equals("quit"));
				System.exit(0);
				s.close();
		}
		catch(Exception e)
		{}
	}

	public void actionPerformed(ActionEvent e)
	{
		String msg=new String();
		try{
					if(e.getSource()==b1)
					{
						msg=t1.getText();	
						t2.append("CLIENT:"+msg+"\n");
						pw1.println(msg);
						if(msg.equals("quit"))
						{
							System.exit(0);
							s.close();
						}
						t1.setText("");
					}
			}
		catch(Exception e1) {System.out.println("ERROR:"+e1);}
	}

	public static void main(String args[])
	{
		clientgui g=new clientgui();
		g.th1=new Thread(g);
		g.th1.start();
	}
}
