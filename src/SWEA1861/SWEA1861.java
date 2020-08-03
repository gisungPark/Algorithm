package SWEA1861;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SWEA1861 {
	static int T, N, resRoom, maxCnt, cnt; 
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/hw_200803/input1861.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			resRoom = -1;
			maxCnt = -1;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					DFS(i, j);
					if (maxCnt < cnt) {
						maxCnt = cnt;
						resRoom = map[i][j];
					} else if (maxCnt == cnt) {
						resRoom = (resRoom > map[i][j]) ? map[i][j] : resRoom;
					}

				}
			}
			System.out.println("#"+(tc+1)+ " " +resRoom+" "+maxCnt);
		}
	}

	private static void DFS(int x, int y) {
		for(int i=0; i<4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			
			if(xx<0 || xx>=N || yy<0 || yy>=N) continue;
			else {
				if(map[xx][yy] == map[x][y]+1) {
					cnt++;
					DFS(xx,yy);
				}
				
			}
		}
	}

}
