package com.algorithm00.simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class SWEA5656벽돌깨기_by태희쌤2 {

	static int T, N, W, H, min;
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#"+tc+" " + min);
			
		}//end tc
	}//end main
	
	// i번째 구슬 떨어뜨리기
	private static boolean go(int count, int[][] map) {	// 던저진 구슬 갯수, 이전 구슬까지의 2차원 배열
		int result = getRemain(map);
		if(result == 0) {
			min = 0;
			return true;
		}
		if(count == N) {
			// 남아있는 벽돌의 개수 구하여 최솟값 갱신
			if(min>result) min = result;
			return false;
		}
		
		int[][] newMap = new int[H][W];
		
		// 모든 열에 떨어뜨리는 시도
		for(int c=0; c<W; c++) {
			int r = 0;
			while(r<H && map[r][c] == 0) r++;
			
			if(r==H) continue; // 벽돌이 없는 경우
			
			// 이전 구슬 상태로 배열 복사하여 초기화
			copy(map, newMap);
			// 벽돌 깨기
			boom(newMap, r, c);
			// 벽돌 내리기
			down(newMap);
			// 다음 구슬 처리
			if(go(count+1, newMap)) return true;
		}
		return false;
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		
		if(map[r][c] > 1) {
			q.add(new Point(r, c, map[r][c]));
		}
		
		map[r][c] = 0;	// 방문 처리
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.cnt == 1) continue;
			
			for(int d = 0; d<4; d++) {
				int nr = p.x, nc = p.y;
				for(int k = 1; k<p.cnt; k++) {
					nr += dx[d];
					nc += dy[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 0) {
						if(map[nr][nc] > 1) {
							q.add(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
		
	}

	private static void down(int[][] map) {
		for(int c=0; c<W; c++) {
			List<Integer> list = new ArrayList<>();
			for(int r=H-1; r>=0; r--) {
				if(map[r][c] != 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			int r = H;
			for(int b : list) {
				map[--r][c] = b;
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	private static int getRemain(int[][] map) {
		int cnt = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]>0) cnt++;
			}
		}
		return cnt;
	}
	
	public static class Point{
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
}
