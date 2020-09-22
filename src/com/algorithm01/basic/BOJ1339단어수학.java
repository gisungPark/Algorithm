package com.algorithm01.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1339단어수학 {

	static int N;
	static int[] arr;
	static String[] words;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		words = new String[N];
		arr = new int[26];
		for(int i=0; i<N; i++) {
			words[i] = sc.next();
			int length = words[i].length();
			for(int j=0; j<length; j++) {		//AAA			[111,0, 0, 0,              ]
				int pos = length-(j+1);			//ABA			[101, 10 ,
				arr[words[i].charAt(j) -'A'] += (int)Math.pow(10,pos);
			}
		}
		Arrays.sort(arr);
		int weight = 9;
		int ANS = 0;
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i] == 0) break;
			ANS += arr[i]*weight--;
		}
		
		System.out.println(ANS);
		
	}
}
