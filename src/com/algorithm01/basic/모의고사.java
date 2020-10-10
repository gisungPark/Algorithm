package com.algorithm01.basic;

public class 모의고사 {
	public static int[] solution(int[] answers) {
		
		int[] score = new int[3];
		int[][] student = new int[3][];
		student[0] = new int[] {1,2,3,4,5};
		student[1] = new int[] {2,1,2,3,2,4,2,5};
		student[2] = new int[] {3,3,1,1,2,2,4,4,5,5};
		
		for(int i=0; i<answers.length; i++) {
			for(int j=0; j<3; j++) {
				if(answers[i] == student[j][i%student[j].length]) {
					score[j]++;
				}
			}
		}
		
		int max = Math.max(Math.max(score[0], score[1]), score[2]);
		int cnt=0;
		for(int i=0; i<3; i++) {
			if(score[i]==max) cnt++;
		}
		int[] answer = new int[cnt];
		int idx = 0;
		for(int i=0; i<3; i++) {
			if(score[i]==max) answer[idx++] = i+1;
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(new int[] {1,2,3,4,5});
	}
}
