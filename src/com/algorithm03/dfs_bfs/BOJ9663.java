package com.algorithm03.dfs_bfs;

import java.util.Scanner;

//////////// BOJ9663. N-Queen /////////
public class BOJ9663 {
	
	static int N, ANS;
	static int[] rowNum;		// 각 행의 퀸 위치를 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		rowNum = new int[N];
		
		Queen(0);
		System.out.println(ANS);
	}

	// 퀸을 현재 행(rowNo)에 놓기
	private static void Queen(int rowNo) {
		if(rowNo == N) {
			++ANS;
			return;
		}
		for(int i=0; i<N; i++) {
			if(check(rowNo,i)) {
				rowNum[rowNo] = i;
				Queen(rowNo+1);
			}
		}
	}
	
//		1,1				1,5
//			2,2		2,4
//				3,3
//			4,2		4,4
//		5,1				5,5
//	행차이와 열차이가 같으면 대각선이다.
	
	
	
	// rowNo행의 i열에 퀸을 놓는게 가능한지 체크 : 놓을 수 있다면 true, 놓을 수 없다면 false
	private static boolean check(int rowNo, int idx) {
		for(int i=0; i<rowNo; i++) {
			
//			rowNum[i] == idx : 같은 열 체크
//			Math.abs(rowNum[i]-idx) == (rowNo-i) : 대각선 체크
			if(rowNum[i] == idx
					|| Math.abs(rowNum[i]-idx) == (rowNo-i)) return false;
		}
		return true;
	}
}
