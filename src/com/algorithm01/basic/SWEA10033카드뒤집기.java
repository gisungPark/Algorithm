package com.algorithm01.basic;

import java.util.Scanner;

/*

2
BBWBWBBBWWBWBWBWWWBWWB
BWBWBWBBWWBWBWWBBWWWBWBBWBWWBBW


2
BBW
BWBWBW 
*/
public class SWEA10033카드뒤집기 {

	static int T, ANS;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			String str = sc.next();
			
			ANS = 0;
			int black=0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='B') black++;
				else {
					ANS+=black;
				}
			}
			System.out.println("#"+(tc+1)+ " "+ ANS);
		}
	}
}
