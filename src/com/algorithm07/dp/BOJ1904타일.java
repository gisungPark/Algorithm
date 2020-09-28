package com.algorithm07.dp;

import java.util.Scanner;

public class BOJ1904타일 {
	
	static int N;
	static long[] dy;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dy = new long[N+3];
		
		dy[1] = 1;
		dy[2] = 2;
		dy[3] = 3;
		
		for(int i=3; i<N+1; i++) {
			dy[i] = (dy[i-2]+dy[i-1])%15746;
		}
		
		System.out.println(dy[N]);
		
	}
}
