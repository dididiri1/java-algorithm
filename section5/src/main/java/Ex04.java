import java.util.*;

public class Ex04 {

    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
                // stack.push(Character.getNumericValue(x)); char를 int로 변경
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (x == '+') {
                    stack.push(lt+rt);
                } else if (x == '-') {
                    stack.push(lt-rt);
                } else if (x == '*') {
                    stack.push(lt*rt);
                } else if (x == '/') {
                    stack.push(lt/rt);
                }
            }
        }

        answer = stack.get(0);

        return answer;
    }

    public static void main(String[] args) {
        Ex04 T = new Ex04();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}