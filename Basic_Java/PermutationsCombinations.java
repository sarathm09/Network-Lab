import java.util.*;
import java.io.*;
import java.*;

class PermutationsCombinations{
	public static int fact(int num){
		int fact=1,i;
		for(i=1;i<=num;i++)
			fact=fact*i;
			return fact;
		}
	public static void main(String args[]) throws IOException{ 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n, r;
		System.out.println("Enter n : ");
		n = Integer.parseInt(in.readLine());
		if( n<0 ){
			System.out.println("n is less than 0");
		}
		else{
			System.out.println("Enter r : ");
			r = Integer.parseInt(in.readLine());
			if( r<=n ){
				System.out.println("Ncr = " + (fact(n)/ (fact(n-r) * fact(r)) ) );
				System.out.println("Npr = " + (fact(n)/(fact(n-r))) );
				}
			else{
				System.out.println("r is not less than n");
				}   
			}   
		}                
	}

