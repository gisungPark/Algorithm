package com.algorithm03.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ17136 {

	static int N = 10, ANS = Integer.MAX_VALUE;
	static int[] paper = {5,5,5,5,5};
	static int[][] map;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		DFS(0,0,0);
		
		if(ANS == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ANS);
	}
	
	private static void DFS(int x, int y, int cnt) {	
		if(cnt > ANS || cnt > 25 ) return;
		
		for (int i = x; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				for(int k=5; k>=1; k--) {
					//////////// k크기만큼 1로 채워진 2차원 배열이 존재하는지 확인 
					if(check(k,i,j)) {
						if(paper[k-1] <= 0) continue;
						--paper[k-1];
						visit(k, i, j, 0);	//해당 영역을 0로 변경하여 방문처리 한다.
						System.out.print(Arrays.toString(paper)+" cnt:"+ cnt+" ANS: "+ANS+"\n");
						print(map);
						System.out.println();
						DFS(i,0,cnt+1);
						++paper[k-1];
						visit(k, i, j, 1);
					}
				}
			}
		}
		
//		if(i== N-1 && j == N-1) ANS = Math.min(cnt, ANS);
	}

	//////// 색종이 크기 만큼 맵을 확인 //////////
	private static boolean check(int size, int x, int y) {
		if(x+size > N || y+size > N) return false;
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(map[i][j] == 0) return false; 
			}
		}
		return true;
	}

	//////// 색종이로 덮은 이후 방문 처리하는 함수 //////////
	private static void visit(int size, int x, int y, int flag) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = flag;
			}
		}
	}
	private static void print(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	
}
