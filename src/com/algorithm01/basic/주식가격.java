package com.algorithm01.basic;

import java.util.Arrays;

public class 주식가격 {

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length-1; i++) {
			int cnt = 0;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i]>prices[j]) {
					cnt++;
					break;
				}else {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		
        return answer;
	}

	public static void main(String[] args) {
		int[] answer = solution(new int[] { 1, 2, 3, 2, 3 });
		System.out.println(Arrays.toString(answer));
	}
}
