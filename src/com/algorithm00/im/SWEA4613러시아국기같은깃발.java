package com.algorithm00.im;

import java.util.HashMap;
import java.util.Scanner;

public class SWEA4613러시아국기같은깃발 {
	
	static int T, N, M, ANS;
	static int W,B,R;
	static char[][] map;
	static HashMap<Integer, String> hash;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int tc=0; tc<T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][];
			
			for(int i=0; i<N; i++) {
				String str = sc.next();
				map[i] = str.toCharArray();
			}
			ANS = Integer.MAX_VALUE;
			W = B = R = 1;
			hash = new HashMap<Integer, String>();
			DFS(W, B, R);
			System.out.println("#" + (tc+1) + " " + ANS);
		}
	}
	private static void DFS(int w, int b, int r) {
		int tmp = w*100+b*10+r;
		if(hash.containsKey(tmp)) return;
		else hash.put(tmp, "");
		
		if((w+b+r)==N) {
			System.out.println("w: " + w + " b: " + b +" r: " + r );
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(i < w ) {
						if(map[i][j] != 'W') count++;
					}
					else if(i >= w && i < w+b) {
						if(map[i][j] != 'B') count++;
					}
					else if(i >= w+b) {
						if(map[i][j] != 'R') count++;
					}
				}
			}
//			if(ANS > count) {
				System.out.println("w: " + w + " b: " + b +" r: " + r + " count: " + count);
//			}
			ANS = Math.min(ANS, count);
			return;
		}
			
		DFS(w, b, r + 1);
		DFS(w, b + 1, r);
		DFS(w + 1, b, r);
	}
}
