package org.example;

import java.util.Scanner;

public class Main03_04 {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0, lt = 0, rt = 0;

        while(rt < n) {
            if (sum == m) {
                answer ++;
                sum -= arr[lt++];
            } else if(sum < m) {
                sum += arr[rt++];
            } else {
                sum -= arr[lt++];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main03_04 T = new Main03_04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}