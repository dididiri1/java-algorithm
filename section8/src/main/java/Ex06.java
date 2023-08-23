import java.util.Arrays;
import java.util.Scanner;

public class Ex06 {

    static int[] arr, pm, ch;
    static int n, m;
    public void DFS(int L) {
        if (L == m) {
            System.out.println(Arrays.toString(pm));
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ex06 T = new Ex06();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        T.DFS(0);
    }
}