import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            stack.push(x);
        }

        for (char x : stack) {

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