package com.algorithm00.im;

import java.util.Scanner;

public class BOJ2477참외밭 {

	static int K;
	static int[] dir;
	static int[] val;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		dir = new int[6];
		val = new int[6];
		
		int maxSqure = 0;
		int idx = 0;
		for(int i=0; i<6; i++) {
			dir[i] = sc.nextInt();
			val[i] = sc.nextInt();
		}
		
		for(int i=0; i<6; i++) {
			if(val[i]*val[(i+1)%6] > maxSqure) {
				idx = i;
				maxSqure = val[i]*val[(i+1)%6];
			}
		}
		
		int smallSqure = val[(idx+3)%6] * val[(idx+4)%6];
		
		System.out.println((maxSqure-smallSqure)*K);
		
	}
}
