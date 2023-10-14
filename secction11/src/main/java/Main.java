import java.util.Scanner;

public class Main {

    public int solution(String str) {

        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }

        return Integer.valueOf(answer);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
