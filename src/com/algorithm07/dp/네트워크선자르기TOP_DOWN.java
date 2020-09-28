package com.algorithm07.dp;

import java.util.Scanner;

public class 네트워크선자르기TOP_DOWN {
	
	static int N;
	static int[] dy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dy = new int[10];
		dy[1] = 1;
		dy[2] = 2;
		
		System.out.println(DFS(N));
		
	}
	private static int DFS(int n) {
		if(dy[n]!=0) return dy[n];
		else {
			return dy[n] = DFS(n-1) + DFS(n-2);
		}
		
	}

}
