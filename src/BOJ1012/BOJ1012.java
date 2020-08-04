package BOJ1012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1012 {

	static int T, N, M, K, res;		//테스트케이스 , 가로, 세로, 배추 갯수
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	public static void main(String[] args) throws IOException {
	
		System.setIn(new FileInputStream("src/BOJ1012/input1012.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			map = new int[N+1][M+1];
			res = 0;
			
			for(int i=0; i<K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			
			Queue<int[]> q = new LinkedList<int[]>(); 
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						res++;
						map[i][j] = 0;
						q.add(new int[]{i,j});
						
						while(!q.isEmpty()) {
							int[] next = new int[2];
							next = q.poll();
							for(int l=0; l<4; l++) {
								int xx = next[0]+dx[l];
								int yy = next[1]+dy[l];
								
								if(xx>=0 && xx<N && yy>=0 && yy<M) {
									if(map[xx][yy] == 1) {
										map[xx][yy] = 0;
										q.add(new int[]{xx,yy});
									}
								}
							}
						}
					}
				}
			}
		System.out.println(res);	
			
		}
	
	}

}
