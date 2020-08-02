package BOJ2798;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2798 {

	private static int N, M, res;
	private static int[] arr, sel;
	private static boolean[] isSelected;
	private static BufferedReader br;
	private static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("src/boj2798/input2798.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[3];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		
		res = 0;
		Combination(0,0);
		bw.write(res+"");
		bw.flush();
	}

	private static void Combination(int idx, int k) throws IOException {
		if(k == 3) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum+=sel[i];
				
			}
			if(sum > M) return;
			if((M-sum)< (M-res)) res = sum;
			return;
		}
		for(int i=idx; i<N; i++) {
			if(isSelected[i] == false) {
				isSelected[i] = true;
				sel[k] = arr[i];
				Combination(idx+1, k+1);
				isSelected[i] = false;
			}
		}
	}
}
