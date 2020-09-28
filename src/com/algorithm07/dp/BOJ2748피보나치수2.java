package com.algorithm07.dp;

import java.util.Scanner;

public class BOJ2748피보나치수2 {

	static int N;
	static long[] dy;
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		dy = new long[N+2];
		dy[1] = 1;
		dy[2] = 1;
		
		long ANS = DFS(N);
		System.out.println(ANS);
		
	}
	private static long DFS(int n) {
		if(dy[n] != 0) return dy[n];
		else {
			return dy[n] = DFS(n-1) + DFS(n-2);
		}
	}
}
