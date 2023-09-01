# dynamic programming

## 다이나믹 프로그래밍(Dynamic Programming) 알고리즘
- 다이나믹 프로그래밍 이란?
> 하나의 문제는 단 한 번만 풀도록 하는 알고리즘  
> 한 번 푼것을 여러 번 다시 푸는 비효율적인 알고리즘을 개선시킨 방법이다.

- 피보나치 수열의 점화식: D[i] = D[i-1] + D[i-2]

## 1. 계단오르기

### 설명
철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면  
그 방법의 수는  
1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.  
그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/10_01.png?raw=true)


### 입력
첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.

### 출력
첫 번째 줄에 올라가는 방법의 수를 출력합니다.

### 예시 입력 1
```
7
```
### 예시 출력 1
```
21
```


### 풀이
``` java
import java.util.Scanner;

public class Main {

    static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n+1];
        System.out.println(T.solution(n));
    }
}
```

## 2. 돌다리 건너기

### 설명
철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.   
철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.  
철수가 개울을 건너는 방법은 몇 가지일까요?  


![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/10_02.png?raw=true)


### 입력
첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.

### 출력
첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.

### 예시 입력 1
```
7
```
### 예시 출력 1
```
35
```

### 풀이
``` java
import java.util.Scanner;

public class Main {

    static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n+1; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n+1];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n+2];
        System.out.println(T.solution(n));
    }
}
```

## 최장 증가 부분 수열(Longest Increasing Subsequence) 알고리즘
- 최장 증가 부분 수열이란?
> 어떤 임의의 수열이 주어졌을 때, 수열에서 앞에서부터 차례대로  
> 몇 개의 숫자들을 뽑아서 부분수열을 만들 수 있다. 이렇게 만들 수 있는   
> 부분수열 중 오름차순으로 정렬된 가장 긴 수열을 최장 증가 부분 수열 이라고 한다.

## 3. 최대 부분 증가 수열

### 설명
N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰  
수로) 원소들의 집합을 찾는 프로그램을 작성하라. 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7,  
12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어 길  
이가 5인 최대 부분 증가수열을 만들 수 있다.  
### 입력
첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,  
둘째 줄은 N개의 입력데이터들이 주어진다.

### 출력
첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.

### 예시 입력 1
```
8
5 3 7 8 6 2 9 4
```

### 예시 출력 1
```
4
```

### 풀이
``` java
import java.util.Scanner;

public class Main {

    static int[] dy;

    public int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
```

