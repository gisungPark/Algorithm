package BOJ15655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {
	//조합
	private static int N, M;
	private static int[] arr, sel;
	private static BufferedReader br;
	private static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("src/BOJ15655/input15655.txt"));
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
		
		Combination(0,0);
		bw.flush();
		
	}
	private static void Combination(int idx, int k) throws IOException {
		if(k == M) {
			for(int i=0; i<M; i++) {
				bw.write(sel[i]+ " ");
			}
			bw.write("\n");
			return;
		}else {
			for(int i=idx; i<N; i++) {
					sel[k] = arr[i];
					Combination(i+1, k+1);
			}
		}
	}
}

