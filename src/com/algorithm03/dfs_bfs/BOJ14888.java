package com.algorithm03.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;
////////연산자 끼워넣기/////////
public class BOJ14888 {

	static int N, maxx = -2146000000, minn = 2146000000;
	static int[] arr, sel, oper;
	static boolean isSelected[];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		sel = new int[N-1];		// 연산자 순열
		isSelected = new boolean[N-1];
		oper = new int[4];		// +, -, *, /
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			oper[i] = sc.nextInt();
		}
		
		permutation(0,0);
		System.out.println(maxx);
		System.out.println(minn);
	}
	private static void permutation(int idx, int k) {
		if(sel.length == k) {
			//System.out.println(Arrays.toString(sel));
			int sum = arr[0];
			for(int i=1; i<arr.length; i++) {
				switch(sel[i-1]) {		// +, -, *, /
				case 0:
					sum += arr[i];
					break;
				case 1:
					sum -= arr[i];
					break;
				case 2:
					sum *= arr[i];
					break;
				case 3:
					sum /= arr[i];
					break;
				}
			}
			if(sum > maxx) maxx = sum;
			if(minn > sum) minn = sum;
			
			return;
		}
		else {
			for(int i=0; i<4; i++) {
				if(oper[i] != 0) {
					sel[k] = i;
					oper[i]--;
					permutation(idx+1,k+1);
					oper[i]++;
				}
			}
		}
	}
}
