package com.algorithm01.basic;

import java.util.Arrays;

public class 입국심사 {
	
	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		long answer = times[times.length-1]*n;
		long left = 1;
		long right = times[times.length-1]*n;
		long mid = 0;
		
		while(left <= right) {
			mid = (left+right)/2;
			long sum = 0;
			for(int i=0; i< times.length; i++) {
				sum += mid/times[i];
			}
			if(n > sum) left = mid+1;
			else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
		}
		
		return answer;
	}
	

	public static void main(String[] args) {
		
	}
	
}
