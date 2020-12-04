package com.algorithm01.basic;

public class 타겟넘버 {
	public static int answer;

	public static int solution(int[] numbers, int target) {
		DFS(numbers, 0, target, 0);
		return answer;
	}

	public static void DFS(int[] numbers, int idx, int target, int sum) {
		if (idx == numbers.length) {
			if(target == sum) answer++;
		} else {
			DFS(numbers, idx+1, target, sum + numbers[idx]);
			DFS(numbers, idx+1, target, sum - numbers[idx]);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
	}
}
