package com.algorithm04.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

output==> 8
*/

public class 다익스트라 {
	
	static int N, INF = Integer.MAX_VALUE;
	static int[] dis;
	static int[][] matrix;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		matrix = new int[N][N];
		dis = new int[N];
		visited = new boolean[N];
		Arrays.fill(dis, INF);
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dis[0] = 0;
		int min = 0;
		int current = 0;
		while(true) {
			min = INF;
			// 1단계. 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 선택
			for(int i=0; i<N; i++) {
				if(visited[i]) continue;
				if(min > dis[i]) {
					// 최소인 정점 정보를 저장
					min = dis[i];
					current = i;
				}
			}
			
			visited[current] = true;
			if(current == N-1) break;
			
			//2단계. 선택된 정점을 경유지로 하는 거리 정보 업데이트
			for(int i=0; i<N; i++) {
				if(visited[i] || matrix[current][i] == 0) continue;
				// min => dis[current]
				dis[i] = Math.min(dis[i], matrix[current][i] + min);
			}
		}
		
		System.out.println(dis[N-1]);
	
	}

}





/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

output==> 8

4
0 94 53 16
79 0 24 18
91 80 0 98
26 51 92 0
output==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

output==> 14
 */
