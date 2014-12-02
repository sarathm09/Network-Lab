    import java.rmi.*;
	import java.io.*;
      
    public class Client{  
      
    public static void main(String args[]) throws IOException{  
		try{  
			Reverse stub=(Reverse)Naming.lookup("rmi://127.0.0.1/reverse");  
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			System.out.println("\n\nEnter the string to reverse : ");
			String word = in.readLine();
			stub.reverse(word);  
		}catch(Exception e){}  
		}  
      
    }  