package com.algorithm01.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1289원재의메모리복구하기 {

	static int T;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			
			String str = sc.next();
			char[] comp = new char[str.length()];
			char[] origin = new char[str.length()];
			Arrays.fill(comp, '0');
			origin = str.toCharArray();
			
			int cnt=0;
			for(int i=0; i<comp.length; i++) {
				if(comp[i]!=origin[i]) {
					for(int j=i; j<comp.length; j++) {
						comp[j] = origin[i];
						
					}
					cnt++;
				}
			}
			
//			System.out.println("#" +(tc+1) + " " + cnt);
		}
	}
}
