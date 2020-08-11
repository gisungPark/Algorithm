package com.algorithm01.basic;

import java.util.Scanner;

//////////BOJ2941. 크로아티아 알파벳 ////////////
public class BOJ2941 {

	static int cnt;
	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		String str = sc.next();
		
		int cnt=0;
		for(int i=0; i<str.length()-2; i++) {
			String tmp = str.substring(i,i+3);
			
			if(tmp.equals("dz=")) cnt++;
		}
		str = str.replace("dz=", " ");
		
		for(int i=0; i<str.length()-1; i++) {
			String tmp = str.substring(i,i+2);
			System.out.println(tmp);
			if(tmp.equals("c=")) cnt++;
			else if(tmp.equals("c-")) cnt++;
			else if(tmp.equals("d-")) cnt++;
			else if(tmp.equals("lj")) cnt++;
			else if(tmp.equals("nj")) cnt++;
			else if(tmp.equals("s=")) cnt++;
			else if(tmp.equals("z=")) cnt++;
		}
		str = str.replace("c=", " ").replace("c-", " ")
		.replace("d-", " ").replace("lj", " ").replace("nj", " ")
		.replace("s=", " ").replace("z=", " ");
		
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != ' ') cnt++;
		}
		
		System.out.println(cnt);
	}

}
