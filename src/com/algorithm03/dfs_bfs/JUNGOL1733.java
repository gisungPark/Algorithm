package com.algorithm03.dfs_bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

///////////JUNGOL1733 오목 ////////////
public class JUNGOL1733 {

	public static class po implements Comparable<po>{
		int x, y, val;

		public po(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(po o) {
			if(this.y == o.y) return this.x-o.x;
			else return this.y-o.y;
		}

		@Override
		public String toString() {
			return "po [x=" + x + ", y=" + y + ", val=" + val + "]";
		}
		
	}
	
	static int N = 19, ANS;
	static int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static int[] dy = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/jungol1733.txt"));
		Scanner sc = new Scanner(System.in);
		
		Queue<po> q = new LinkedList<po>();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0 ) q.add(new po(i, j, map[i][j]));
			}
		}
		
        po[] ansArray = new po[5];
        while(!q.isEmpty()) {
        	
            po tmp = q.poll();
            boolean isOk = true;
            
            for(int i=0; i<8; i++) {
                isOk = true;
                int xx = tmp.x;
                int yy = tmp.y;
                int count = 0;
                
                while(true) {
                    xx = xx + dx[i];
                    yy = yy + dy[i];
                    ////////// map을 벗어난 경우 ////////
                    if(xx<0 || xx >=N || yy<0 ||yy >= N ) break;
                  
                    if(count >= 5) {
                    	if(map[xx][yy] == tmp.val ) {isOk = false; break;}
                    	else break;
                    }else {
                    	if(map[xx][yy] != tmp.val) break;
                    	else ansArray[count++] = new po(xx, yy, tmp.val);
                    }
                }
                
                
                if(isOk && count == 5) { ANS = tmp.val; break;}
            }
            if(isOk) break;
        }
		System.out.println(ANS);
		if(ANS != 0) {
			// System.out.println(ansArray[0].x+" "+ ansArray[0].y);
			for(po p : ansArray) {
				System.out.println(p.toString());
			}
		}
		
		
	}
	private static void print(int[][] map) {

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
