package com.algorithm05.divide_conquer;

import java.util.Scanner;

//////////BOJ2630 색종이 만들기
public class BOJ2630 {
	
	static int N, white, blue;
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		func(N, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}
	private static void func(int N, int x, int y) {

		if(checkBlue(N,x,y)) { blue++; return; }
		if(checkWhite(N,x,y)) { white++; return;}
		
		func(N/2, x, y);
		func(N/2, x, y+N/2);
		func(N/2, x+N/2, y);
		func(N/2, x+N/2, y+N/2);
		
	}
	
	private static boolean checkWhite(int N, int x, int y) {

		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	private static boolean checkBlue(int N, int x, int y) {
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	


}
