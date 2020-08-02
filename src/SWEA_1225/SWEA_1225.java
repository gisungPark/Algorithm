package SWEA_1225;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {
	static int N = 8;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Queue<Integer> queue = new LinkedList<Integer>();
		System.setIn(new FileInputStream("src/SWEA_1225/input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc=0; tc<10; tc++) {
			sc.nextInt();
			for(int i=0; i<N; i++) {
				queue.offer(sc.nextInt());
			}
			int cnt = 1;
			boolean isOk = false;
			while(true) {
				if(isOk) break;
				if(cnt == 6) cnt = 1;
				int tmp = queue.poll() - cnt;
				cnt++;
				if(tmp <= 0 ) {
					tmp = 0;
					isOk = true;
				}
				queue.offer(tmp);
				
				
			}
			
			System.out.print("#"+(tc+1)+ " ");
			for(int i=0; i<N; i++) {
				System.out.print(queue.poll()+ " ");
			}
			System.out.println();
		}
		
	}

}
