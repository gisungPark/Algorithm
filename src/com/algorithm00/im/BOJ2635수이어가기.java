package com.algorithm00.im;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2635수이어가기 {

	static int N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=N/2+1; i<=N; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(N);
			tmp.add(i);
			int idx=1;
			while(true) {
				if(tmp.get(idx-1)-tmp.get(idx) < 0) break;
				tmp.add(tmp.get(idx-1)-tmp.get(idx));
				idx++;
			}
			if(tmp.size()>list.size()) {
				list = tmp;
			}
		}
		
		System.out.println(list.size());
		for(Integer v: list)
			System.out.print(v +" ");
	}
	
}
