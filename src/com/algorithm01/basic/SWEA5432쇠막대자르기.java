package com.algorithm01.basic;

import java.util.Scanner;
import java.util.Stack;
/*
2
()(((()())(())()))(())
(((()(()()))(())()))(()())

 * */

public class SWEA5432쇠막대자르기 {

	static int T, ANS;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			String str = sc.next();
			
			Stack<Character> st = new Stack<>();
			int pipe= 0, laser=0, ANS = 0;
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == ')') {
					if(str.charAt(i-1) == '(') {
						st.pop();
						ANS+=st.size();
					}else {
						st.pop();
						ANS++;
					}
				
				}else {
					st.push('(');
				}
			}
			System.out.println("#"+(tc+1)+ " " +ANS);
			
		}
	}
}
