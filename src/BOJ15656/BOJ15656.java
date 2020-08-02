package BOJ15656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656 {
	//중복 순열
	private static int N, M;
	private static int[] arr, sel;
	private static BufferedReader br;
	private static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("src/BOJ15656/input15656.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		Permutation(0,0);
		bw.flush();
		
	}
	private static void Permutation(int idx, int k) throws IOException {
		if(k == M) {
			for(int i=0; i<M; i++) {
				bw.write(sel[i]+ " ");
			}
			bw.write("\n");
			return;
		}else {
			for(int i=0; i<N; i++) {
					sel[k] = arr[i];
					Permutation(i, k+1);
			}
		}
	}
}

