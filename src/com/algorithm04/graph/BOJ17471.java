package com.algorithm04.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//////////BOJ17471 게리멘더링 ////////
public class BOJ17471 {

	
	static int N, idx, ANS = Integer.MAX_VALUE; //구역의 개수
	static int[] values, isSelected;
	static int[][] powerSetCase;
	static boolean flag;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		values = new int[N+1];
		for(int i=1; i<N+1; i++) {
			values[i] = sc.nextInt();
		}
		
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N+1; i++) {
			int cnt = sc.nextInt();
			for(int j=0; j<cnt; j++) {
				list[i].add(sc.nextInt());
			}
		}
		
//		for(ArrayList<Integer> l: list) {
//			System.out.println(l.toString());
//		}
		powerSetCase = new int[1<<N][];
		isSelected = new int[N+1];
		powerSet(1);
		
//		for(int[] a: powerSetCase) {
//			System.out.println(Arrays.toString(a));
//		}
		
	
			
		if(flag) System.out.println(ANS);
		else System.out.println("-1");
		}
	
	
	private static void powerSet(int L) {
		if(L==N+1) {
			int groupA = 0;
			int groupB = 0;
			for(int i=1; i<isSelected.length; i++) {
				if(isSelected[i]==0) groupA++;
				else groupB++;
			}
			if(groupA == 0 || groupB == 0) return;
			else {
				////////////////////나뉜 2구역이 연결될수 있는지 체크 ////////
				if(!BFS(0, Arrays.copyOf(isSelected, isSelected.length))) return;
				if(!BFS(1, Arrays.copyOf(isSelected, isSelected.length))) return;
				
				int A = 0, B = 0;
				for(int i=1; i<N+1; i++) {
					if(isSelected[i] == 0 ) A+=values[i];
					else B +=values[i];
				}
				flag = true;
				ANS = Math.min(ANS, Math.abs(A-B));
				
				
			}
		}else {
			isSelected[L] = 0;
			powerSet(L+1);
			isSelected[L] = 1;
			powerSet(L+1);
		}
	}


	private static boolean BFS(int val, int[] copyOf) {
		boolean[] ch = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<N+1; i++) {
			if(copyOf[i] == val) {
				q.add(i);
				ch[i] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<list[cur].size(); i++) {
				if(!ch[list[cur].get(i)] && copyOf[list[cur].get(i)] == val) {
					ch[list[cur].get(i)] = true;
					q.add(list[cur].get(i));
				}
			}
		}
		
		for(int i=1; i<copyOf.length; i++) {
			if(copyOf[i] == val && !ch[i]) return false;
		}
		
		return true;
	}

}
