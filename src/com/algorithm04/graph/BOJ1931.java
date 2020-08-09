package com.algorithm04.graph;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1931 {

	static class Meeting implements Comparable<Meeting>{
		int from, to;

		public Meeting(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.to != o.to) return Integer.compare(this.to, o.to);
			else return Integer.compare(this.from, o.from);
		}
		
		@Override
		public String toString() {
			return "from: " +from + " to:" + to;
					
		}
	}
	
	static int N;
	static Meeting[] meetings;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		meetings = new Meeting[N];
		
		for(int i=0; i<N; i++) {
			int from  = sc.nextInt();
			int to = sc.nextInt();
			
			meetings[i] = new Meeting(from, to);
		}
		
		Arrays.sort(meetings);
		
		int prev = 0;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(meetings[i].from>=prev) {
				cnt++;
				prev = meetings[i].to;
			}
		}
		System.out.println(cnt);
	
		
	}

}
