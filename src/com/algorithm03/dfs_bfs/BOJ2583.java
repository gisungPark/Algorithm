package com.algorithm03.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2583 {

	static int N, M, K, cnt;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		
		
		for(int i=0; i<K; i++) {
			int c1 = sc.nextInt();			// 가로
			int r1 = sc.nextInt();			// 세로
			int c2 = sc.nextInt();			// 가로
			int r2 = sc.nextInt();			// 세로
			draw(c1, r1, c2, r2);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int idx=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) continue;
				cnt = 0;
				DFS(i,j);
				print(map);
				System.out.println();
				list.add(idx++, cnt);
			}
		}
		
		System.out.println(idx);
		Collections.sort(list);
		for(int i=0; i<idx; i++)
			System.out.print(list.get(i)+" ");
		
		
	}
	private static void DFS(int i, int j ){
		map[i][j] = 1;
		cnt++;
		for(int k=0; k<4; k++) {
			int xx = i+dx[k];
			int yy = j+dy[k];
			if(xx<0 || xx>=N || yy<0 || yy>=M
					|| map[xx][yy] != 0) continue;
			DFS(xx,yy);
		}
	}
	private static void print(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void draw(int c1, int r1, int c2, int r2) {
							// 0, 2, 4, 4
		for(int i=r1; i<r2; i++) {
			for(int j=c1; j<c2; j++) {
				map[i][j] = 2;
			}
		}
		
	}
}













