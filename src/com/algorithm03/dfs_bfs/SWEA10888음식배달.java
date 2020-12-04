package com.algorithm03.dfs_bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA10888음식배달 {

	static int T, N, ANS;
	static int[][] map;
	static List<int[]> hs, pz;
	static boolean[] selected; 
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc =0; tc<T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			hs = new ArrayList<>();
			pz = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1) hs.add(new int[] {i, j});
					else if(map[i][j] >= 2) pz.add(new int[] {i, j});
				}
			}

			ANS = Integer.MAX_VALUE;
			selected = new boolean[pz.size()];
			powerSet(0);
			System.out.println("#"+(tc+1) + " " + ANS);
		}
	}
	private static void powerSet(int idx) {
		if(idx == pz.size()) {
			int sum = 0;
			int cnt = 0;
			
			for(int j=0; j<pz.size(); j++) {
				if(selected[j]) {
					int x = pz.get(j)[0];
					int y = pz.get(j)[1];
					sum += map[x][y];
					cnt++;
				}
			}
			if(cnt == 0) return;
			
			
			for(int i=0; i<hs.size(); i++) {
				int x1 = hs.get(i)[0];
				int y1 = hs.get(i)[1];
				int dis = Integer.MAX_VALUE;
				
				for(int j=0; j<pz.size(); j++) {
					if(selected[j]) {
						int x2 = pz.get(j)[0];
						int y2 = pz.get(j)[1];
						dis = Math.min(dis,  Math.abs(x1-x2) + Math.abs(y1-y2));
					}
				}
				sum += dis;
			}
			
			ANS = Math.min(ANS, sum);
			
		}else {
			selected[idx] = true;
			powerSet(idx+1);
			selected[idx] = false;
			powerSet(idx+1);
		}
		
	}
	public static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}










