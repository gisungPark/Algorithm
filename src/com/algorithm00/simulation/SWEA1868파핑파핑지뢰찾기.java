package com.algorithm00.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1868파핑파핑지뢰찾기 {

	static int T, N;
	static char map[][];
	static boolean[][] visited;
	
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine()); 
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				String str = in.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c);
					//지뢰는 방문처리
					if(map[r][c]== '*') visited[r][c] = true;
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(visited[r][c]) continue;
					int cnt = 0;
					for(int d=0; d<8; d++) {
						int xx = r+dr[d];
						int yy = c+dc[d];
						if(xx<0 || xx>=N || yy<0 || yy>=N) continue;
						if(map[xx][yy] == '*') cnt++;
					}
					map[r][c] = (char)(cnt+'0');
				}
			}
			
			int ans = 0;
			// 지뢰 없는것 먼저 처리
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(visited[r][c]) continue;
					if(map[r][c]!='0') continue;
					visited[r][c] = true;
					ans++;
					DFS(r,c);
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(visited[r][c]) continue;
					visited[r][c] = true;
					ans++;
				}
			}
			System.out.println("#"+tc+" " +ans);
		}// end tc
		
	}// end main
	private static void DFS(int r, int c) {
		for(int d=0; d<8; d++) {
			int xx = r+dr[d];
			int yy = c+dc[d];
			if(xx<0 || xx>=N || yy<0 || yy>=N || visited[xx][yy]) continue;
			visited[xx][yy] = true;
			
			if(map[xx][yy] == '0') {
				DFS(xx,yy);
			}
		}
	}
	
}
