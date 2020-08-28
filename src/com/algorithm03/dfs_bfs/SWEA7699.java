package com.algorithm03.dfs_bfs;

import java.util.Scanner;

public class SWEA7699 {

	static int T, R, C, ANS;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[] isVisited;
	static char[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc= 0 ; tc<T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			sc.nextLine();
			
			map = new char[R][];
			isVisited = new boolean[26];
			for(int i=0; i<R; i++) {
				map[i] = sc.nextLine().toCharArray();
			}
			
			isVisited[map[0][0]-'A'] = true;
			ANS = -1;
			DFS(0,0,1);
			
			System.out.println("#" + (tc+1)+" " + ANS);
		}
		
	}
	private static void DFS(int x, int y, int cnt) {
		
		if(cnt>ANS) ANS = cnt;
		
		for(int k=0; k<4; k++) {
			int xx = x+dx[k];
			int yy = y+dy[k];
			if(xx<0 || xx>=R || yy<0 || yy>=C
					||isVisited[map[xx][yy]-'A'] == true) continue;
			isVisited[map[xx][yy]-'A'] = true;
			DFS(xx,yy, cnt+1);
			isVisited[map[xx][yy]-'A'] = false;
		}
		
	}
	private static void print(char[][] map) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
	
		}
	}
	
}
