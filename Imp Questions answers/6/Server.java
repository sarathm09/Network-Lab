    import java.rmi.*;  
    import java.rmi.registry.*;  
      
    public class Server{  
    public static void main(String args[]){  
		try{   
			FileRemote stub=new FileRemote();  
			Naming.rebind("file",stub);   
		}catch(Exception e){
			System.out.println(e);
			}  
		}  
      
    }  