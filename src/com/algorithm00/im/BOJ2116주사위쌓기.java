package com.algorithm00.im;

import java.util.Scanner;

public class BOJ2116주사위쌓기 {

	static int N, ANS;
	static int[][] dice;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dice = new int[N][6];
		for(int i=0; i<N; i++) {
			for(int j=0; j<6; j++) {
				dice[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<6; i++) {
			int[] arr = new int[7];
			int idx = i;
			for(int j=0; j<N; j++) {
				arr[dice[j][idx]]++;
				arr[dice[j][check(idx)]]++;
				idx = check(idx);
			}
			
			int sum = 0, cnt = N;
			for(int j=6; j>=1; j--){
				if((N-arr[j]) >= cnt) {
					sum += j*cnt;
					cnt = 0;
				}else {
					sum += (N-arr[j])*j;
					cnt -= (N-arr[j]);
				}
				if(cnt == 0) break;
			}
			ANS = Math.max(ANS, sum);
		}
		System.out.println(ANS);
	}
	private static int check(int v) {

		if(v==0) return 5;
		if(v==1) return 3;
		if(v==2) return 4;
		if(v==3) return 1;
		if(v==4) return 2;
		if(v==5) return 0;
		return -1;
	}
}
