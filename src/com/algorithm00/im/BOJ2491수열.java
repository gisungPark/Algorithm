package com.algorithm00.im;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2491수열 {

	static int N, ANS;
	static int[] arr, lt, gt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];	//수열을 저장할 배열
		lt = new int[N];	//현재위치까지 연속해서 작아지는 길이
		gt= new int[N];		//현재위치까지 연속해서 커지는 길이
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			lt[i] = 1;
			gt[i] = 1;
		}
		
		for(int i=1; i<N; i++) {
			if(arr[i] >= arr[i-1]) gt[i] += gt[i-1];	//이전원소보다 커졌다면 커지는 길이를 1증가
			if(arr[i] <= arr[i-1]) lt[i] += lt[i-1];	//이전원소보다 작아다면 작아지는 길이를 1증가
		}
		
		for(int i=0; i<N; i++) {
			ANS = Math.max(ANS, gt[i]);
			ANS = Math.max(ANS, lt[i]);
		}
		
		System.out.println(ANS);
	}
}
