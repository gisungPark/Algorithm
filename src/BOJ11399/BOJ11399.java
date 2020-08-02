package BOJ11399;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {

	private static int N;
	private static int[] arr, time;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/BOJ11399/input11399.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		time = new int[N];
		
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			
			int sum = 0;
			for(int j=0; j<=i; j++) {
				sum += arr[j];
			}
			time[i] = sum;
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum+=time[i];
		}
		System.out.println(sum);
	}

}
