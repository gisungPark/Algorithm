package com.algorithm05.divide_conquer;

import java.util.Scanner;

////////////// Z /////////
public class BOJ1074 {

	static int N, r, c, ANS, res ;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int size = (int)Math.pow(2, N);
		
		func(size, 0, 0);
		System.out.println(res);
	}

	private static void func(int N, int x, int y) {
		if((x+N-1) < r && (y+N-1) <c) {ANS+=N*N; return;}
		if( x > r && y > c) return;
		if(N != 2) {
			func(N/2, x,y);
			func(N/2, x, y+N/2);
			func(N/2, x+N/2, y);
			func(N/2, x+N/2, y+N/2);
		}else {
			for(int i = x; i < x+N; i++) {
				for(int j = y; j < y+N; j++) {
					ANS++;
					if(i == r && j == c) { res = ANS-1; return;}
				}
			}
		}
	}
}
