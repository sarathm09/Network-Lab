import java.rmi.*;  
public interface Reverse extends Remote{  
    public void reverse(String s) throws RemoteException;  
}  