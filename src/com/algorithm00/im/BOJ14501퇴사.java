package com.algorithm00.im;

import java.util.Scanner;

public class BOJ14501퇴사 {
	
	static class consult{
		public int day, money;

		public consult(int day, int money) {
			super();
			this.day = day;
			this.money = money;
		}

	}
	
	static int N, ANS;
	static consult[] con;
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		con = new consult[N+1];
		
		for(int i=1; i<N+1; i++){
			int day = sc.nextInt();
			int money = sc.nextInt();
			con[i] = new consult(day, money);
		}
		
		DFS(1, 0);
		System.out.println(ANS);
		
	}
	private static void DFS(int L, int sum) {
		// N+1에 도달하며 최대값을 변수에 담는다.
		if(L==N+1) {
			ANS = Math.max(ANS, sum);
			return;
		}
		/*
		* 상담을 진행하는 경우, 날짜를 의미하는 파라미터 L을
		* 상담 기간만큼 증가시켜 같은 날짜에 상담이 여러번 발생하는 것을 방지
		*/
		if(L+con[L].day<=N+1) DFS(L+con[L].day, sum+con[L].money);
		DFS(L+1, sum);
	}

}
