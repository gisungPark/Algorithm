package com.algorithm01.basic;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

	static Set<Integer> set;
	static int[] nums;
	static int[] sel;
	static boolean selected[];
	public static int solution(String numbers) {
		int answer = 0;
        int len = numbers.length();
        
        nums = new int[len];
      
        for(int i=0; i<len; i++) {
        	// 문자열을 정수로 변환
        	nums[i] = numbers.charAt(i)-'0';
        }
        
        // 순열을 통한 숫자조합시 중복을 제거해줄 set 
        set = new HashSet<>();
        for(int i=len; i>0; i--) {
        	// 순열의 크기를 줄여가며 모든 경우의 수를 구한다.
        	selected = new boolean[len];
	        sel = new int[i];
	        perm(0);
        }
        
        // 만들어진 모든 경우의 수에서 소수의 갯수를 구한다.
        for(Integer n: set) {
        	if(isPrime(n)) answer++;
        }
        return answer;
    }
	

	private static void perm(int k) {
		
		if(k == sel.length) {
			int n=0;
			// 조합된 순열로 10진수의 정수를 만든다.
			for(int i=0; i<sel.length; i++) {
				n += sel[i]*Math.pow(10, i);
			}
			set.add(n);
		}else {
			for(int i=0; i<nums.length; i++) {
				if(selected[i]) continue;
				selected[i] = true;
				sel[k] = nums[i];
				perm(k+1);
				selected[i] = false;
			}
		}
		
	}



	public static void main(String[] args) {
		
		int n = solution("011");
		System.out.println(n);
		
	}

	// 소수 체크 메소드
	private static boolean isPrime(int n) {
		if(n<=1) return false;
		
		for(int i=2; i*i <= n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
