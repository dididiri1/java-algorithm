import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] combi;

    static int n, m;

    public void DFS(int L, int s) {
        if (L == m) {
            System.out.println(Arrays.toString(combi));
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        T.DFS(0, 0);
    }
}