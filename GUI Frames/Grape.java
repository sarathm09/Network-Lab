import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Grape
{
	JTextField name,roll,branch,year,avg;
	JFrame frame;
	JPanel pan,span,p2;
	JLabel n,r,b,y,a;
	JButton submit;
	JTextArea aria;
	public static void main(String args[])
	{
		new Grape().go();
	}
	public void go()
	{
		frame=new JFrame("Student Form");
		pan=new JPanel();
		GridLayout gl=new GridLayout(5,2);
		pan.setLayout(gl);
		submit=new JButton("Submit");
		name=new JTextField();
		n=new JLabel("Name");
		roll=new JTextField();
		r=new JLabel("Roll Number");
		branch=new JTextField();
		b=new JLabel("Branch");
		year=new JTextField();
		y=new JLabel("Year");
		avg=new JTextField();
		a=new JLabel("Average");
		aria=new JTextArea();
		submit.addActionListener(new SubmitListener());
		pan.add(n);
		pan.add(name);
		pan.add(r);
		pan.add(roll);
		pan.add(b);
		pan.add(branch);
		pan.add(y);
		pan.add(year);
		pan.add(a);
		pan.add(avg);
		frame.add(BorderLayout.NORTH,pan);
		p2=new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(BorderLayout.NORTH,submit);
		p2.add(BorderLayout.CENTER,aria);
		frame.add(BorderLayout.CENTER,p2);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(400,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class SubmitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			aria.setText("Name : "+name.getText()+"\nRoll number : "+roll.getText()+"\nBranch : "+branch.getText()+"\nYear : "+year.getText()+"\nAverage marks : "+avg.getText());
		}
	}
}
