package BOJ8320;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ8320 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
	
		for(int i=1; i<=N; i++) {
			for(int j=i; i*j <= N; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
