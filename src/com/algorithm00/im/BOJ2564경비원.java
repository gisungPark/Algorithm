package com.algorithm00.im;

import java.util.Scanner;

public class BOJ2564경비원 {

	static int r, c, N, ANS;
	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		
		c = sc.nextInt();	//블록의 가로길이
		r = sc.nextInt();	//블록의 세로길이 
		N = sc.nextInt();	//상점 수
		
		int[][] obj = new int[N+1][3];	//상점과 동근의 좌표를 저장할 변수
		for(int i=0; i<N+1; i++) {
			int pos = sc.nextInt();		//상점의 방향
			int dis = sc.nextInt();		//거리
			
			switch (pos) {
			case 1:		//북쪽에서 dis만큼 떨어져있다.
				obj[i] = new int[] { pos, 0, dis};
				break;
				
			case 2:		//남쪽에서 dis만큼 떨어져있다.
				obj[i] = new int[] {pos, r, dis};
				break;
				
			case 3:		//서쪽에서 dis만큼 떨어져있다.
				obj[i] = new int[] {pos, dis, 0};
				break;
				
			case 4:		//동쪽에서 dis만큼 떨어져있다.
				obj[i] = new int[] {pos, dis, c};
				break;
			}
		}
		
		for(int i=0; i<N; i++) {
			if ((obj[N][0] == 1 && obj[i][0] == 2) || (obj[N][0] == 2 && obj[i][0] == 1)) {
				ANS += (obj[N][2] + obj[i][2]) > ((c - obj[N][2]) + (c - obj[i][2]))
						? ((c - obj[N][2]) + (c - obj[i][2])) : (obj[N][2] + obj[i][2]);
				ANS += r;

			} else if ((obj[N][0] == 3 && obj[i][0] == 4) || (obj[N][0] == 4 && obj[i][0] == 3)) {
				ANS += (obj[N][1] + obj[i][1]) > ((r - obj[N][1]) + (r - obj[i][1]))
						? ((r - obj[N][1]) + (r - obj[i][1])) : (obj[N][1] + obj[i][1]);
				ANS += c;
				
			}else {
				ANS += (Math.abs(obj[N][1] - obj[i][1]) + Math.abs(obj[N][2] - obj[i][2]));
			}
		}
		System.out.println(ANS);
	}

}
