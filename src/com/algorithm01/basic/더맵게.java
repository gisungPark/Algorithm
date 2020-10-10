package com.algorithm01.basic;

import java.util.PriorityQueue;

public class 더맵게 {
/*
 * 섞은 음식의 스코빌 지수 = 
 * 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * */
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(Integer v: scoville) {
			pq.add(new Long(v));
		}
		while(!pq.isEmpty()) {
			if(pq.peek()>=K) break;
			if(pq.size() < 2) return -1; 
			
			Long first = pq.poll();
			Long second = pq.poll();
			if(first == 0 && second == 0) return -1;
			
			answer++;
			pq.add((first + second*2));
				
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
	}
}
