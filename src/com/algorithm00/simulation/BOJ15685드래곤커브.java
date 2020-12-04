package com.algorithm00.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15685드래곤커브 {
	
	static int N;
	static int R, C, dir, gen;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[102][102];
		visited = new boolean[102][102];
		for(int i=0; i<N; i++) {
			int x_ = sc.nextInt();
			int y_ = sc.nextInt();
			int dir_ = sc.nextInt();
			int gen_ = sc.nextInt();
			visited[y_][x_] = true;

			List<Integer> list = new ArrayList<>();
			list.add(dir_);
			
			for(int j=0; j<gen_; j++) {
				for(int k=list.size()-1; k>=0; k--) {
					list.add((list.get(k)+1)%4);
				}
			}
			for(int j=0; j<list.size(); j++) {
				int ny = y_ + dy[list.get(j)];
				int nx = x_ + dx[list.get(j)];
				if(ny<0 || ny>=100 || nx<0 || ny>=100) continue;
				visited[ny][nx] = true;
				
				y_ = ny;
				x_ = nx;
			}
			
		}
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(visited[i][j] && visited[i+1][j]
						&& visited[i][j+1] && visited[i+1][j+1]) 
					cnt++;
			}
		}
		System.out.println(cnt);
		
			
		
		
	}// end main

}
