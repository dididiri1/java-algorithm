import java.util.Scanner;

/**
 *  자동완성 끄는법
 *  Settings -> Editor -> code completion -> show suggestions as you type 체크 해제
 */
public class Main {

    public int solution(String str, char c) {
        int answer = 0;

        str = str.toLowerCase();
        c = Character.toLowerCase(c);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}
