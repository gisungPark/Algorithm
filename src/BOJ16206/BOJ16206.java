package BOJ16206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16206 {

	static int N,M,cnt=0;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src/Day_200731/input16206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		boolean[] isSelected = new boolean[N];
		int[] arr2 = new int[N]; 
		int k=0;
		for(int i=0; i<N; i++) {
			if(arr[i]%10 == 0) {
				arr2[k++] = arr[i];
				isSelected[i] = true;
			}
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i] == false) arr2[k++] = arr[i];
		}
		arr = arr2;
		
		for(int i=0; i<N; i++) {
			if(arr[i] < 10) continue;
			if(arr[i] == 10)  cnt++;
			else {
				int tmp = arr[i];
				while(M>0) {
					tmp = tmp - 10;
					cnt++;
					M--;
					
					if(tmp < 10) break;
					else if(tmp == 10) {
						cnt++;
						break;
					}
				}
			}
		}
		bw.write(cnt+"");
		bw.flush();
	}
}
