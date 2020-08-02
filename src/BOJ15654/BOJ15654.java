package BOJ15654;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
	//중복 순열
	private static int N, M;
	private static int[] arr, sel;
	private static boolean[] isSelected;
	private static BufferedReader br;
	private static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("src/BOJ15654/input15654.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[M];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		permutation(0,0);
		bw.flush();
		
	}
	private static void permutation(int idx, int k) throws IOException {

		if(k == M) {
			for(int i=0; i<M; i++) {
				bw.write(sel[i]+ " ");
			}
			bw.write("\n");
			return;
		}else {
			for(int i=0; i<N; i++) {
				if(isSelected[i] == false) {
					isSelected[i] = true;
					sel[k] = arr[i];
					permutation(i, k+1);
					isSelected[i] = false;
				}
			}
		}
	}
}











