# Array(1, 2차원 배열)

## 1. 큰 수 출력하기

### 설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)

### 입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

### 출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

### 예시 입력 1 
```
6
7 3 9 5 6 12
```

### 예시 출력 1
```
4
7 9 6 12
```

### 풀이
``` java
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (Integer x : T.solution(n, arr)) {
            System.out.println(x+" ");
        }
    }
}

```

## 2. 보이는 학생

### 설명
선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는

선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

### 입력
첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.

### 출력
선생님이 볼 수 있는 최대학생수를 출력한다.

### 예시 입력 1
```
8
130 135 148 140 145 150 150 153
```
### 예시 출력 1
```
5
```

### 풀이
``` java
import java.util.Scanner;

class Main {
    public int solution(int n, int[] arr) {
        int answer = 1, max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                answer ++;
                max = arr[i];
            }
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

        System.out.println(T.solution(n, arr));

    }
}

``` 

## 3. 가위 바위 보
### 설명
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.

가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

예를 들어 N=5이면

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/02_01.png?raw=true)


두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.

### 입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.

세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.

### 출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.

### 예시 입력 1
``` 
5
2 3 3 1 3
1 1 2 2 3
``` 
### 예시 출력 1
``` 
A
B
A
B
D
```

### 풀이
``` java
import java.util.Scanner;

class Main {
    public String solution(int n, int[] a, int[] b) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer += "D";
            } else if(a[i] == 1 && b[i] == 3) {
                answer += "A";
            } else if(a[i] == 2 && b[i] == 1) {
                answer += "A";
            } else if(a[i] == 3 && b[i] == 2) {
                answer += "A";
            } else {
                answer += "B";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            b[i] = kb.nextInt();
        }

        for(char x : T.solution(n, a, b).toCharArray()) {
            System.out.println(x+" ");
        }

    }
}
``` 

## 4. 피보나치 수열
### 설명
1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

### 입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

### 출력
첫 줄에 피보나치 수열을 출력합니다.

### 예시 입력 1
``` 
10
``` 
### 예시 출력 1
``` 
1 1 2 3 5 8 13 21 34 55
``` 

### 풀이
``` java
import java.util.Scanner;

class Main {

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
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for (int x : T.solution(n)) {
            System.out.println(x+" ");
        }
    }
}

```

### 풀이
- 변수를 이용한 방법 
``` java
    public int[] solution(int n) {
        int[] answer = new int[n];
        int a= 1, b = 1, c;

        for (int i = 0; i < n; i++) {
            answer[i] = a;
            c = a + b;
            a = b;
            a = c;
        }

        return answer;
    }
``` 

## 5. 소수(에라토스테네스 체)
- 에라토스체네스의 체는 가장 대표적인 **소수(Prime Number 판별 알고리즘**이다.

### 설명
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

### 입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


### 출력
첫 줄에 소수의 개수를 출력합니다.

### 예시 입력 1
```
20
``` 
### 예시 출력 1
``` 
8
```

### 1. 모든 경우의 수를 돌면 약수 검증  
- 시간복잡도 O(N)

```java
import java.util.Scanner;

class Main {

    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (isPrimeNumber(i)) {
                answer ++;
            }
        }

        return answer;
    }
    
    private boolean isPrimeNumber(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}

```

### 2. 제곱근 까지만 약수 검증
- 시간복잡도 O(N^(1/2))
``` java
private boolean isPrimeNumber(int x) {
    int end = (int) Math.sqrt(x);
    for (int i = 2; i <= end; i++) {
        if (x % i == 0) {
            return false;
        }
    }
    
    return true;
}
```

### 3. 에라토스테네스의 체
``` java
import java.util.Scanner;

class Main {

    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n+1];

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer ++;
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}

```

### 4. 에라토스테네스의 체
``` java
import java.util.Scanner;

class Main {
    
    public int solution(int n) {
        int answer = 0;
        int[] a = new int[n];

        for (int i = 2; i < n; i++) {
            a[i] = i;
        }

        for (int i = 2; i < n; i++) {

            if (a[i] == 0) {
                continue;
            }

            for (int j = i + i; j < n; j = j + i) {
                a[j] = 0;
            }
        }
        
        for (int i = 2; i < n; i++) {
            if (a[i] != 0) {
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}

```