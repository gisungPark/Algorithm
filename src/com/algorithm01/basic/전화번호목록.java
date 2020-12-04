package com.algorithm01.basic;

import java.util.Arrays;

public class 전화번호목록 {
	public static boolean solution(String[] phone_book) {

		// 전화번호를 오름차순으로 정렬한다.
		Arrays.sort(phone_book);
		
		for(int i=0; i<phone_book.length-1; i++) {
			for(int j=i+1; j<phone_book.length; j++) {
				// 2중 for문을 이용하여 각각의 전화번호를 비교하여
				// 첫글자를 비교하여 일치하지 않으면, break하므로써 효율성을 높였다.
				if(phone_book[i].charAt(0) != phone_book[j].charAt(0)) break;
				
				// String의 startWith메소드를 이용하여 접두어를 확인한다.
				if(phone_book[j].startsWith(phone_book[i])) { 
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		solution(new String[] {"119", "97674223", "1195524421"});
	}
	
}
