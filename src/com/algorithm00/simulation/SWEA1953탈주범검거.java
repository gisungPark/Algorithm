package com.algorithm00.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953탈주범검거 {

	static int T, N, M, R, C, L, ANS;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map, dis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int tc = 0 ; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N =Integer.parseInt(st.nextToken());		//맵의 세로
			M =Integer.parseInt(st.nextToken());		//맵의 가로
			R =Integer.parseInt(st.nextToken());		//맨홀의 x
			C =Integer.parseInt(st.nextToken());		//맨홀의 y
			L =Integer.parseInt(st.nextToken());		//시간
			
			map = new int[N][M];
			dis = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<int[]> q = new LinkedList<>();
			dis[R][C] = 1;
			q.add(new int[]{R, C});
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				if(dis[x][y] > L) break;

				for(int k=0; k<4; k++) {
					int xx = x+dx[k];
					int yy = y+dy[k];
					if(xx<0 || xx>=N || yy<0 || yy>=M 
							|| dis[xx][yy] != 0 || map[xx][yy] == 0) continue;
					
					int now = map[x][y];
					int next = map[xx][yy];
					switch(k) {
					case 0:	//위
						if(now == 3 || now == 5 || now == 6 ) continue;
						if(next == 3 || next == 4 || next == 7) continue;
						break;
					case 1:	//아래
						if(now == 3 || now == 4 || now == 7 ) continue;
						if(next == 3 || next == 5 || next == 6 ) continue;
						break;
					case 2:	//왼쪽
						if(now == 2 || now == 4 || now == 5) continue;
						if(next == 2 || next == 6 || next == 7) continue;
						break;
					case 3:	//오른쪽
						if(now == 2 || now == 6 || now == 7) continue;
						if(next == 2 || next == 4 || next == 5) continue;
						break;
					}
					
					q.add(new int[] {xx,yy});
					dis[xx][yy] = dis[x][y]+1;
				}
			}
			ANS = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(dis[i][j]>0 && dis[i][j] <= L) ANS++;
				}
			}
			
			System.out.println("#"+(tc+1)+ " "+ ANS);
		
		}
	}
	
	

	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
