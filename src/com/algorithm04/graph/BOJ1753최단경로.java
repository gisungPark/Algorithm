package com.algorithm04.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753최단경로 {

	static int V, E, K, INF = Integer.MAX_VALUE;
	static int[] dis;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<int[]>[] list = new ArrayList[V+1];
		
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		K = Integer.parseInt(in.readLine());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end, weight});
		}
		
		
		dis = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(dis, INF);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		//시작점 초기화
		pq.add(new int[] {K, 0});
		dis[K] = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			
			if(cnt == V) break;
			
			// 1단계. 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 선택
			int[] cur = pq.poll();
			int curidx = cur[0];
			int minWeight = cur[1];
			
			if(visited[curidx]) continue;
			visited[curidx] = true;
			cnt++;
			
			//2단계. 선택된 정점을 경유지로 하는 거리 정보 업데이트
			for(int i=0; i<list[curidx].size(); i++) {
				int[] next = list[curidx].get(i);
				if(visited[next[0]]) continue;
				dis[next[0]] = Math.min(dis[next[0]], minWeight+next[1]);
				pq.add(new int[] {next[0], dis[next[0]]});
			}
		}
		
		for(int i=1; i<V+1; i++) {
			if(dis[i] == INF) System.out.println("INF");
			else System.out.println(dis[i]);
		}
		
	}
}
