package SWEA1247;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA1247 {

	static int T, N, minDistance;
	static int[][] arr;
	static int[] sel;
	static boolean[] isSelected;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/Day_200731/input1247.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			N+=2;
			arr = new int[N][2];
			sel = new int[N];
			isSelected = new boolean[N];
			
			//좌표 입력 회사-> 집 -> N명의 고객 좌표
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			minDistance = 2146000000;
			permutation(1,1);
			bw.write("#"+(tc+1)+" "+minDistance+"\n");
			bw.flush();
		}
	}
	private static void permutation(int idx, int k) throws IOException {

		if(k == sel.length-1) {
			sel[0] = 0;
			sel[sel.length-1] = 1;
			if(sel[0] == 0 && sel[sel.length-1] == 1) {
					//bw.write(Arrays.toString(sel)+"\n");
				int dis = 0;
				for(int i=0; i<sel.length-1; i++) {
					dis += distance(arr[sel[i]], arr[sel[i+1]]);
					if(dis>minDistance) break;
					//bw.write(i+" -> " + (i+1)+" dis: "+ distance(arr[sel[i]], arr[sel[i+1]])+"\n");
				}
				//bw.write("##"+" "+dis+"\n");
				if(minDistance >= dis) minDistance = dis;
			}
			return;
		}
		for(int i=2; i<N; i++) {
			if(isSelected[i] == false) {
				isSelected[i] = true;
				sel[k] = i;
				permutation(idx+1, k+1);
				isSelected[i] = false;
			}
		}
	}
	private static int distance(int[] a, int[] b) {
		
		return Math.abs(a[0]- b[0])+ Math.abs(a[1]-b[1]);
	}
}


