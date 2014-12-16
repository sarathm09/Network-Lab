/* t90*/
import java.rmi.*;  
import java.rmi.registry.*;  
     
public class Server{  
	public static void main(String args[]){  
		try{   
			ReverseRemote stub=new ReverseRemote();  
			Naming.rebind("reverse",stub);   
		}catch(Exception e){
			System.out.println(e);
			}  
		}  
      
    }  