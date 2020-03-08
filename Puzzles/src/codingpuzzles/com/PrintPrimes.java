package codingpuzzles.com;

import java.util.Scanner;

public class PrintPrimes {

	public static void main(String[] args) {
		boolean isPrime=true;
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=1 ; i<=num  ; i++) {
			for(int j = 2; i>j && j<=9 ;j++)
			{
			int mod =i%j;	
			if( i%j != 0) {
					isPrime = true;
				} else {
					isPrime = false;
					break;
					
				}
				
			}
			
			if(isPrime)
				System.out.print(i+" ");
			
		}

	}

}
