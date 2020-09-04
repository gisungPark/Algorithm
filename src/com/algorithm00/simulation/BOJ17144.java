package com.algorithm00.simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ17144 {
	
	static int R, C, T, ANS;
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	static int[][] map, loc;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input17144.txt"));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R][C];
		loc = new int[2][2];
		int a = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					loc[a][0] = i;
					loc[a][1] = j;
					a++;
				}
				
			}
		}
		
		for(int i=0; i<T; i++) {
			func();
			work();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) ANS += map[i][j];
			}
		}
		System.out.println(ANS);
		
	}
	/** 
	 * work() : 공기청정기 동작을 구현하기 위한 함수
	 * 공기청정기를 위아래로 나누어 공기청정기 순환방향으로 미세먼지를 한칸씩 이동시킨다.
	 **/
	private static void work() {
		// 윗쪽 공기청정기 순환을 위한 델타값
		int[] dr = { -1, 0 , 1, 0};
		int[] dc = { 0, 1, 0, -1};
		int k=0 , x = loc[0][0], y = loc[0][1];
		while(true) {
			if(k >= 4) break;
			int xx = x+dr[k];
			int yy = y+dc[k];
			if(xx<0 || xx>=loc[0][0]+1 || yy<0 || yy>=C) {
				k++;
				continue;
			}
			map[x][y] = map[xx][yy];
			x=xx;
			y=yy;
		}
		map[loc[0][0]][loc[0][1]] = -1;
		map[loc[0][0]][loc[0][1]+1] = 0;
		
		
		// 아랫쪽 공기청정기 순환을 위한 델타값
		dr = new int[] { 1, 0, -1, 0};
		dc = new int[] { 0, 1, 0, -1};
		k =0;
		x = loc[1][0];
		y = loc[1][1];
		while(true) {
			if(k >= 4) break;
			int xx = x+dr[k];
			int yy = y+dc[k];
			if(xx<loc[1][0] || xx>=R || yy<0 || yy>=C) {
				k++;
				continue;
			}
			map[x][y] = map[xx][yy];
			x=xx;
			y=yy;
		}
		map[loc[1][0]][loc[1][1]] = -1;
		map[loc[1][0]][loc[1][1]+1] = 0;
	}
	/**
	 * func() : 미세먼지의 확산을 구현한 함수
	 * (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
	 * 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
	 * 확산되는 양은 Ar,c/5이고 소수점은 버린다
	 * (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
	 */
	private static void func() {
		int[][] tmp = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					int val = map[i][j]/ 5;
					int cnt = 0;
					for(int k=0; k<4; k++) {
						int xx = i+dx[k];
						int yy = j+dy[k];
						if(xx<0 || xx>=R || yy<0 || yy>=C) continue;
						////공기청정기 위치인지 확인 
						if(xx == loc[0][0] && yy == loc[0][1]) continue;
						if(xx == loc[1][0] && yy == loc[1][1]) continue;
						
						tmp[xx][yy]+=val;
						cnt++;
					}
					map[i][j] -= val*cnt;
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] += tmp[i][j];
			}
		}
	}
	
	private static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
