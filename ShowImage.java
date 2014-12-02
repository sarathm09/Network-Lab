import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
public class ShowImage extends JPanel implements ActionListener{
  BufferedImage image;
   BufferedImage img; 
  static int orig=0,grey=0;
static JButton v,v1;
 public ShowImage(){
   super();

        v = new JButton("Gray");
    v.setBounds(100,30,100,30);
    v.addActionListener(this);
  
    
    v1=new JButton("Original");
    v1.setBounds(0,30,100,30);
  v1.addActionListener(this);
try
{
  File input = new File("Koala.jpg");
         image = ImageIO.read(input);
          img = ImageIO.read(input);
} 
catch (Exception e) {}
  }



public void paintComponent(Graphics g) {
  if(orig==1)
      g.drawImage(img,0,0,200,200, this);         
  for(int i=0; i<image.getHeight(); i++){
            for(int j=0; j<image.getWidth(); j++){
               Color c = new Color(image.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               Color newColor = new Color(red+green+blue,
               red+green+blue,red+green+blue);
               image.setRGB(j,i,newColor.getRGB());
               }
          }
    if(grey==1)
         g.drawImage(image,300,150,200,200, this);
      
   }

  public static void main(String arg[]){
   JFrame frame = new JFrame("ShowImage");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(600,400);

   ShowImage panel = new ShowImage();
   frame.setContentPane(panel);
       panel.add(v1);
       panel.add(v);

   frame.setVisible(true); 
  }
  public void actionPerformed(ActionEvent e)
  {

    String str=e.getActionCommand();
  if(str.equals("Original"))
     { orig=1-orig; }
    if(str.equals("Gray"))
      grey=1-grey;
repaint();
  }
}