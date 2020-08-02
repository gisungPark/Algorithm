package SWEA_4615;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_4615 {
	static int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static int[] dy = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int T, N, M;
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("src/SWEA_4615/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int tc =0; tc<T; tc++) {
			N = sc.nextInt();	//보드 한 변의 길이
			M = sc.nextInt();	//돌을 놓는 횟수
			
			map = new int[N][N];
			int mid = N/2;
			
			map[mid][mid] = 2;		//백돌:2 
			map[mid-1][mid-1] = 2;	//흑돌:1
			map[mid-1][mid] = 1;
			map[mid][mid-1] = 1;

			
			int color = 0, x = 0, y = 0, cnt = 0;
			int x_ = 0, y_ = 0;
			for(int i=0; i<M; i++) {
				x = sc.nextInt()-1;
				y = sc.nextInt()-1;
				color = sc.nextInt();
				map[x][y] = color;
				
				for(int j=0; j<8; j++) {
					x_ = x;
					y_ = y;
					
					boolean isCatch = false;
					cnt = 0;
					while(true) {
						int xx = x_+dx[j];
						int yy = y_+dy[j];
						
						if(xx<0 || xx >=N || yy<0 || yy>=N) break;
						if(map[xx][yy] == 0) break;			//공백을 만날 경우 
						if(map[xx][yy] != color) {			//다른 색의 돌을 만날 경우 계속 진행
							x_ = xx;
							y_ = yy;
							cnt++;
						}else {			//같은 색의 돌을 만나면 잡는다.
							isCatch = true;
							x_ = xx;
							y_ = yy;
							cnt++;
							//System.out.println("xx:"+x_+", yy:"+y_);
							//print(map);
							break;	//잡은 경우
							
						}
					}
					if(isCatch) {
						//잡은 경우 
						for(int k=0; k<cnt; k++) {
							map[x_][y_] = color;
							x_ = x_ - dx[j];
							y_ = y_ - dy[j];
							
						}
					}
				}
			}
			
			int cnt1 = 0, cnt2 = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) cnt1++;
					else if(map[i][j] == 2) cnt2++;
				}
			}
			System.out.println("#" + (tc + 1) + " " + cnt1 + " " + cnt2);

		}
	}
	private static void print(int[][] map) {
		// TODO Auto-generated method stub
	
		for(int i=0; i<map[0].length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("======================");
		System.out.println();
	}
}
