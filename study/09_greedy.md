# Greedy Algorithm

## 1. 씨름 선수

### 설명
현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을   
했습니다. 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.  
현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.  
“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은
(크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”  
N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지   
알아내는 프로그램을 작성하세요.

### 입력
첫째 줄에 지원자의 수 N(5<=N<=100,000)이 주어집니다.  
두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다.     
각 선수의 키와 몸무게는 모두 다릅니다.

### 출력
첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.

### 예시 입력 1
```
5
172 67
183 65
180 70
170 72
181 60
```
### 예시 출력 1
```
3
```

### 출력 설명
> (183, 65), (180, 70), (170, 72) 가 선발됩니다. (181, 60)은 (183, 65)보다 키와   
> 몸무게 모두 낮기 때문에 탈락이고, (172, 67)은 (180, 70) 때문에 탈락입니다

### 풀이
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body> {

    public int h, w;

    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }
    
    @Override
    public int compareTo(Body o) {
        return o.h-this.h;
    }
}

public class Main {

    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;

        for (Body ob : arr) {
            if (ob.w > max) {
                max = ob.w;
                cnt ++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new Body(h, w));
        }
        System.out.println(T.solution(arr, n));
    }
}
```

## 2. 회의실 배정

### 설명
한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들  
려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하  
면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중  
단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

### 입력
첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정  
보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.  
회의 시간은 0시부터 시작된다.  
회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.

### 출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

### 예시 입력 1
```
5
1 4
2 3
3 5
4 6
5 7
```
### 예시 출력 1
```
3
```

- 예제설명
> (2, 3), (3, 5), (5, 7)이 회의실을 이용할 수 있다.

### 예시 입력 2
```
3
3 3
1 3
2 3
```
### 예시 출력 2
```
2
```

### 풀이
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {

    public int s, e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.e == o.e) {
            return this.s-o.s;
        } else {
            return this.e-o.e;
        }
    }
}

public class Main {

    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int et = 0;
        for (Time ob : arr) {
            if (ob.s >= et) {
                cnt ++;
                et = ob.e;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int e = kb.nextInt();
            int s = kb.nextInt();
            arr.add(new Time(e, s));
        }
        System.out.println(T.solution(arr, n));
    }
}
```