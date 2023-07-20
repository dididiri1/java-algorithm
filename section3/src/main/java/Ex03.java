import java.util.Scanner;

class Ex03 {

    public int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03 T = new Ex03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
