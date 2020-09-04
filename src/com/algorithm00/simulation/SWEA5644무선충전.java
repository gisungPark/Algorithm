package com.algorithm00.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
1
20 3
2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
4 4 1 100
7 10 3 40
6 3 2 70

 */
public class SWEA5644무선충전 {

	public static class charge{
		int x, y, c, p;

		public charge(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		
	}
	
	static int T, N, M, A;
	static int[] p1, p2;
	static int[] dx = {0, -1, 0, 1, 0 };
	static int[] dy = {0, 0, 1, 0, -1 };
	static int[][] map;
	static charge[] charges;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			N = 11;
			M = sc.nextInt();	//이동 시간
			A = sc.nextInt();	//BC의 개수
			
			map = new int[N][N];
			p1 = new int[M];
			p2 = new int[M];
			
			for(int i=0; i<M; i++) p1[i] = sc.nextInt();
			for(int i=0; i<M; i++) p2[i] = sc.nextInt();
			
			charges = new charge[A];
			for(int i=0; i<A; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int c = sc.nextInt();		// 범위
				int p = sc.nextInt();		// 충전량
				charges[i] = new charge(x, y, c, p);
				map[x][y] = -1;	
			}
			
		
			int[] a = new int[]{1,1};
			int[] b = new int[]{10,10};
			ArrayList<Integer> list1 = new ArrayList<Integer>();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			int battery = 0;
			for(int time=0; time<M; time++) {		// 이동시간만큼
				//////////충전 
				int cnt1 = 0, cnt2 = 0;
				for(int i=0; i<A; i++) {
					if(dis(a, charges[i])) list1.add(i);
					if(dis(b, charges[i])) list2.add(i);
				}
				
				int maxA =0, maxB = 0, energy = 0;
				for(int i=0; i<list1.size(); i++) {
					maxA = Math.max(maxA, charges[list1.get(i)].p);
					for(int j=0; j<list2.size(); j++) {
						maxB = Math.max(maxB, charges[list2.get(j)].p);
						if(list1.get(i) == list2.get(j)) energy = Math.max(energy, charges[list1.get(i)].p);
						else energy = Math.max(energy, (maxA+maxB));
					}
				}
				battery += energy;
				
				/////////이동
				a[0] = a[0]+dx[p1[time]];
				a[1] = a[1]+dy[p1[time]];
				b[0] = b[0]+dx[p2[time]];
				b[1] = b[1]+dy[p2[time]];
				
			}
			
			System.out.println("#"+(tc+1)+" "+battery);
			
		}

	}
	private static boolean dis(int[] p, charge charge) {

		int distance = Math.abs(p[0] - charge.x)+Math.abs(p[1] - charge.y);
		
		if(distance <= charge.c) return true;
		return false;
		
	}

}
