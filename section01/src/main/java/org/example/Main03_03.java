package org.example;

import java.util.Scanner;

public class Main03_03 {

    public int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if (i >= k-1) {
                answer = Math.max(answer, sum);
                sum -= arr[i-(k-1)];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main03_03 T = new Main03_03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}