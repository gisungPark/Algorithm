package com.algorithm03.dfs_bfs;

import java.util.Scanner;

///////////BOJ3085 사탕게임 /////////////
public class BOJ3085 {

	static int N, ANS = -1;
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		map = new char[N][];
		
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			map[i] = str.toCharArray();
		}
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int xx = i;
				int yy = j;
				for(int k=0; k<2; k++) {
					xx = i+dx[k];
					yy = j+dy[k];
					if(xx<0 || xx>=N || yy<0 || yy>=N
							|| map[i][j] == map[xx][yy]) continue;
					swap(i, j, xx, yy);
					for(int r=0; r<N; r++) {
						for(int c=0; c<N; c++) {
							DFS(r,c,map[r][c]);
						}
					}
					swap(xx,yy,i,j);
				}
			}
		}
		System.out.println(ANS);

	}
	private static void DFS(int i, int j, char c) {
		for(int k=0; k<2; k++) {
			int xx = i, yy = j, cnt = 0;
			do{
				xx = xx+dx[k];
				yy = yy+dy[k];
				if(xx<0 || xx>=N || yy<0 || yy>=N
						|| map[xx][yy] != c) break;
				//////////같을 경우 전진 ////////
			}while(map[xx][yy] == c);
			
			do {
				xx = xx - dx[k];
				yy = yy - dy[k];
				if(xx<0 || xx>=N || yy<0 || yy>=N
						|| map[xx][yy] != c) break;
				cnt++;
			}while(map[xx][yy] == c);
			ANS = Math.max(ANS, cnt);
		}
	}
	private static void swap(int i, int j, int xx, int yy) {
		char tmp = map[i][j];
		map[i][j] = map[xx][yy];
		map[xx][yy] = tmp;
	}
	private static void print(char[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
