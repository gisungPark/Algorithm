package com.algorithm01.basic;

import java.util.Scanner;

public class SWEA10033카드뒤집기 {

	static int T, ANS;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			
			ANS = 0;
			int black = 0;
			for(int i=0; i<ch.length; i++) {
				if(ch[i] == 'W') {
					ANS+=black;
				}else {
					black++;
				}
			}
			System.out.println("#"+(tc+1) + " " + ANS);
		}
	}
}
