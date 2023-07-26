import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {
        int[] arr = {1,3,3,2,2,5,1};

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]); // 추가
        }

        System.out.println("stack.pop() = " + stack.pop()); // 마지막 삭제
        System.out.println("stack.peek() = " + stack.peek());// 마지막 조회
        System.out.println("stack.isEmpty() = " + stack.isEmpty()); // 비어있는지 확인, true, false
    }
}
