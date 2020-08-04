package SWEA1238;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1238 {

	static int N, start;
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream ("src/SWEA1238/input1238.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0; tc<10; tc++) {
			N = sc.nextInt();
			start = sc.nextInt();
			map = new boolean[101][101];
			for(int i=1; i<=N/2; i++) {
				int from = sc.nextInt();
				int to =  sc.nextInt();
				map[from][to] = true; 
			}
			
			System.out.print("#"+(tc+1)+ " ");
			BFS(start);
		}
	}
	
	
	private static void BFS(int s) {
		int[] L = new int[101];
		boolean[] v = new boolean[101];
		Queue<Integer> q = new LinkedList<Integer>();
		
		v[s] = true;
		L[s] = 1;
		q.add(s);

		while(!q.isEmpty()) {
			int next = q.poll();
			for(int i=0; i<101; i++) {
				if(map[next][i]
						&& !v[i]) {
					v[i] = true;
					L[i] = L[next]+1;
					q.add(i);
				}
			}
		}
		int maxIdx = 0;
		for(int i=0; i<101; i++) {
			if(L[maxIdx] <= L[i]) maxIdx = i;
		}
		System.out.println(maxIdx);
		
	}
}
















