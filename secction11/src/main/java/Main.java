import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";
        String[] strArray = str.split(" ");
        int m = Integer.MIN_VALUE;

        for(String s : strArray) {
            int len = s.length();
            if (m < len) {
                m = len;
                answer = s;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
