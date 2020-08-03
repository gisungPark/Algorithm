package SWEA9229;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SWEA9229 {
	static int T, N, M, res;
	static int arr[], sel[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/hw_200803/input9229.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];
			sel = new int[2];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			res = -1;
			Combination(0,0);
			System.out.println("#"+(tc+1)+" " + res);
			
			
			
		}
	}
	// N개 중에서 2개 뽑는 조합
	private static void Combination(int idx, int k) {
		if(k == 2) {
			int sum = 0;
			for(int i=0; i<sel.length; i++) {
				sum+=sel[i];
			}
			if(sum<=M && res<sum) res = sum;
			return;
		}
		for(int i=idx; i<N; i++) {
			sel[k] = arr[i];
			Combination(i+1, k+1);
		}
	}
}



