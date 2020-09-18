package com.algorithm01.basic;

import java.util.ArrayList;
import java.util.Scanner;
 
class SWEA1244최대상금{
     
    static int T, N;
    static ArrayList<Integer> list;
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
         
        for(int tc = 0; tc<T; tc++) {
            list = new ArrayList<>();
            String tmp = sc.next();
            N = sc.nextInt();
             
            for(int i=0; i<tmp.length(); i++) {
                list.add(tmp.charAt(i)-'0');
            }
             
            int start = 0;
            int end = list.size()-1;
            int round = 0;
            boolean isOk = false;
            while(true) {
                if(round == N) break;
                end = list.size()-1;
                if(start == end) {
                    /*
                     * start 첨자가 배열의 끝에 도달한 경우, 배열은 이미 가장 큰 수로 정렬된 상태이다. 
                     * 이때 부족한 자리교환 횟수를 채우기 위해 배열내에 동일한 값이 존재하는지 확인해야 한다.  
                     * */
                    for(int i=1; i<list.size(); i++) {
                        if(list.get(i-1) == list.get(i)) isOk = true;
                    }
                    /*
                     * 이미 정렬이 끝난상태에서 배열내 동일한 값이 존재한다면,
                     * 더 이상의 교환 없이 종료한다.    
                     * */
                    if(isOk) break;
 
                     
                    /*
                     * 동일한 값이 존재하지 않는다면,
                     * 끝 두자리를 교환하는 작업을 반복한다.
                     * */
                    int swap = list.get(start);
                    list.set(start, list.get(start-1));
                    list.set(start-1, swap);
                    round++;
                    continue;
                }
                 
                int minIdx = end, maxVal = Integer.MIN_VALUE;
                while(true) {
                    if(start==end) break;
                    if(list.get(end) > maxVal) {
                        maxVal = list.get(end);
                        minIdx = end;
                    }
                    end--;
                }
                if(list.get(start)>maxVal) {
                    start++;
                    continue;
                }
                int swap = list.get(minIdx);
                list.set(minIdx, list.get(start));
                list.set(start, swap);
                round++;
                start++;
            }
             
            System.out.print("#"+ (tc+1)+ " ");
            for(int i=0; i<list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}














