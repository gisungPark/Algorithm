package com.algorithm04.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA1251 {
	
	public static class Edge implements Comparable<Edge>{
		public int x, y;
		public long weight;
		public Edge(int x, int y, long weigth) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weigth;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static int T, N;
	static int[] parents;
	static double E;		// 세율
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc< T; tc++) {
			N = sc.nextInt();
			int[][] arr = new int[N][2];
			
			for(int i=0; i<N; i++) arr[i][0] = sc.nextInt();
			for(int i=0; i<N; i++) arr[i][1] = sc.nextInt();
			E = sc.nextDouble();
			
			ArrayList<Edge> edges = new ArrayList<Edge>();
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					edges.add(new Edge(i, j, distance(arr[i][0],arr[i][1],arr[j][0],arr[j][1])));
				}
			}
			
			Collections.sort(edges);
			
			parents = new int[N];
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
			int cnt = 0;
			long sum = 0;
			for(int i=0; i< edges.size(); i++) {
				if(union(edges.get(i).x,edges.get(i).y)) {
					sum+=edges.get(i).weight;
					cnt++;
				}
				if(cnt == N-1) break;
			}
			System.out.println("#"+(tc+1)+" " + Math.round(sum*E));
			
		}
	}
	
	//////두 정점사이의 거리를 구하는 함수//////////
	private static Long distance(int x1, int y1, int x2, int y2) {
		return (long) (Math.pow(x2-x1, 2)+Math.pow(y2-y1,2));
	}

	public static int find(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot== bRoot) return false;
		else {
			parents[bRoot] = aRoot;
			return  true;
		}
	}
}
