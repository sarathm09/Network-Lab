import java.rmi.*; 
import java.io.*;
public interface FileI extends Remote{  
    public int[] sortnum(String fname) throws RemoteException,IOException;  
    public int[] oddnum(String fname) throws RemoteException,IOException;  
    public int sumnum(String fname) throws RemoteException,IOException;  
}  