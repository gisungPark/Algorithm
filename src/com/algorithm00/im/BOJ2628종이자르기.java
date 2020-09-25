package com.algorithm00.im;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2628종이자르기 {
	
	static int R, C, K;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		
		ArrayList<Integer> Wid = new ArrayList<>();
		ArrayList<Integer> Heig = new ArrayList<>();
		Wid.add(0);
		Heig.add(0);
		for(int i=0; i<K; i++) {
			int flag = sc.nextInt();
			if(flag == 0) Wid.add(sc.nextInt());
			else Heig.add(sc.nextInt());
		}
		
		Collections.sort(Wid);
		Collections.sort(Heig);
		
		Wid.add(R);
		Heig.add(C);
		int ANS = 0;
		for(int i=1; i<Wid.size(); i++) {
			for(int j=1; j<Heig.size(); j++) {
				int tmp = (Wid.get(i)-Wid.get(i-1))*(Heig.get(j)-Heig.get(j-1));
				ANS = Math.max(ANS, tmp);
			}
		}
		
		System.out.println(ANS);
	}

}
