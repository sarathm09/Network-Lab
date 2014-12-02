import java.rmi.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Client implements ActionListener{
	JFrame frame;
	JTextField n,r;
	JLabel nLabel,rLabel,resLabel;
	JButton submit;
	FactI stub;
	void showUI(){
		try{
			stub = (FactI)Naming.lookup("rmi://localhost/fact")
			frame=new JFrame("Factorial GUI");
			GridLayout gl=new GridLayout(3,2);
			frame.setLayout(gl);
			n = new JTextField();
			r = new JTextField();;
			nLabel = new JLabel("Enter val of N");
			rLabel = new JLabel("Enter val of R");
			submit = new JButton("Submit");
			submit.addActionListener(this);
			resLabel = new JLabel("Press submit");
			frame.add(nLabel);
			frame.add(n);
			frame.add(rLabel);
			frame.add(r);
			frame.add(submit);
			frame.add(resLabel);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setSize(400,250);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}catch(Exception e){}  
	}
    public static void main(String args[]){  
    		new Client().showUI();
    }
    public void actionPerformed(ActionEvent ae){
    	try{  
			int nval = Integer.parseInt(n.getText());
			int rval = Integer.parseInt(r.getText());
			int ncr = stub.factorial(nval)/(stub.factorial(rval)*stub.factorial(nval-rval));
			int npr = stub.factorial(nval)/(stub.factorial(nval-rval));
			resLabel.setText("<center>NPR : "+npr + "<br/>NCR : " + ncr + "</center>");
			}
		catch(Exception e){
		}
	}
}