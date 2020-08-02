package SWEA1210;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1210 {
	static int[] dx = {0,0,-1};
	static int[] dy = {-1,1,0};
	static int N;
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA1210/input1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0; tc<10; tc++) {
			N=sc.nextInt();
			map = new int[100][100];
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int y=0;
			for(int i=0; i<100; i++) {
				if(map[99][i] == 2)  y = i;
			}
			
			int x = 99;
			while(true) {
				if(x == 0) break;
				
				for(int i=0; i<3; i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					if(xx>=0 && xx<100 && yy>=0 && yy<100 && map[xx][yy] == 1) {
						map[x][y] = 0;
						x=xx;
						y=yy;
						break;
						
					}
				}
			}
			System.out.println("#"+N+" " + y);
		}
	}
}