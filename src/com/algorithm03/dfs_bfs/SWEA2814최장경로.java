package com.algorithm03.dfs_bfs;

import java.util.Scanner;

public class SWEA2814최장경로 {

	static int T, N, M, ANS;
	static int[][] matrix;
	static boolean[] isVisited;
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			matrix = new int[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				matrix[from][to] = 1;
				matrix[to][from] = 1;
			}
			
			ANS = 0;
			for(int i=1; i<N+1; i++) {
				isVisited = new boolean[N+1];
				isVisited[i] = true;
				DFS(i, 1);
			}
			System.out.println("#"+(tc+1)+" " + ANS);
			
		}
	}
	private static void DFS(int from, int L) {
		ANS = Math.max(ANS, L);
		for(int to=1; to<N+1; to++) {
			if(!isVisited[to] && matrix[from][to] == 1) {
				isVisited[to] = true;
				DFS(to, L+1);
				isVisited[to] = false;
			}
		}
	}
}










