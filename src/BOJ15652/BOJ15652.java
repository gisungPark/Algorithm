package BOJ15652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15652 {
	//중복 조합
	private static int N,M;
	private static int[] sel;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		Combination(1,0);
		
		bw.flush();
		
	}
	private static void Combination(int idx, int k) throws IOException {
		if(k == M) {
			for(int i=0; i<k; i++) {
				bw.write(sel[i] + " ");
			}
			bw.write("\n");
			return;
		}else {
			for(int i = idx; i<=N; i++) {
				sel[k] = i;
				Combination(i, k+1);
			}
			
		}
	}

}
