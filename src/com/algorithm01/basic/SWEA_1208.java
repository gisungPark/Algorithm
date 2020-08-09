package com.algorithm01.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {

	public static void main(String[] args) throws FileNotFoundException {

		//System.setIn(new FileInputStream("src/com/ssafy/im/input_1208.txt"));
		Scanner sc = new Scanner(System.in);
		
		int[] map = new int[100];
		
		for(int tc=0; tc<10; tc++) {
			int dump = sc.nextInt();
			for(int i=0; i<100; i++ ) {
				map[i] = sc.nextInt();
			}
			
			for(int i=0; i<dump; i++) {
				Arrays.sort(map);
				map[0]++;
				map[99]--;
			}
			
			Arrays.sort(map);
			System.out.println("#"+(tc+1) +" " + (map[99]-map[0]));
		}
	}

	private static void print(int[] map) {
		// TODO Auto-generated method stub
		for(int i=0; i<map.length; i++) {
			System.out.print(map[i] +" ");
		}
		System.out.println();
	}
}
