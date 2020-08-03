package JUNGOL1523;

import java.util.Scanner;

public class JUNGOL1523 {
	private static int N, M;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		if (N > 100)
			System.out.println("INPUT ERROR!");
		else {
			switch (M) {
			case 1:
				print1();
				break;

			case 2:
				print2();
				break;

			case 3:
				print3();
				break;

			}
		}
	}

	private static void print1() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print3() {
		int l = N * 2 - 1;
		int s = l / 2, e = l / 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < l; j++) {
				if (j >= s && j <= e) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
			s--;
			e++;
		}
	}
}
