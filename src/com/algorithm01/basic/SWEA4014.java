package com.algorithm01.basic;

import java.util.Scanner;

//////// 활주로 건설 ///////////
public class SWEA4014 {
	
	static int T, N, width, cnt;
	static int[] arr;
	static int[][] map;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc =0; tc<T; tc++) {
			N = sc.nextInt();
			width = sc.nextInt();
			

			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			print(map);
			
			cnt = 0;
			for(int i=0; i<N; i++) {
				boolean isFail = false;
				isSelected = new boolean[N];
				for(int j=0; j<N-1; j++) {
					//////// 경사로 설치 //////
					if(Math.abs(map[i][j] - map[i][j+1]) > 1) {
						isFail = true;
						break;
					}else if((map[i][j] - map[i][j+1]) == 1) {
						for(int k=0; k<width; k++) {
							if(j+k+1 >= N || map[i][j+1] != map[i][j+k+1]) {
								isFail = true;
								break;
							}
						}
						if(isFail) break;
						else {
							for(int k=0; k<width; k++) {
								isSelected[j+k+1] = true;
							}
						}
						
					}else if((map[i][j+1] - map[i][j]) == 1) {
						for(int k=0; k<width; k++) {
							if(j-k < 0 || map[i][j] != map[i][j-k] || isSelected[j-k] == true) {
								isFail = true;
								break;
							}
						}
					}
					if(isFail) break;
				}
				if(!isFail) cnt++;
				
			}

			for(int j=0; j<N; j++) {
				boolean isFail = false;
				isSelected = new boolean[N];
				for(int i=0; i<N-1; i++) {
					//////// 경사로 설치 //////
					if(Math.abs(map[i][j] - map[i+1][j]) > 1) {
						isFail = true;
						break;
					}else if((map[i][j] - map[i+1][j]) == 1) {
						for(int k=0; k<width; k++) {
							if(i+k+1 >= N || map[i+1][j] != map[i+k+1][j]) {
								isFail = true;
								break;
							}
						}
						if(isFail) break;
						else {
							for(int k=0; k<width; k++) {
								isSelected[i+k+1] = true;
							}
						}
						
					}else if((map[i+1][j] - map[i][j]) == 1) {
						for(int k=0; k<width; k++) {
							if(i-k < 0 || map[i][j] != map[i-k][j] || isSelected[i-k] == true) {
								isFail = true;
								break;
							}
						}
					}
					if(isFail) break;
				}
				if(!isFail) cnt++;
				
			}
			
			System.out.println("#"+(tc+1)+ " " + cnt);
			
			
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







