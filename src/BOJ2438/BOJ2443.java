
package BOJ2438;

import java.util.Scanner;

public class BOJ2443 {
	static int N;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) 
				System.out.print(" ");
			
			for(int j=0; j<N*2-1-2*i; j++)
				System.out.print("*");
			System.out.println();
		}
		
	}

}
