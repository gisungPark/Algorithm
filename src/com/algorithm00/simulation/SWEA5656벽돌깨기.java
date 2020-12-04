package com.algorithm00.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class SWEA5656벽돌깨기 {

	static int T, N, W, H, res;
	
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
			res = Integer.MAX_VALUE;
			
			for(int i=0; i<W; i++) {
				int newMap[][] = new int[H][W];
				copy(map, newMap);
				DFS(i,0, newMap);	//모든 열에 떨어뜨리는 시도
			}
			
			System.out.println("#"+tc+" " + res);
			
		}//end tc
	}//end main
	
	private static void DFS(int col, int cnt, int copyMap[][]) {
		if(cnt == N) {
			res = Math.min(res, countBlock(copyMap));
			return;
		}else {
			//1단계. 해당열의 최상단 벽돌 깨뜨리기. 
			int x = topRowNum(col, copyMap);
		
			if(x != -1) {	// 해당 colum에 벽돌이 존재한다면,
							// 제일 상단 벽돌 삭제
				int range = copyMap[x][col];
				copyMap[x][col] = 0;
	
				//2단계. 벽돌 깬 이후 연쇄 작업
				Queue<Boom> q = new LinkedList<>();
				q.add(new Boom(x, col, range));
				
				while(!q.isEmpty()) {
					Boom b = q.poll();
					int x_ = b.x;
					int y_ = b.y;
					int ran_ = b.range;
					
					// 벽돌의 범위만큼 2차 폭발
					for(int d=0; d<4; d++) {
						int xx = x_;
						int yy = y_;
						for(int r = 0 ; r < ran_-1; r++) {
							xx = xx + dx[d];
							yy = yy + dy[d];
							if(xx<0 || xx>=H || yy<0 || yy>=W 
									|| copyMap[xx][yy] == 0) continue;
							int range_ = copyMap[xx][yy];
							copyMap[xx][yy] = 0;
							q.add(new Boom(xx, yy, range_));
						}
					}
				}//end while
				
				//3단계. 빈공간 정리
				arrangeMap(copyMap);
			}
			
			//4단계. 다음 회차 시도
			for(int i=0; i<W; i++) {
				int newMap[][] = new int[H][W];
				copy(copyMap, newMap);
				DFS(i, cnt+1, newMap);
			}
		}//end else
		
	}
	private static int countBlock(int[][] copyMap) {
		int cnt = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(copyMap[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}

	private static void arrangeMap(int[][] copyMap) {
		
		for(int j = 0; j<W; j++) {
			int cur = 0;
			int next = 0;
			for(int i=H-1; i>=0; i--) {
				if(copyMap[i][j] == 0) {
					cur = i;
					next = -1;
					for(int k=cur; k>=0; k--) {
						if(copyMap[k][j] != 0) {
							next = k;
							break;
						}
					}
					if(next != -1) {
						copyMap[cur][j] = copyMap[next][j];
						copyMap[next][j] = 0;
					}
				}
			}
		}
	}

	private static int topRowNum(int col, int[][] copyMap) {
		for(int i=0; i<H; i++) {
			if(copyMap[i][col] != 0) return i;
		}
		return -1;
	}
	
	private static void copy(int[][] origin, int[][] copy) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}
	
	public static void print(int[][] copy) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static class Boom{
		int x;
		int y;
		int range;
		
		Boom(int x, int y, int range) {
			this.x = x;
			this.y = y;
			this.range = range;
		}
		
	}
	
}
