package com.algorithm01.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 가장큰수 {

	static long ANS = -1L;
	static int[] nums;
	static int[] sel;
	static boolean selected[];
	public static String solution(int[] numbers) {
		String answer = "";
		int len = numbers.length;
		
		nums = numbers;
		sel = new int[len];
		selected = new boolean[len];
		// 순열을 통해 가능한 모든 조합을 진행한다.
		perm(0);

		answer = String.valueOf(ANS);
		return answer;
	}

	private static void perm(int k) {
		// 효율성 개선을 위해 첫째자리의 수를 비교해 더 작다면 더 이상 진행하지 않고 return 
		if(k >= 1 & head(sel[0]) < head(ANS)) return;
		
		if (k == sel.length) {
			List<Integer> nums = new LinkedList<>();
			for (int i = 0; i < sel.length; i++) {
				int n = sel[i];
				List<Integer> rev = new LinkedList<>();
				while (n >= 1) {
					rev.add(n % 10);
					n /= 10;
				}
				int last = rev.size();
				for (int j = last - 1; j >= 0; j--) {
					nums.add(rev.get(j));
				}
			}
			long n = 0L;
			int pos = nums.size()-1;
			for(int i=0; i<nums.size(); i++) {
				n += nums.get(i)*Math.pow(10,pos--);
			}
			ANS = (ANS > n) ? ANS : n;
			
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (selected[i])
					continue;
				selected[i] = true;
				sel[k] = nums[i];
				perm(k + 1);
				selected[i] = false;
			}
		}
	}

	private static int head(long n) {
		int prev = 0;
		while (n >= 1) {
			prev = (int) (n%10);
			n /= 10;
		}
		return prev;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9}));
	}
}
