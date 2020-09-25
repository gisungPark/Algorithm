package com.algorithm00.im;

import java.util.Scanner;

public class BOJ2563색종이 {

	static int N;
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		map = new int[100][100];
		
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			attach(x, y);
		}
		int ANS = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1) ANS++;
			}
		}
		System.out.println(ANS);
	}
	private static void attach(int x, int y) {
		
		for(int i=x; i<x+10; i++) {
			for(int j=y; j<y+10; j++) {
				map[i][j] = 1;
			}
		}
	}
}
