package SWEA_3299;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3299 {
	static int T,N;
	public static void main(String[] args) throws FileNotFoundException {
		
		Queue<String> qu1 = new LinkedList<String>();
		Queue<String> qu2 = new LinkedList<String>();
		
		System.setIn(new FileInputStream("src/SWEA_3299/input_3299.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			N=sc.nextInt();
			for(int i=0; i<N; i++) {
				String str = sc.next();
				if(i < N/2) qu1.offer(str);
				else qu2.offer(str);
			}
			System.out.print("#"+(tc+1)+ " ");
			for(int i=0; i<N; i++) {
				if(i%2 == 0) System.out.print(qu1.poll()+" ");
				else System.out.print(qu2.poll()+" ");
			}
			System.out.println();
		}
		
	}
}
