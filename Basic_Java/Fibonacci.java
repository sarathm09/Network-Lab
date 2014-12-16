import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.*;
public class Fibonacci {
    public static void main(String args[]){
	 try{
        System.out.print("Enter number of terms : ");
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		if(number<0){
		 System.out.println("Number is less than 0");
		 }
		 else {
		 	System.out.println("\n\nFibonacci series : ");
		    for(int i=1; i<=number; i++){
               System.out.print(fibonacciLoop(i));
			   System.out.print("\n");
			   }  
			}
		}
		catch(Exception e1){
			System.out.println("Wrong input !!");
			}   
    } 
    
    public static int fibonacciLoop(int number){   
        if(number == 1 || number == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++)	{
            fibonacci = fibo1 + fibo2; 
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
	    }
	}
	
	
    
	

