import java.util.*;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int answer = 0, sum = 0;

        TreeSet<Integer> Tset = new TreeSet(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    sum = arr[i] + arr[j] + arr[l];
                    Tset.add(sum);
                }
            }
        }



        int cnt = 1;
        for (Integer x : Tset) {
            if (cnt == k) {
                return x;
            }
            cnt ++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
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