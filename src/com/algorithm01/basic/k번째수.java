package com.algorithm01.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class k번째수 {

	public static int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
        
       for(int tc=0; tc<commands.length; tc++) {
    	   List<Integer> list = new ArrayList<>();
    	   for(int i=commands[tc][0]-1; i<commands[tc][1]; i++) {
    		   list.add(array[i]);
    	   }
    	   Collections.sort(list);
    	   answer[tc] = list.get(commands[tc][2]-1);
       }
        
        return answer;
    }

	public static void main(String[] args) {

		int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
		int[][]commands = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = solution(array,commands);
		System.out.println(Arrays.toString(answer));
	}
}
