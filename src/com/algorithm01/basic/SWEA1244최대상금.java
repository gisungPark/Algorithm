package com.algorithm01.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
1
777770 5
 ======= 
1
32888 2

*/
public class SWEA1244최대상금{
	
	static int T, N, ANS;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			list = new ArrayList<>();
			String tmp = sc.next();
			N = sc.nextInt();
			
			for(int i=0; i<tmp.length(); i++) {
				list.add(tmp.charAt(i)-'0');
			}
			ANS = Integer.MIN_VALUE;
			DFS(0);
			
			System.out.println("#"+(tc+1)+" " + ANS);
		}
	}
	private static void DFS(int L) {
		if(L == N) {
			int tmp = 0;
			for(int i=0; i<list.size(); i++) {
				tmp+=list.get(i)*Math.pow(10, (list.size()-1-i));
			}
			ANS = Math.max(ANS, tmp);
			return;
		}
		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				swap(i,j);
				DFS(L+1);
				swap(j,i);
			}
		}
		
	}
	private static void swap(int first, int second) {
		int tmp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, tmp);
	}
	
}


















