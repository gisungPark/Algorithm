package com.algorithm01.basic;

import java.util.Scanner;

public class JUNGOL1329 {

	static int N;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=1; i<=N/2+1; i++) {
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=N/2; i>0; i--) {
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
