import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";

        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
