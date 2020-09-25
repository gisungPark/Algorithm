package com.algorithm00.im;

import java.util.Scanner;

public class BOJ10158개미 {

	static int R,C ,x,y,T;
	static int[] dr = {1, -1};
	static int[] dc = {1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		T = sc.nextInt();

		int cnt=1, k=0;
		while(cnt <= T) {
			System.out.println(x+" " + y);
			int xx = x+dr[k];
			int yy = y+dc[k];
			if(xx<0 || xx>=R+1 || yy<0 || yy>=C+1) {
				k++;
				k%=2;
				continue;
			}else {
				x = xx;
				y = yy;
				cnt++;
			}
		}
		System.out.println(x+ " "+ y);
				
	}
}
