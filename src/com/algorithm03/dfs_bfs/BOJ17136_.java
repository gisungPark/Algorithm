package com.algorithm03.dfs_bfs;

import java.util.Scanner;

public class BOJ17136_ {

	static int N = 10;
	static int[] paper = {5,5,5,5,5};
	static int[][] map;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		boolean isOk = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) continue;
				
				int idx = func(5,i,j);
				System.out.println("paperidx: " + idx);
				print(map);
				System.out.println();
				System.out.println();
				if(--paper[idx-1] < 0 ) {
					isOk = false;
					break;
				}
			}
			if(!isOk) break;
		}

		System.out.print("answer: ");
	
		if(!isOk) System.out.println("-1");
		else {
			int sum = 0;
			for(int i=0; i<5; i++)
				sum += paper[i];
			
			System.out.println(25-sum);
		}
	}
	
	private static int func(int size, int x, int y) {
		////// map 범위를 벗어난 경우
		if(x+size > N || y+size > N) return func(size-1, x, y);
		
		
		int sum = 0;
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				sum+=map[i][j];
			}
		}
		///////// 범위내 map값이 1이라면 색종이로 덮고 방문 처리한다. /////////
		if(sum==size*size) {
			visit(size, x, y);
			return size;
		}else {
		///////// 아니라면 색종이 크기를 줄여서 다시 시도한다. //////////
			return func(size-1, x, y);
		}
		
	}

	//////// 색종이로 덮은 이후 방문 처리하는 함수 //////////
	private static void visit(int size, int x, int y) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = 0;
			}
		}
	}

	private static void print(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
