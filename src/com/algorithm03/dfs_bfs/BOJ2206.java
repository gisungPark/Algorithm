package com.algorithm03.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2206 {

	public static class po{
		public int x, y, cnt, wall;

		public po(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}
	}
	
	static int N, M, res=Integer.MAX_VALUE;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean isOk;
	static boolean[][] isVisited;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
//		print(map);
		
		BFS(0,0);
		if(isOk) System.out.println(res);
		else System.out.println("-1");
		
	}
	private static void BFS(int x, int y) {
		
		Queue<po> q = new LinkedList<po>();
		q.add(new po(x, y, 1, map[x][y]));
		isVisited[x][y] = true;
		
		while(!q.isEmpty()) {
			po tmp = q.poll();
			for(int i=0; i<4; i++) {
				int xx = tmp.x+dx[i];
				int yy = tmp.y+dy[i];
				if(xx<0 || xx>=N || yy < 0 || yy >= M || isVisited[xx][yy]) continue;
				if(map[xx][yy] == 1 && tmp.wall >= 1) continue;
				if(xx == N-1 && yy == M-1) {
					isOk = true;
					res = Math.min(res, tmp.cnt+1);
				}
				else {
					if(map[xx][yy] == 1) q.add(new po(xx, yy, tmp.cnt+1, tmp.wall+1));
					else q.add(new po(xx, yy, tmp.cnt+1, tmp.wall));
				}
				isVisited[xx][yy] = true;
			}
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

}
