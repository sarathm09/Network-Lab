    import java.rmi.*;  
    import java.rmi.registry.*;  
      
    public class Server{  
    public static void main(String args[]){  
		try{   
			FactRemote stub=new FactRemote();  
			Naming.rebind("fact",stub);   
		}catch(Exception e){
			System.out.println(e);
			}  
		}  
      
    }  