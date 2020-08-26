package com.algorithm05.divide_conquer;

import java.util.Scanner;

public class BOJ1992 {
	
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		sc.nextLine();
		
		for(int i = 0; i<N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
	
		System.out.println(func(N,0,0));
	
	//	print(map);
	
	}
	private static String func(int N, int x, int y) {
		
		boolean is0 = true
				,is1 = true;
		
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(map[i][j] != 0) { is0 = false; break; } 
			}
			if(!is0) break;
		}
		if(is0) return "0";
		
		
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(map[i][j] != 1) { is1 = false; break; } 
			}
			if(!is1) break;
		}
		if(is1) return "1";
		
		
		return "(" + func(N/2, x,y) +func(N/2, x, y+N/2)
					+ func(N/2, x+N/2, y) + func(N/2, x+N/2, y+N/2) + ")";
		
	}
	private static void print(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}