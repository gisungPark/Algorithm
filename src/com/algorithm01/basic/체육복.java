package com.algorithm01.basic;

import java.util.Arrays;

public class 체육복 {
	  public int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        int[] arr = new int[n+1];
	        Arrays.fill(arr, 1);
	        for(int i=0; i<reserve.length; i++) {
	        	arr[reserve[i]]=2;
	        }
	        
	        for(int i=0; i< lost.length; i++) {
	        	arr[lost[i]]--;
	        }
	        
	        for(int i=1; i<arr.length; i++) {
	        	int prev = (i-1) > 0 ? i-1 : 0;
	        	int next = i+1 < arr.length ? i+1 : arr.length-1;
	        	
	        	if(arr[i] == 0) {
	        		if(arr[prev] == 2) {
	        			arr[prev]--;
	        			arr[i]++;
	        		}else if(arr[next] == 2) {
	        			arr[next]--;
	        			arr[i]++;
	        		}
	        	}
	        	
	        	if(arr[i] == 0) answer++;
	        }
	        
	        return arr.length-answer-1;
	    }
}
