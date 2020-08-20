package com.algorithm01.basic;

import java.util.Scanner;

//////// 활주로 건설 ///////////
public class SWEA4014 {
	
	static int T, N, width, cnt;
	static int[] arr;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc =0; tc<T; tc++) {
			N = sc.nextInt();
			width = sc.nextInt();
			cnt = 0;

			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			print(map);
			
		
			for(int i=0; i<N; i++) {
				boolean isFail = false;
				for(int j=0; j<N-1; j++) {
					//////// 경사로 설치 //////
					if((map[i][j] - map[i][j+1]) == 1) {
						for(int k=1; k<=width; k++) {
							if(j+k+1 >= N || map[i][j+1] != map[i][j+k]) {
								isFail = true;
								break;
							}
						}
						if(isFail) break;
						else j = j + width;
						
					}else if((map[i][j+1] - map[i][j]) == 1) {
						for(int k=1; k<=width; k++) {
							if(j-k < 0 || map[i][j] != map[i][j-k]) {
								isFail = true;
								break;
							}
						}
						if(!isFail) j = j+width;
					}
				}
				if(isFail) break;
				else cnt++;
			}

			
			System.out.println(cnt);
			
			
			
			
			
			
		}
	}
	private static void print(int[][] map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}







