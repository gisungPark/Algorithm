package com.algorithm01.basic;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
 
class SWEA5658{
    static int T, N, K;
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
         
        for(int tc = 0; tc<T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            sc.nextLine();
             
            ArrayList<Character> list = new ArrayList<Character>();
            HashSet<String> h = new HashSet<String>();
             
            String str = sc.nextLine();
            for(int i=0; i<str.length(); i++){
                list.add(str.charAt(i));
            }
            for(int i=0; i<list.size(); i+=N/4) {
                String tmp = "";
                for(int j=i; j<i+N/4; j++) {
                    tmp= tmp+list.get(j)+"";
                }
                h.add(tmp);
            }
             
            while(true) {
                int cnt = 0;
                Character ch = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(0, ch);
                for(int i=0; i<list.size(); i+=N/4) {
                    String tmp = "";
                    for(int j=i; j<i+N/4; j++) {
                        tmp= tmp+list.get(j)+"";
                    }
                    if(h.add(tmp)) cnt++;
                }
                 
                if(cnt == 0) break;
            }
             
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for(String s: h) {
                newList.add(Integer.parseInt(s, 16));
            }
            Collections.sort(newList, Comparator.reverseOrder());
 
            System.out.println("#"+(tc+1)+" "+ newList.get(K-1));
        }
    }
 
}