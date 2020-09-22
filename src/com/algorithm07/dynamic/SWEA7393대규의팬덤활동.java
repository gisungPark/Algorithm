package com.algorithm07.dynamic;

import java.util.Arrays;
import java.util.Scanner;
/*
4
10
11
50
100
*/
 
public class SWEA7393대규의팬덤활동 {
 
    public static void main(String[] args) {
        long[][][] check = new long[101][10][1024];
        int n,count = 0;
        long MOD = 1000000000;
        Scanner sc = new Scanner(System.in);
         
        count = Integer.parseInt(sc.nextLine());
         
                for(long[][] row2:check){
                for(long[] row:row2){
                    Arrays.fill(row, 0);
                }// long[] for
            }//long[][] for
         
        for(int j = 1; j <10; j++)   check[1][j][1<<j] = 1;
         
            for(int length = 1; length < 100 ; length++){
                for(int last = 0; last < 10; last++){
                    for(int state =0; state < 1024 ; state++){
                        check[length][last][state] %= MOD;
                        if(last>0) check[length+1][last-1][state | (1<<(last-1))] += check[length][last][state];
                        if(last<9) check[length+1][last+1][state | (1<<(last+1))] += check[length][last][state];
                    }//state for
                }//last for
            }//length for
             
        for(int i = 0 ; i < count ; i++){ // 입력받은 테스트케이스 수
            long sum = 0;
             
            n = sc.nextInt();
             
            for(int j = 0; j <10; j++){
                sum += (check[n][j][1023]%MOD);
            }
            System.out.println("#" + (i+1) + " " + sum%MOD);
        }// count for
    }
}