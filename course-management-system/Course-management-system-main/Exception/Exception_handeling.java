package Exception;

import java.util.Scanner;

public class Exception_handeling {
	 public static void main(String args[]){  
		 Scanner sc = new Scanner(System.in);
		 int data = 100;
		 System.out.println("Enter a divider: ");
		   try{  
		   int divider = sc.nextInt();
		   System.out.println(data/divider);
		   
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }  
		   sc.close();
		   System.out.println("Code after an exception");
		   
		  }  
}
