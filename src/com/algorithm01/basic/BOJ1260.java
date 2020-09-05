package com.algorithm01.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
	static int N, M;
	static boolean map[][];
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i< M; i++) {
			int from  = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = map[to][from] = true;
		}
		
		DFS(start);
		System.out.println();
		BFS(start);
		
	}
	
	
	private static void BFS(int s) {
		boolean[] v = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		v[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			int next = q.poll();
			System.out.print(next+" ");
			for(int i=0; i<=N; i++) {
				if(map[next][i]
						&& !v[i]) {
					q.add(i);
					v[i] = true;
				}
			}
		}
	}
	
	
	private static void DFS(int current) {
		visited[current] = true;
		System.out.print(current+ " ");
			
		for(int i=0; i<=N; i++){
			if(map[current][i]
					&& !visited[i]) 
				DFS(i);
		}
	}
	
}
