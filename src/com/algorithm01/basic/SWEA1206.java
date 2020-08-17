package com.algorithm01.basic;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int res[] = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 2; i < N - 2; i++) {
				int minn = 255;
				minn = Math.min(arr[i] - arr[i - 2], minn);
				minn = Math.min(arr[i] - arr[i - 1], minn);
				minn = Math.min(arr[i] - arr[i + 1], minn);
				minn = Math.min(arr[i] - arr[i + 2], minn);
				if (minn > 0)
					res[i] = minn;
				else
					res[i] = 0;
			}
			int sum = 0;
			for (int i = 2; i < N - 2; i++) {
				sum += res[i];
			}
			System.out.println("#" + (tc + 1) + " " + sum);
		}
	}
}