package com.algorithm01.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		// answer 배열의 크기를 정하기 위한 임시 list 변수
		List<Integer> ans = new ArrayList<>();
		
		int cur = 0;	// 배포되어야 첫번째 작업 인덱스 변수
		int end = -1;	// 배포될수 있는 마지막 작업 인덱스 변수
		while(true) {
			if(end == (progresses.length-1)) break;	// 모든 작업이 완료되면 break
			
			// cur위치 부터 배열의 끝까지 작업률을 업데이트 한다.
			for(int i=cur; i<progresses.length; i++) {
				progresses[i] += speeds[i];
			}
			
			// 완료된 작업이 있다면 end의 위치를 조정한다.
			for(int i=cur; i<progresses.length; i++) {
				if(progresses[i] >= 100) end++;
				else break;
			}
			
			// {(마지막 작업idx - 첫번째 작업idx) + 1}은 완료된 작업의 갯수를 뜻한다.
			if((end-cur+1)>0) {
				// 'ans' List에 완료된 작업의 개수를 삽입한다.
				ans.add(end-cur+1);
				// 인덱스 초기화
				cur = end+1;
				end = cur-1;
			}
			
		}
		
		// ans의 크기로 return 해야하는 answer 배열의 크기를 지정한다.
		answer = new int[ans.size()];
		for(int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		
		return answer;
	}

	public static void main(String[] args) {

		int[] ans = solution(new int[] {93, 30, 55} , new int[] {1, 30, 5});
		System.out.println(Arrays.toString(ans));
	}

}
