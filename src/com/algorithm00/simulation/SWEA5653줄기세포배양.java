package com.algorithm00.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA5653줄기세포배양 {

	static class cell implements Comparable<cell>{
		public int x, y;	//세포의 좌표
		public int state;	//세포의 상태	-1:사망, 0:비활성, 1:활성
		public int life, time; 	//생명력, 경과 시간
		
		public cell(int x, int y, int state, int life) {
			this.x = x;
			this.y = y;
			this.state = state;
			this.life = life;
			this.time =0;
		}
		
		public void check() {
			/*
			 * 비활성 상태에서 생명력만큼 시간이 경과하면 활성상태로 전환.
			 * */
			if(state == 0 && time == life+1) {	
				state = 1;
				time = 0;
			}
			/*
			 * 비활성 상태에서 생명력만큼 시간이 경과하면 사망.
			 * */
			else if(state == 1 && time == life+1) {
				state = -1;
				time = 0;
			}
			
		}

		@Override
		public int compareTo(cell o) {
			return Integer.compare(o.life, this.life);
		}
	}
	
	static int T, N, M, K; 	//초기 세로, 가로 크기 및 배양시간
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int tc=0; tc<T; tc++) {
			map = new int[30][30];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			ArrayList<cell> cells = new ArrayList<>();
			for(int i=10; i<N+10; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j=10; j<M+10; j++) {
					int po = Integer.parseInt(st.nextToken());
					if(po!=0) {
						map[i][j] = po;
						cells.add(new cell(i, j, 0, po));	//좌표, 상태, 라이프
					}
				}
			}
			
			int round = 0;
			while(true) {
				if(round == K) break;
				
				Collections.sort(cells);
				for(int i=0; i<cells.size(); i++) {
					cell now = cells.get(i);
					
					now.time++;
					now.check();
					if(now.state == -1) {			// 세포 사망시
						map[now.x][now.y] = -1;
						cells.remove(i);
					}
					
					if(now.state == 1 && now.time >= 1) {		//세포가 활성화 상태일 경우
						for(int k=0; k<4; k++) {
							boolean isOk = false;
							int xx = now.x + dx[k];
							int yy = now.y + dy[k];

							if(map[xx][yy] == -1) continue;		//map을 이미 죽은 세포가 차지한 경우
							if(map[xx][yy] != 0) {
								for(int j=i+1; j<cells.size(); j++) {
									cell comp = cells.get(j);
									if(comp.x == xx && comp.y == yy
											&& comp.time == 0 && comp.state == 0 ) {
										/*
										 * 동일한 자리를 두고 다른 세포들이 경쟁한다면 더 큰 세포가 차지한다.
										 */
										if(now.life> comp.life) {
											cells.remove(j);
											isOk = true;
											map[xx][yy] = now.life;
											cells.add(new cell(xx, yy, 0, now.life));
										}
									}
								}
							}

							if(!isOk) {
								map[xx][yy] = now.life;
								cells.add(new cell(xx, yy, 0, now.life));
							}
						}
					}
				}
				round++;
				/**/
				System.out.println("round: " + round);
				print();
			}
			int ANS = 0;
			for(int i=0; i<cells.size(); i++) {
				if(cells.get(i).state != -1) ANS++;
			}
			
			System.out.println("#"+(tc+1)+" " + ANS);
			
		}
	}
	
	public static void print() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
