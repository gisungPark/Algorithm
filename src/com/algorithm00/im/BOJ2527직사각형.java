package com.algorithm00.im;

import java.util.Scanner;

public class BOJ2527직사각형 {

	static int T = 4;
	static int[][] sq;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int tc=0; tc<4; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			if (A > c || B > d || a > C || b > D) {
				System.out.println("d");
			} else if ((A == c && B == d) || (a == C && d == B) 
					|| (A == c && D == b) || (a == C && b == D)) {
				System.out.println("c");
			} else if (A==c || B==d || C==a || D==b) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}
	
}
