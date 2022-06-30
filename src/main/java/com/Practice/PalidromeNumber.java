package com.Practice;

import java.util.Scanner;

public class PalidromeNumber {
	
	
	static int i=10;
	 static String name="Madhulika Gardi";
	
	
	
	public static void main(String[] args) {
		
		PalidromeNumber num = new PalidromeNumber();
		System.out.println(num.i);
		System.out.println(num.name);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:   ");
		int number=sc.nextInt();
		
		
		//int number= 1234;
		int reverse;
		int sum=0;
		
		int x=number;
		
		while(x>0) {
			
			reverse=x%10;              
			sum=(sum*10)+reverse;  
			x=x/10;   
			
	}
		
		System.out.println(sum);
		if(number==sum) {
			
			System.out.println("Palidrome");
		}else {
			
			
			System.out.println("Not palidrome");
		}
		
	}

}
