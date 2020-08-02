package BOJ15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class BOJ15651 {
	//길이가 M인 중복 조합
	static int N,M;
	static int[] sel;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		
		permutation(1,0);
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
	
			for(int i=1; i<=N; i++) {
				sel[k] = i;
				permutation(i+1, k+1);
				
			}
		}
	}
}
