import java.util.Scanner;

public class Ex02 {

    public int[] solution(int n, int[] arr) {

        for (int i = 0; i < n-1; i++) { // n-1 4회전
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Ex02 T = new Ex02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }
}
