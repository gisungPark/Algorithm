package com.algorithm01.basic;

import java.util.Scanner;

//////////////BOJ2991. 사나운 개//////////
public class BOJ2991 {

	static int A, B, C, D;
	static int P, M, N; 		// 우체부, 우유, 신문의 도착시간
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		P = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();
		
		int dog1 = A+B;
		int dog2 = C+D;
		
		int cnt = 0;
		if(P%dog1<=A && P%dog1 != 0) cnt++;
		if(P%dog2<=C && P%dog2 != 0) cnt++;
		System.out.println(cnt);
		
		cnt = 0;
		if(M%dog1<=A && M%dog1 != 0) cnt++;
		if(M%dog2<=C && M%dog2 != 0) cnt++;
		System.out.println(cnt);
		
		cnt = 0;
		if(N%dog1<=A && N%dog1 != 0) cnt++;
		if(N%dog2<=C && N%dog2 != 0) cnt++;
		System.out.println(cnt);
		
		
		
	}

}
