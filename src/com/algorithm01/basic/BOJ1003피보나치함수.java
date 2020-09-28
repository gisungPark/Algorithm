package com.algorithm01.basic;

import java.util.Scanner;

public class BOJ1003피보나치함수 {

	static int T, N;
	static int[][] dy;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			N = sc.nextInt();
			dy = new int[N+3][2];
			
			dy[0][0] = 1;
			dy[1][1] = 1;
			for(int i=2; i<=N; i++) {
				dy[i][0] = dy[i-2][0] + dy[i-1][0];
				dy[i][1] = dy[i-2][1] + dy[i-1][1];
			}
			System.out.println(dy[N][0] + " "+ dy[N][1]);
		}
	}
}
