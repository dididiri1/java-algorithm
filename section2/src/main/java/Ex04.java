import java.util.Scanner;

class Ex04 {

    // 내풀이
//    public int[] solution(int n) {
//        int[] answer = new int[n];
//
//        int num1= 1;
//        int num2= 1;
//
//        for (int i = 0; i < n; i++) {
//            answer[i] = num1;
//            int sum = num1 + num2;
//            num1 = num2;
//            num2 = sum;
//        }
//
//        return answer;
//    }

    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex04 T = new Ex04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for (int x : T.solution(n)) {
            System.out.println(x+" ");
        }
    }
}
