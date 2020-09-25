package com.algorithm00.im;

import java.util.Scanner;

public class BOJ2669직사각형네개의합집합의면적 {

	static int map[][];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		map = new int[102][102];
		
		for(int k=0; k<4; k++) {
			int x1 = sc.nextInt();
			int y1= sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int i=x1; i<x2; i++) {
				for(int j=y1; j<y2; j++) {
					map[i][j] = 1;
				}
			}
		}
		int ANS = 0;
		for(int i=0; i<102; i++) {
			for(int j=0; j<102; j++) {
				if(map[i][j] == 1) ANS++;
			}
		}
		System.out.println(ANS);
	}
}
