import java.util.Arrays;
import java.util.Scanner;

public class Ex09 {

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
        Ex09 T = new Ex09();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        T.DFS(0, 1);
    }
}