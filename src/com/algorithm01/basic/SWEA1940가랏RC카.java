package com.algorithm01.basic;

import java.util.Scanner;

public class SWEA1940가랏RC카 {

	static int T, N;
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			N = sc.nextInt();
			int flag =0;
			int speed = 0;
			int dis = 0;
			for(int i=0; i<N; i++) {
				flag = sc.nextInt();
				if(flag!=0) {
					int v = sc.nextInt();
					if(flag==1) speed += v;
					else speed -= v;
					
					if(speed < 0) speed = 0;
				}
				dis += speed;
			}
			
			System.out.println("#"+(tc+1)+ " " + dis);
			
		}
	}
}
