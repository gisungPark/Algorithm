package BOJ15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//조합  n개에서 순서 관계없이  m개를 뽑는다.
//순열  n개에서 m개를 뽑을때 순서를 고려하여 뽑는다. 
public class BOJ15650 {

	private static int N, M;
	private static int[] sel;
	private static boolean[] isSelected;
	public static void main(String[] args) throws IOException {

		N=3;
		M=2;
		sel = new int[M];
		isSelected = new boolean[N+1];
		
		Combination(1,0);
	}
	private static void Combination(int idx, int k) throws IOException {
		if(k == M) {
			for(int i=0; i<M; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			
			return;
		}

		for(int i=1; i<=N; i++) {
			if(isSelected[i] == false) {
				isSelected[i] =true;
				sel[k] = i;
				Combination(i+1, k+1);
				isSelected[i] = false;
			}
		}
	}
}
