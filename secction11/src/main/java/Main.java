import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i < n; i++) {
            if (isPrimeNumber(i)) {
                answer ++;
            }
        }

        return answer;
    }

    public boolean isPrimeNumber(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(T.solution(n));
    }
}
