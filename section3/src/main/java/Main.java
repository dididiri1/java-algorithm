import java.util.Scanner;

class Main {

    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0, rt = 0;

        while (rt < n) {
            if (sum == m) {
                answer ++;
                sum -= arr[lt++];
            } else if(sum < m) {
                sum += arr[rt++];
            } else if (sum > m) {
                sum -= arr[lt++];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
