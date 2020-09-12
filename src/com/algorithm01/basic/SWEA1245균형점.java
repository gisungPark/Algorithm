package com.algorithm01.basic;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1245균형점 {

	public static class point implements Comparable<point>{
		public int x, m;

		public point(int x, int m) {
			this.x = x;
			this.m = m;
		}
		
		@Override
		public int compareTo(point o) {
			return Integer.compare(this.x, o.x);
		}
	}
	
	static int T, N;
	static double ANS;
	static point[] po;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			N = sc.nextInt();
			po = new point[N];
			
			for(int i=0; i<N; i++) {
				po[i] = new point(0, 0);
			}
			for(int i=0; i<N; i++) {
				po[i].x =sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				po[i].m =sc.nextInt();
			}
			
			Arrays.sort(po);
			
			System.out.print("#"+(tc+1));
			for(int i=0; i<N-1; i++) {
				double left = po[i].x;
				double right = po[i+1].x;
				System.out.printf(" %.10f", DFS(left, right, 0));
			}
			System.out.println();
			
		}
	}
	private static double DFS(double left, double right, int L) {
		double mid = (left+right)/2;
		if(L == 100) return mid;
		double prev = 0, next = 0; 
		for(int i=0; i<N; i++) {
			double dis = (double)(po[i].x-mid);		//거리
			if(po[i].x <mid) {
				prev += po[i].m/Math.pow(dis, 2); 
			}
			else if(po[i].x > mid) {
				next += po[i].m/Math.pow(dis, 2); 
			}
		}
		
		if(prev == next) return mid;
		else if(prev>next) {
			left = mid;
			return DFS(left, right, L+1);
		}
		else {
			right = mid;
			return DFS(left, right, L+1);
		}
	}
		
}
