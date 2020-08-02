package BOJ1592;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1592 {


	static int N, M, L, cnt; // 사람수,
	// 한 사람당 공을 받을 수 있는 최대 횟수,
	// 공 전달 위치
	static int[] arr;
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/boj1592/input1592.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		cnt = 0;
		int idx = 1, ball = 0;
		arr[idx] = 1;
		while (true) {
			if (arr[idx] % 2 == 1) { // 시계방향으로 전달
				for (int i = 0; i < L; i++) {
					idx++;
					if (idx == N + 1) idx = 1;
				}

			} else { // 반시계방향으로 전달
				for (int i = 0; i < L; i++) {
					idx--;
					if (idx == 0) idx = N;
				}
			}
			arr[idx]++;
			ball++;
			if(arr[idx] == M) break;
		}
		bw.write(ball + "");
		bw.flush();
	}

}
