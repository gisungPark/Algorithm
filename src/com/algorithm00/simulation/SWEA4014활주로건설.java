package com.algorithm00.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4014활주로건설 {

	static int T, N, X, ANS;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		for(int tc=0; tc<T; tc++) {
			ANS = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());	//지형의 크기	
			X = Integer.parseInt(st.nextToken());	//경사로의 길이 
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				int prev = 0;
				int next = 0;
				boolean isOk = true;
				for(int j=1; j<N; j++) {
					prev = j-1;
					if(map[i][prev] == map[i][j]) continue;
					if(Math.abs(map[i][prev] - map[i][j]) == 1) {
						next = j;
						for(int k=0; k<X+1; k++) {
							if(next >= N) { isOk = false; break;}
							if(map[i][j] != map[i][next]) {isOk = false; break;}
							next++;
						}
						if(next<N) {
							if(map[i][j] != map[i][next]) {isOk = false; break;}
						}
							
					}else {
						isOk = false;
						break;
					}
				}
				if(isOk) ANS++;
				/////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////
				isOk = true;
				for(int j=1; j<N; j++) {
					prev = j-1;
					if(map[prev][i] == map[j][i]) continue;
					if(Math.abs(map[prev][i] - map[j][i]) == 1) {
						next = j;
						for(int k=0; k<X+1; k++) {
							if(next >= N) { isOk = false; break;}
							if(map[j][i] != map[next][i]) {isOk = false; break;}
							next++;
						}
						if(next<N) {
							if(map[j][i] != map[next][i]) {isOk = false; break;}
						}
					}else {
						isOk = false;
						break;
					}
				}
				if(isOk) ANS++;
			}
			
			System.out.println("#"+(tc+1)+ " " + ANS);
		}
	}
	
	public static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
}














