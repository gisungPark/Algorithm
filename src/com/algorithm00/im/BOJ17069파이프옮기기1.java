package com.algorithm00.im;

import java.util.Scanner;

public class BOJ17069파이프옮기기1 {

	static int N,ANS;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int [N+2][N+2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		DFS(0,0,1);
		System.out.println(ANS);
	}
	private static void DFS(int state, int r, int c) {
//		System.out.println(r+", " + c);
		if(r==N-1 && c==N-1) {
			ANS++;
			return;
		}
		
		if(state == 0) {
			for(int i=0; i<2; i++) {
				int xx = r + dr[i];
				int yy = c + dc[i];
				if(xx>=0 && xx<N && yy>=0 && yy<N && check(i, r, c)) {
					DFS(i, xx, yy);
				}
			}
			
		}else if(state == 1) {
			for(int i=0; i<3; i++) {
				int xx = r + dr[i];
				int yy = c + dc[i];
				if(xx>=0 && xx<N && yy>=0 && yy<N && check(i, r, c)) {
					DFS(i, xx, yy);
				}
			}
		}else if(state == 2) {
			for(int i=1; i<3; i++) {
				int xx = r + dr[i];
				int yy = c + dc[i];
				if(xx>=0 && xx<N && yy>=0 && yy<N && check(i, r, c)) {
					DFS(i, xx, yy);
				}
			}
		}
	}
	private static boolean check(int state, int r, int c) {
		
		if(state == 2 ) { 
			if(r+1<N && map[r+1][c]==0) return true;
		}else if(state == 1){
			if(r+1<N && c+1<N 
					&& map[r+1][c] == 0 && map[r+1][c+1] == 0 && map[r][c+1] ==0)
				return true;
		}else if(state == 0) {
			if(c+1<N && map[r][c+1] == 0) return true;
			
		}
		return false;
	}
	
}
