package com.algorithm00.im;

import java.util.Scanner;

public class BOJ10157자리배정 {

	static int C,R,K;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		map = new int[R][C];
		
		int x = 0, y = 0, j = 0;
		if(K >R*C) System.out.println("0");
		else {
			int cnt = 1;
			while(cnt<=R*C) {
				map[x][y] = cnt;
				if(cnt == K) break;
				
				int xx = x+dr[j];
				int yy = y+dc[j];
				if(xx<0 || xx>=R || yy<0 || yy>=C
						|| map[xx][yy] != 0) {
					j++;
					j%=4;
					continue;
				}else {
					x = xx;
					y = yy;
					cnt++;
				}
			}
			System.out.println((x+1) +" " +(y+1));
		}
		
		
	
		
	}
}
