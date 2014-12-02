import java.rmi.*;  
public interface FactI extends Remote{  
    public int factorial(int n) throws RemoteException;  
}  