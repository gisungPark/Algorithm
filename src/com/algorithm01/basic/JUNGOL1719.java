package com.algorithm01.basic;

import java.util.Scanner;
////////////별 삼각형2///////////////
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
		for(int i=0; i<=N/2; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1; i<=N/2; i++) {
			for(int j=N/2-i; j>=0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void print2() {

		for(int i=0; i<N/2; i++) {
			for(int j=0; j<=N/2-i-1; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for(int i=0; i<N/2+1; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j =N/2-i; j>=0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	private static void print3() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=0;j<N-i*2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<N/2+1; i++) {
			for(int j=0; j<N/2-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	private static void print4() {
		
	}


}
