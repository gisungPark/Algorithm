package com.algorithm07.dp;

import java.util.Scanner;

public class BOJ1149RGB거리 {

	static int N;
	static int[] step;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		step = new int[N+2];
		for(int i=1; i<N+1; i++) {
			step[i] = sc.nextInt();
		}
		
		long[] dy = new long[N+2];
		dy[1] = step[1];
		dy[2] = step[1]+step[2];
		for(int i=3; i<N+1; i++) {
			dy[i] = Math.max((dy[i-3]+step[i-1]), dy[i-2])+step[i];
		}
	
		System.out.println(dy[N]);
	}
}
