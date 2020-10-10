package com.algorithm07.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {

	static int N, M;
	static int[] coin, dy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = sc.nextInt();
		}
		M = sc.nextInt();
		dy = new int[M+1];
		
		Arrays.fill(dy, 1000);
		dy[0] = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=coin[i]; j<M+1; j++) {
				int cur = j -coin[i];
				dy[j] = Math.min(dy[cur]+1, dy[j]);
			}
		}
		System.out.println(dy[M]);
		
	}

}
