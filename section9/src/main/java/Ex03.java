import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

class Time2 implements Comparable<Time2> {

    public int time;
    public char state;

    public Time2(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time2 ob) {
        if (this.time == ob.time) {
            return this.state - ob.state;
        } else {
            return this.time - ob.time;
        }
    }
}

public class Ex03 {

    public int solution(ArrayList<Time2> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for (Time2 ob : arr) {
            System.out.println(ob.time + " "+ ob.state);
            if (ob.state == 's') {
                cnt ++;
            } else {
                cnt --;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03 T = new Ex03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time2> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new Time2(sT, 's'));
            arr.add(new Time2(eT, 'e'));
        }
        System.out.println(T.solution(arr));
    }
}