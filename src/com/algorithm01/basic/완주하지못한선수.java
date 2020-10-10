package com.algorithm01.basic;

import java.util.Arrays;

public class 완주하지못한선수 {

	public static String solution(String[] participant, String[] completion) {

		String answer = "";

		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for(int i=0; i<completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
		}
		if(answer.equals("")) answer = participant[participant.length-1];
		return answer;
	}

	public static void main(String[] args) {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "vinko", "marina", "nikola"};
		
		System.out.println(solution(participant, completion));
	}
}
