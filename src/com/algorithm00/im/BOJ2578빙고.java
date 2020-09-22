package com.algorithm00.im;

import java.util.Scanner;

public class BOJ2578빙고 {

	static int N = 5;
	static int[][] map;
	static boolean isOk;		//해당 라인이 지워졌는지 유무를 확인하기 위한 boolean변수
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int k=0; k<N*N; k++) {
			int val = sc.nextInt();			//사회자가 부른 숫자
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == val) map[i][j] = 0;		//사회자가 부른 숫자를 맵에서 지운다.
				}
			}
			
			if(k < 11) continue;			//세 개의 선의 지워지기 위해 필요한 최소 숫자 12개
			int count = 0;					//현재 지워진 라인 갯수를 체크할 함수
			/**빙고판 가로줄 검사**/
			for(int i=0; i<N; i++) {		
				isOk = true;
				for(int j=0; j<N; j++) {	//빙고판의 가로줄을 검사하여
					if(map[i][j]!=0) {		//지워졌는지 확인한다.
						isOk = false;
						break;
					}
				}
				if(isOk) count++;			//true라면 현재 줄은 지워졌다.
			}
			
			/**빙고판 세로줄 검사**/
			for(int i=0; i<N; i++) {		
				isOk = true;
				for(int j=0; j<N; j++) {	//빙고판의 세로줄을 검사하여
					if(map[j][i]!=0) {		//지워졌는지 확인한다.
						isOk = false;
						break;
					}
				}
				if(isOk) count++;			//true라면 현재 줄은 지워졌다.
			}
			
			/**빙고판 우상향 대각선 검사**/
			int[][] arr = new int[][] { { 0, 4 }, { 1, 3 }, { 2, 2 }, { 3, 1 }, { 4, 0 } };
			isOk = true;
			for(int i=0; i<arr.length; i++) {
				if(map[arr[i][0]][arr[i][1]]!=0) isOk = false;
			}
			if(isOk) count++;
			
			
			/**빙고판 좌상향 대각선 검사**/
			int[][] arr2 = new int[][] { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 } };
			isOk = true;
			for(int i=0; i<arr2.length; i++) {
				if(map[arr2[i][0]][arr2[i][1]]!=0) isOk = false;
			}
			if(isOk) count++;
			if(count >= 3) {			//3줄 이상 지워졌다면 출력 후 종료
				System.out.println(k+1);
				break;
			}
		}
	}
}
