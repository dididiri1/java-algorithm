import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] <= b[p2]) {
                answer.add(a[p1++]);
            } else {
                answer.add(b[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(a[p1++]); // a 배열에 값이 남아 있을 때
        }
        while (p2 < m) {
            answer.add(b[p2++]); // b 배열에 값이 남아 있을 때
        }

        System.out.println("size = " + answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println("answer = " + answer.get(i));
        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }

        for (Integer x : T.solution(n, m, a, b)) {
            System.out.println(x+ " ");
        }
    }
}
