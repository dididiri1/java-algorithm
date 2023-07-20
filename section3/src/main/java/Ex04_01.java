import java.util.Scanner;

class Ex04_01 {

    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > k) {
                    break;
                } else if(sum == k) {
                    answer ++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex04_01 T = new Ex04_01();
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
