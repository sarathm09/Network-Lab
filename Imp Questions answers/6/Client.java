import java.rmi.*;
import java.io.*;

public class Client{
    public static void main(String args[]){  
    	try{  
    		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    		String filename, opr;
    		int i;
			FileI stub=(FileI)Naming.lookup("rmi://127.0.0.1/file");
	    	while(true){
		    	System.out.println("\n\tFiles\n\t\ta.txt,b.txt,c.txt\n\tOps\n\t\tsort,odd,sum\n");
		    	System.out.println("\n\tFilename : ");
		    	filename = in.readLine();
		    	System.out.println("\n\tOperation : ");
		    	opr = in.readLine();

		    	if(opr.equals("sort")){
		    		int[] a  = stub.sortnum(filename);
		    		i = 0;
		    		while(a[i]!=-100){
		    			System.out.println("\n\t" + a[i++]);
		    		}
		    	}
		    	else if(opr.equals("odd")){
		    		int[] a  = stub.oddnum(filename);
		    		i = 0;
		    		while(a[i]!=-100){
		    			System.out.println("\n\t" + a[i++]);
		    		}
		    	}
		    	else if(opr.equals("sum")){
		    		int a  = stub.sumnum(filename);
		    		System.out.println("\n\t" + a);
		    	}
		    	else{
					System.out.println("\tError!!!");
		    	}
	    	}
	    }catch(Exception e){

	    }
    }
   
}