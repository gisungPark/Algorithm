package com.algorithm07.dp;

import java.util.Scanner;

public class 가방문제_냅색알고리즘 {

	static int N, val;
	static int[] dy;
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in); 
		N = sc.nextInt();
		val = sc.nextInt();
		dy = new int[val+1];
		int[][] gold = new int[N][2];
		for(int i=0; i<N; i++) {
			int weight = sc.nextInt();
			int price = sc.nextInt();
			gold[i] = new int[] {weight, price};
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=gold[i][0]; j<val+1; j++) {
				int cur = j - gold[i][0];
				if(cur < 0) continue;
				dy[j] = Math.max(dy[cur] + gold[i][1], dy[j]);
			}
		}
		
		System.out.println(dy[val]);
		
	}
}
