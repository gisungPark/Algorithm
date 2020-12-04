package com.algorithm03.dfs_bfs;

import java.util.Scanner;

public class SWEA1952수영장 {
	
	static int T, ANS;
	static int[] price, month;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			price = new int[4];
			month = new int[13];
			
			for(int i=0;i<4; i++) {
				price[i] =sc.nextInt();
			}
			
			for(int i=1; i<=12; i++) {
				month[i] = sc.nextInt();
			}
			
			// 1년 이용권 가격으로 초기화
			ANS = price[3];
			// 현재달, 현재달까지의 금액
			DFS(0, 0);
			System.out.println("#"+(tc+1)+" " + ANS);
		}
		
	}
	private static void DFS(int m, int sum) {
		if(m>=12) {
			ANS = Math.min(ANS, sum);
		}else {
			
			if(month[m+1] == 0) DFS(m+1, sum);
			else {
				int oneDay = month[m+1]*price[0];
				DFS(m+1, sum+oneDay);
				
				int oneMonth = price[1];
				DFS(m+1, sum+oneMonth);
				
				int threeMonth = price[2];
				DFS(m+3, sum+threeMonth);
			}
			
		}
	}
}
