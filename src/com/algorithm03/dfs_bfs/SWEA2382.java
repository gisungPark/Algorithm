package com.algorithm03.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA2382 {
	/////////미생물 클래스 ///////////
	static class mi{	
		int x, y, count;	//x, y, 미생물 수
		int dir;		// 상하좌우 : 1234
		public mi(int x, int y, int count, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
		}

	}
	
	
	static int T, N, M, K;		//테스트케이스, 셀의 개수, 격리시간, 군집의 개수
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc =0; tc<T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			
			ArrayList<mi> list = new ArrayList<SWEA2382.mi>();
			Queue<mi> q = new LinkedList<SWEA2382.mi>();
			
			
			for(int i=0; i<K; i++) {
				int x_ = sc.nextInt();
				int y_ = sc.nextInt();
				int count_ = sc.nextInt();
				int dir_ = sc.nextInt();
				list.add(new mi(x_, y_, count_, dir_));
			}
			
			int round = 0;
			while(true) {
				for(int i=0; i<list.size(); i++) {	
					////////// 미생물 군집 큐에 삽입 ///////////////
					q.add(list.get(i));				
				}
				int idx = -1;
				while(!q.isEmpty()) {
					++idx;
					mi tmp = q.poll();
					if(tmp.dir == 1) tmp.x--;
					else if(tmp.dir == 2) tmp.x++;
					else if(tmp.dir == 3) tmp.y--;
					else if(tmp.dir == 4) tmp.y++;
					
					//////// 맵 가장자리 처리 ////////
					if(tmp.x == 0 || tmp.x == N-1 || tmp.y == 0 || tmp.y ==N-1) {
						tmp.count = tmp.count/2;
						if(tmp.count <= 0) list.remove(idx);
						else {
							if(tmp.dir == 1) tmp.dir = 2;
							else if(tmp.dir == 2) tmp.dir = 1;
							else if(tmp.dir == 3) tmp.dir = 4;
							else if(tmp.dir == 4) tmp.dir = 3;
						}
					}
					
				}
				
				for(int i=0; i<list.size(); i++) {
					for(int j=0; j<list.size(); j++) {
						if(i != j) {
							if(list.get(i).x == list.get(j).x 
									&& list.get(i).y == list.get(j).y) {
								if(list.get(i).count > list.get(j).count) {
									list.get(j).dir = list.get(i).dir;
								}else {
									list.get(i).dir = list.get(j).dir;
								}
							}
						}
					}
				}
				
				for(int i=0; i<list.size(); i++) {
					for(int j=0; j<list.size(); j++) {
						if(i != j) {
							if(list.get(i).x == list.get(j).x 
									&& list.get(i).y == list.get(j).y) {
								if(list.get(i).count > list.get(j).count) {
									list.get(i).count += list.get(j).count;
									list.remove(j);
								}else {
									list.get(j).count += list.get(i).count;
									list.remove(i);
								}
								K--;
							}
						}
					}
				}
				if(++round == M) break;
			}
			
			int sum = 0;
			for(int i=0; i<list.size(); i++) {
				sum += list.get(i).count;
			}
			System.out.println("#" +(tc+1)+" " + sum);
			
		}
	}
}

















