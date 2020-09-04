package com.algorithm00.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16236아기상어 {

	public static class fish{
		int x, y, size, eat = 0;

		public fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		public void update() {
			if(eat == size) {
				size++;
				eat = 0;
			}
		}

		@Override
		public String toString() {
			return "fish [x=" + x + ", y=" + y + ", size=" + size + ", eat=" + eat + "]";
		}
		
		
	}
	
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static fish shark;
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		ArrayList<fish> fishs = new ArrayList<fish>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					shark = new fish(i, j, 2);
					map[i][j] = 0;
				}
				if(map[i][j] > 0 ) fishs.add(new fish(i, j, map[i][j]));
			}
		}
		
		int time = 0;
		int minDis, minIdx;
		while(true) {
			
			int[][] dis = new int[N][N];
			Queue<int[]> q = new LinkedList<int[]>();
			dis[shark.x][shark.y] = 1;
			q.add(new int[] { shark.x, shark.y});
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				for(int k=0; k<4; k++) {
					int xx = cur[0] + dx[k];
					int yy = cur[1] + dy[k];
					if(xx<0 || xx>=N || yy<0 || yy>=N
							|| map[xx][yy] > shark.size || dis[xx][yy] != 0) continue;
					
					dis[xx][yy] = dis[cur[0]][cur[1]]+1;
					q.add(new int[] {xx,yy});
				}
			}
			
			minDis = Integer.MAX_VALUE;
			minIdx = -1;
			///////////물고기 배열 중 잡아먹을 슈 있는 가까운 물고기를 찾는다.
			for(int i=0; i<fishs.size(); i++) {
				if(fishs.get(i).size >= shark.size) continue;
				if(dis[fishs.get(i).x][fishs.get(i).y] == 0 ) continue;
				
				if(minIdx == -1) { 
					minIdx = i;
				}
				else if(dis[fishs.get(minIdx).x][fishs.get(minIdx).y] > dis[fishs.get(i).x][fishs.get(i).y]) {
					minIdx = i;
				}else if(dis[fishs.get(minIdx).x][fishs.get(minIdx).y] == dis[fishs.get(i).x][fishs.get(i).y]) {
					//최소값이 있다면 서로 비교하여 
					if(fishs.get(minIdx).x == fishs.get(i).x) {
						minIdx = (fishs.get(minIdx).y > fishs.get(i).y) ? i : minIdx; 
					}else {
						minIdx = (fishs.get(minIdx).x > fishs.get(i).x) ? i : minIdx; 
					}
					
				}
			}
			if(minIdx == -1) break;
		
			time = time + dis[fishs.get(minIdx).x][fishs.get(minIdx).y] - 1;
			map[fishs.get(minIdx).x][fishs.get(minIdx).y] = 0;
			shark.x = fishs.get(minIdx).x;
			shark.y = fishs.get(minIdx).y;
			shark.eat++;
			shark.update();
			fishs.remove(minIdx);
		}
		
		System.out.println(time);
	}
	
}






















