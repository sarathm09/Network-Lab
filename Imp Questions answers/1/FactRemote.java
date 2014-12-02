    import java.rmi.*;  
    import java.rmi.server.*;  
      
    public class FactRemote extends UnicastRemoteObject implements FactI{  
      
		FactRemote()throws RemoteException{
		}  
      
		public int factorial(int n){
			if(n==0)
				return 1;
			else
				return n * factorial(n-1);
		}  
      
    }  