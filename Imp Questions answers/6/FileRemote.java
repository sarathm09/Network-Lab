    import java.rmi.*;  
    import java.rmi.server.*;
    import java.io.* ;
      
    public class FileRemote extends UnicastRemoteObject implements FileI{
    	BufferedReader in;
    	BufferedWriter out;

		FileRemote()throws RemoteException{
		}  

      	public int[] sortnum(String fname) throws RemoteException, IOException{
      		try{
	      		in = new BufferedReader(new FileReader(fname));
	      		out = new BufferedWriter(new FileWriter("d.txt"));
	      		int i,n=0,j=0;
	      		int[] a = new int[100];
	      		int[] b = new int[100];
	      		String temp;
	      		while( (temp = in.readLine()) != null){
	                a[n++] = Integer.parseInt(temp);
	            }
	            for(i=0;i<n;i++){
	            	for(j=i;j<n-i-1;j++){
	            		if(a[j]>a[j+1]){
	            			int t = a[j];
	            			a[j] = a[j+1];
	            			a[j+1] = t;
	            		}
	            	}
	            }
	            for(i=0;i<n;i++){
	            	out.write(a[i] + "\n");
	            }
	            out.close();
	            a[n] = -100;//just to indicate the end of array, as we can't return n
	            return a;
        	}catch(Exception e){

        	}	
        	return null;
      	} 
    	public int[] oddnum(String fname) throws RemoteException{
    		try{
	      		in = new BufferedReader(new FileReader(fname));
	      		out = new BufferedWriter(new FileWriter("d.txt"));
	      		int i,n=0,j=0;
	      		int[] a = new int[100];
	      		int[] b = new int[100];
	      		String temp;
	      		while( (temp = in.readLine()) != null){
	                a[n++] = Integer.parseInt(temp);
	            }
	            for(i=0;i<n;i++){
	            	if(a[i]%2==1){
	            		b[j++] = a[i];
	            	}
	            }
	            for(i=0;i<n;i++){
	            	out.write(b[i] + "\n");
	            }
	            out.close();
	            b[n] = -100;//just to indicate the end of array, as we can't return n
	            return b;
           	}catch(Exception e){
        	}
        	return null;
    	} 
    	public int sumnum(String fname) throws RemoteException{
    		try{
	      		in = new BufferedReader(new FileReader(fname));
	      		out = new BufferedWriter(new FileWriter("d.txt"));
	      		int i,n=0,sum=0;
	      		int[] a = new int[100];
	      		int[] b = new int[100];
	      		String temp;
	      		while( (temp = in.readLine()) != null){
	                a[n++] = Integer.parseInt(temp);
	            }
	            for(i=0;i<n;i++){
	            	sum += a[i];
	            }
	            out.write(sum + "\n");
	            out.close();
	            return sum;
        	}catch(Exception e){

        	}
        	return 0;
    	}       
    }  