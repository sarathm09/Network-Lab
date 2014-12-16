/* t90*/
import java.rmi.*;  
import java.rmi.server.*;  
      
public class ReverseRemote extends UnicastRemoteObject implements Reverse{  

	ReverseRemote()throws RemoteException{}  
      
	public void reverse(String s){
		String rev="";
		for( int i = s.length()-1 ; i>-1 ; i--){
			rev += s.charAt(i);
			}
		System.out.println("reversing " + s + "gives : " + rev);
		}  
    }  