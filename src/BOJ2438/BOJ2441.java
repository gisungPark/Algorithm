
package BOJ2438;

import java.util.Scanner;

public class BOJ2441 {
	static int N;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) 
				System.out.print(" ");
			
			for(int j=i; j<N; j++)
				System.out.print("*");
			System.out.println();
		}
		
	}

}
