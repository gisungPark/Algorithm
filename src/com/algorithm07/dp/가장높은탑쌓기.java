package com.algorithm07.dp;

import java.util.Scanner;

public class 가장높은탑쌓기 {
	
	public static class block{
		int width, height, weight;

		public block(int width, int height, int weight) {
			this.width = width;
			this.height = height;
			this.weight = weight;
		}
	}
	
	static int N;
	static int[] dy;
	static block[] blocks;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dy = new int[N];
		blocks = new block[N]; 
		for(int i=0; i<N; i++) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			int weight = sc.nextInt();
			
			blocks[i] = new block(width, height, weight);
			dy[i] = height;
		}
		
		for(int i=1; i<N; i++) {
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				if(blocks[i].width <= blocks[j].width
						&& blocks[i].weight <= blocks[j].weight) {
//					dy[i] = Math.max(dy[i], dy[j]+1);
					max = Math.max(max, dy[j]);
				}
			}
			dy[i] += max;
		}
		
		int ANS = 0;
		for(int i=0; i<N; i++) {
			ANS = Math.max(ANS, dy[i]);
		}
		System.out.println(ANS);
	}

}
