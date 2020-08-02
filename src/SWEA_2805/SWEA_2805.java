package SWEA_2805;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_2805 {
	static int T,N;
	static int map[][];
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA_2805/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int res = 0;
			N = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int mid = N / 2;
			int s = mid, e = mid;
			for (int i = 0; i <= mid; i++) {
				for (int j = s; j <= e; j++) {
					res += map[i][j];
				}
				s--;
				e++;
			}
			s = 1; 
			e = N-2;
			for(int i = mid+1; i<N; i++) {
				for (int j = s; j <= e; j++) {
					res += map[i][j];
				}
				s++;
				e--;
			}
			print(map);
			System.out.println("res: " + res);
		}
		
	}
	
	
	private static void print(int[][] map) {
		// TODO Auto-generated method stub
	
		for(int i=0; i<map[0].length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
