package codingpuzzles.com;

import java.util.Scanner;

public class FloydTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of rows::::");
		int r = sc.nextInt();
		int n=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(String.valueOf(++n).concat(" "));
			}
			System.out.println();
		}

	}
//		int r = sc.nextInt();
//        int n=0;
//        for(int i=0; i<r; i++){
//            for(int j=0; j<=i; j++){
//                System.out.print(String.valueOf(++n).concat(" "));
//            }
//            System.out.println();
//       }
//	}	
}
