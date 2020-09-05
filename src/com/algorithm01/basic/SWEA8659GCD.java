package com.algorithm01.basic;

import java.util.Scanner;

/*
3
1
3
20

*/
public class SWEA8659GCD {

	static int T, K;
	static int a, b, ANS1, ANS2;
	static boolean isOk;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			K = sc.nextInt();
			ANS1 = 0; ANS2= 0;
			DFS(1,0,0);
			
			System.out.println("#"+(tc+1)+" "+ANS1+" "+ANS2);
		}
	}
	private static void DFS(int b, int c, int L) {
		if(isOk) return;
		if(L == K+1) { 
			ANS1 = b;
			ANS2 = c;
			isOk = true;
			return;
		}
		else {
			for(int i=0; i<10; i++) {
				DFS((b*i+c), b, L+1);
			}
		}
		
	}
}
