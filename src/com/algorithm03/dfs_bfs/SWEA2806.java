package com.algorithm03.dfs_bfs;

import java.util.Scanner;

//////////// BOJ9663. N-Queen /////////
public class SWEA2806 {
	
	static int T, N, ANS;
	static int[] rowNum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			N = sc.nextInt();
			rowNum = new int[N];
			
			ANS = 0;
			Queen(0);
			System.out.println("#"+(tc+1)+ " " +ANS);
		}
	}

	private static void Queen(int row) {
		if(row == N) {
			++ANS;
			return;
		}
		for(int i=0; i<N; i++) {
			if(check(row,i)) {
				rowNum[row] = i;
				Queen(row+1);
			}
		}
	}

	private static boolean check(int row, int idx) {
		for(int i=0; i<row; i++) {
			if(rowNum[i] == idx
					|| Math.abs(rowNum[i]-idx) == (row-i)) return false;
		}
		return true;
	}
}
