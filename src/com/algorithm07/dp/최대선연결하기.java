package com.algorithm07.dp;

import java.util.Scanner;

public class 최대선연결하기 {

	static int N;
	static int[] arr, dy;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dy = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			dy[i] = 1;
		}
		
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i]) {
					dy[i] = Math.max(dy[i], dy[j]+1);
				}
			}
		}
		
		int ANS = 0;
		for(int i=0; i<N; i++) {
			ANS = Math.max(ANS, dy[i]);
		}
		System.out.println(ANS);
		
	}
}
