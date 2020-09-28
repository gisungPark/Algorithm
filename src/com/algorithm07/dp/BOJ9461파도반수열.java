package com.algorithm07.dp;

import java.util.Scanner;

public class BOJ9461파도반수열 {

	static int T, N;
	static long[] dy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=0; tc<T; tc++ ) {
			N = sc.nextInt();
			dy = new long[N+7];
			
			dy[1] = 1;
			dy[2] = 1;
			dy[3] = 1;
			dy[4] = 2;
			dy[5] = 2;
			dy[6] = 3;
			for(int i=7; i<N+1; i++) {
				dy[i] = dy[i-1] + dy[i-5]; 
			}
			
			System.out.println(dy[N]);
		}
	}
}
