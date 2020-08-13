package com.algorithm01.basic;

import java.util.Scanner;

public class SWEA8556 {
	static int T;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		sc.nextLine();
		for(int tc=0; tc<T; tc++) {
			String str = sc.nextLine();
			char[] ch = str.toCharArray();
			int west = 0, north = 0;
			int idx = 0;
			char prev = ' ';
			while(true) {
				if(ch[idx] == 'n') {
					idx+=5;
					north++;
					prev = 'n';
				}else if (ch[idx] == 'w') {
					idx+=4;
					west++;
					prev = 'w';
				}
				if(idx>=ch.length) break;
			}
			int dir = 0;
			if(prev == 'w') dir = 90;				//초기방향 설정
			
			int n = north + west;
			
			if(n == 1) {
				 System.out.println("#"+(tc+1)+ " " + dir);
			}else {
				if(prev == 'w') west--;
				else north --;
				n = (north>west)? north: west;
				dir = (int) (dir*Math.pow(2, n));
				System.out.print("#"+(tc+1)+" dir: " + dir);
				int up = 0;
				if (prev == 'w') {
					// 초기 방향+동일 방향-반대방향
					up = dir;
					if(west!=0) up = (int) (up + 90 * Math.pow(2, (n - west)));
					if(north != 0) up = (int) (up - 90 * Math.pow(2,(n - north)));

				} else {
					up = dir;
					if(west!=0) up = (int) (up - 90 * Math.pow(2, (n - west)));
					if(north != 0) up = (int) (up + 90 * Math.pow(2,(n - north)));
				}
				
				System.out.println(", up: "+up);
				while (true) {
					if (up % 2 != 0) break;
					if (n <= 0) break;
					else {
						up = up / 2;
						n--;
					}
				}
				if(n != 0) System.out.println("#" + (tc + 1) + " " + up + "/" + (n*2));
				else System.out.println("#" + (tc + 1) + " " + up );
			}
			
			
			
		}
	}
}
