package com.algorithm01.basic;

import java.util.Arrays;
import java.util.Scanner;
//////// 요리사 ////////
public class SWEA4012 {

	static int T, N, minn;
	static int[] sel,arr;
	static boolean[] isSelected;
	static int[][] map;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			arr = new int[N];
			sel = new int[N];
			isSelected = new boolean[N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			minn = 2146000000;
			for(int i=0; i<N; i++) arr[i] = i;
			
			permutation(0);
			System.out.println("#"+(tc+1)+ " " + minn);
			
		}
	}
	private static void permutation(int k) {
		if(k == N/2) {
			int[] newArr1 = new int[N/2];
			int[] newArr2 = new int[N/2];
			int a=0, b=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i] == false) newArr1[a++] = arr[i];
				else newArr2[b++] = arr[i];
			}
			
			int tmpa = 0;
			int tmpb = 0;
			for(int i=0; i<newArr1.length; i++) {
				for(int j=0; j<newArr1.length; j++) {
					if(i != j) tmpa = tmpa + map[newArr1[i]][newArr1[j]] + map[newArr1[j]][newArr1[i]];
				}
			}
			for(int i=0; i<newArr2.length; i++) {
				for(int j=0; j<newArr2.length; j++) {
					if(i != j) tmpb = tmpa + map[newArr2[i]][newArr2[j]] + map[newArr2[j]][newArr2[i]];
				}
			}
			if(Math.abs(tmpa-tmpb) < minn) minn = Math.abs(tmpa- tmpb);
			return;
		}else {
			for(int i=0; i<N; i++) {
				if(isSelected[i] == false) {
					isSelected[i] = true;
					permutation(k+1);
					isSelected[i] = false;
				}
			}
		}
		
	}

}
