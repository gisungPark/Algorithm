package com.algorithm01.basic;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ18868멀티버스1 {

	static int M, N;
	static int[][] arr;
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src/com/algorithm01/basic/intput18868.txt"));
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int [M+2][N+2];
		
		for(int i=1; i<M+1; i++) {
			for(int j=1; j<N+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<M; i++) {
			if(arr[i][0] != 0) continue; 
			for(int j=i+1; j<M+1; j++) {
				if(arr[j][0]!=0) continue;
				boolean isOk = true;
				
				for(int k=1; k<N; k++) {
					for(int l=k+1; l<N+1; l++) {
						if((arr[i][k] < arr[i][l] && arr[j][k] < arr[j][l]) 
								|| (arr[i][k] > arr[i][l] && arr[j][k] > arr[j][l])
								|| (arr[i][k] == arr[i][l] && arr[j][k] == arr[j][l])) {
							continue;
						}else {
							isOk = false;
							break;
						}
					}
					if(!isOk) break;
				}
				if(isOk) {
					arr[i][0] = i;
					arr[j][0] = i;
				}
			}
		}
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for(int i=1; i<M+1; i++) {
			hash.put(arr[i][0], arr[i][0]);
		}
		
		System.out.println(hash.size()-1);
	}
}
