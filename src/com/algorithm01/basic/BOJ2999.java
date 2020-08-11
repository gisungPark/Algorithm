package com.algorithm01.basic;

import java.util.Scanner;

public class BOJ2999 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int N = 0, M = 0;

		for (int i = 1; i*i <= str.length(); i++) {
			for (int j = str.length(); j*j >= str.length(); j--) {
				if (i * j == str.length() && i > N) {
					N = i;
					M = j;
					break;
				}
			}
		}
		char[][] map = new char[N][M];
		int idx = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[j][i] = str.charAt(idx++);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]);
			}
		}
	
	}

}
