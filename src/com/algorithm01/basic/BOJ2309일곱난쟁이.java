package com.algorithm01.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309일곱난쟁이 {

	static int[] arr, sel;
	static boolean isOk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9]; 		// 9명의 난쟁이 키를 입력받을 배열
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		sel = new int[7];		//선별된 7명의 난쟁이 키를 담을 배열	
		DFS(0,0,0);				//9명의 난쟁이 중 7명을 선별한다.
	}
	private static void DFS(int L, int idx, int sum) {
		if(sum>100 || isOk) return; 	//7명의 키 합이 100을 넘는 경우는 예외처리
		if(idx == 7 ) { 	
			if(sum==100) {				//7명의 난쟁이를 선별후, 키 합이 100이면 정렬 후 출력
				Arrays.sort(sel);
				for(Integer i: sel) {
					System.out.println(i);
				}
				isOk = true;			//답이 여러개인 경우에도 한번만 출력하기 위한 boolean 변수
			}
			return;
		}
		if(L == arr.length) return;
		sel[idx] = arr[L];
		DFS(L+1, idx+1, sum+arr[L]);	//L번째 난쟁이를 선택한 경우
		DFS(L+1, idx, sum);				//L번째 난쟁이를 선택하지 않은 경우
	}

}
