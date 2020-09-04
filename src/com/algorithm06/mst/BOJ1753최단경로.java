package com.algorithm06.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1753최단경로 {

	public static class Vertex{
		int to, weight;

		public Vertex(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static int V, E;
	public static int[] dis;
	public static boolean[] isVisited;
	public static ArrayList<Vertex>[] list;
	public static void main(String[] args) throws IOException {
		
		Scanner sc =  new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); //정점의 개수
		E = Integer.parseInt(st.nextToken()); //간선의 개수
		int start = Integer.parseInt(in.readLine());

		list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			list[i] = new ArrayList<Vertex>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Vertex(to, weight));
		}
		
		final int INF = Integer.MAX_VALUE;
		dis = new int[V+1];
		isVisited = new boolean[V+1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		
		for(int c=1; c<=V; c++) {
			
			int min = INF, minVertex = -1;
			// 1단계: 거리가 최소인 정점을 구한다.
			for(int i=1; i<=V; i++) {
				if(!isVisited[i] && min > dis[i]) {
					min = dis[i];
					minVertex = i;
				}
			}
			if(minVertex == -1) break; 
			isVisited[minVertex] = true;
			
			// 2단계: 새롭게 선택된 정점으로 거리 배열을 업데이트
			for(int i=0; i<list[minVertex].size(); i++) {
				Vertex next = list[minVertex].get(i);
				if(!isVisited[next.to] && dis[next.to] > min + next.weight) {
					dis[next.to] = min + next.weight;
				}
			}
		}
		for(int i=1; i<=V; i++) {
			if(dis[i] == INF) System.out.println("INF");
			else System.out.println(dis[i]);
		}
	}
}


















