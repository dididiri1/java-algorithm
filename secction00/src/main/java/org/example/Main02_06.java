package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main02_06 {

    public boolean isPrime(int num) {
        if(num==1) return false;
        for(int i=2; i <num; i++) {
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0) {
                int t=tmp%10;
                res=res*10+t;
                tmp=tmp/10;
            }
            if (isPrime(res)) answer.add(res);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main02_06 T = new Main02_06();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=kb.nextInt();
        }
        for(Integer x : T.solution(n, arr)) {
            System.out.println(x);
        }
    }
}
