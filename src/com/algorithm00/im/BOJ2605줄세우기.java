package com.algorithm00.im;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2605줄세우기 {

	static int N;		//학생수
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0; i<N; i++) {		//N명의 학생들의 순서표를 입력받는다.
			list.add(sc.nextInt());
		}
		
		for(int i=0; i<N; i++) {
			int move = list.get(i);	//각 학생의 순서표 값으로 앞으로의 이동칸 수
			if(move != 0) {
				list.remove(i);		//학생을 앞으로 이동하기 전에 현재 위치에서 지운다.
				list.add(i-move,i);	//앞으로 이동하여 학생을 리스트에 삽입한다.
				
			}else {					//순서표의 값이 0일 경우 현재 자리를 유지하며
				list.set(i, i);		//list의 값을 학생번호로 갱신한다.
			}
		}
		
		for(int i=0; i<N; i++) {	//학생 번호를 출력한다.
			System.out.print(list.get(i)+1 + " ");
		}
	}

}
