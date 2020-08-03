package JUNGOL1719;

import java.util.Scanner;

public class JUNGOL1719 {
	static int N, M;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		if(N>100) System.out.println("INPUT ERROER!");
		else {
			switch (M) {
			case 1:
				print1();
				break;
			case 2:
				print2();
				break;
			case 3:
				print3();
				break;
			case 4:
				print4();
				break;

			default:
				System.out.println("INPUT ERROER!");
				break;
			}
		}
	}

	private static void print1() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=N/2+1; i<N; i++) {
			for(int j=N/2-i; j>=0; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void print2() {
		
		
	}
	
	private static void print3() {
		
	}
	
	private static void print4() {
		
	}


}
