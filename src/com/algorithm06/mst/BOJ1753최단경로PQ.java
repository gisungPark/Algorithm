package com.algorithm06.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1753최단경로PQ {

	public static class Vertex implements Comparable<Vertex>{
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	public static int V, E;
	public static int[] dis;
	public static boolean[] isVisited;
	public static ArrayList<Vertex>[] list;
	public static void main(String[] args) throws IOException {
		
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
		isVisited = new boolean[V+1];
		dis = new int[V+1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(new Vertex(start, dis[start]));
		
		while(!pq.isEmpty()) {

			Vertex cur = pq.poll();					//1단계 : 거리가 최소인 정점
			if(isVisited[cur.no]) continue; 
			isVisited[cur.no] = true;
			
			// 2단계: 새롭게 선택된 정점으로 거리 배열을 업데이트
			for(int i=0; i<list[cur.no].size(); i++) {
				Vertex next = list[cur.no].get(i);
				if(!isVisited[next.no] && dis[next.no] > dis[cur.no]+next.weight) {
					dis[next.no] = dis[cur.no]+next.weight;
					pq.add(new Vertex(next.no, dis[next.no]) );
				}
			}
		}

		for(int i=1; i<=V; i++) {
			if(dis[i] == INF) System.out.println("INF");
			else System.out.println(dis[i]);
		}
	}
}


















