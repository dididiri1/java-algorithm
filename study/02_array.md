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

## 6. 뒤집은 소수
### 설명
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.

예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.

첫 자리부터의 연속된 0은 무시한다.

### 입력
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.

각 자연수의 크기는 100,000를 넘지 않는다.

### 출력
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.


### 예시 입력 1
```
9
32 55 62 20 250 370 200 30 100
```
### 예시 출력 1
```
23 2 73 2 3
```

### 숫자 뒤집기
```
for (int i = 0; i < n; i++) {
    int tmp = arr[i];
    int res = 0;
    
    while (tmp > 0) {
        int t = tmp % 10; // 10으로 나눈 나머지는 항상 1 자리 이다. 123 % 10 = 3
        res = res * 10 + t;
        tmp = tmp / 10;
    }
    
    if (isPrime(res)) {
        answer.add(res);
    }
}
```

### 풀이
```
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i  == 0) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;

            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) {
                answer.add(res);
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

        for (Integer x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }

    }
}

```

## 7. 점수계산

### 설명

OX 문제는 맞거나 틀린 두 경우의 답을 가지는 문제를 말한다.

여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서 다음과 같이 점수 계산을 하기로 하였다.

1번 문제가 맞는 경우에는 1점으로 계산한다. 앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다.

또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산한다.

예를 들어, 아래와 같이 10 개의 OX 문제에서 답이 맞은 문제의 경우에는 1로 표시하고, 틀린 경우에는 0으로 표시하였을 때,

점수 계산은 아래 표와 같이 계산되어, 총 점수는 1+1+2+3+1+2=10 점이다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/02_02.png?raw=true)

시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산하는 프로그램을 작성하시오.


### 입력
첫째 줄에 문제의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 N개 문제의 채점 결과를 나타내는 0 혹은 1이 빈 칸을 사이에 두고 주어진다.

0은 문제의 답이 틀린 경우이고, 1은 문제의 답이 맞는 경우이다.


### 출력
첫째 줄에 입력에서 주어진 채점 결과에 대하여 가산점을 고려한 총 점수를 출력한다.

### 예시 입력 1
```
10
1 0 1 1 1 0 0 1 1 0
```
### 예시 출력 1
```
10
```

### 풀이
```
import java.util.Scanner;

class Main {

    public int solution(int n, int[] arr) {
        int answer = 0, cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt ++;
                answer += cnt;
            } else {
                cnt = 0;
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

        System.out.println(T.solution(n, arr));

    }
}

```

## 8. 등수구하기
### 설명

N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


### 입력
첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


### 출력
입력된 순서대로 등수를 출력한다.


### 예시 입력 1
```
5
87 89 92 100 76
```
### 예시 출력 1
```
4 3 2 1 5
```
### 풀이
```java
import java.util.Scanner;

class Main {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    cnt ++;
                }
            }
            answer[i] = cnt;
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
        
        for (int x : T.solution(n, arr)) {
            System.out.println(x+" ");
        }
    }
}
```

## 9. 격자판 최대합
### 설명

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/02_03.png?raw=true)

N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.

### 입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

### 출력
최대합을 출력합니다.

### 예시 입력 1
```
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
```
### 예시 출력 1
```
155
```

### 풀
``` java
import java.util.Scanner;

class Main {

    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
```

## 10. 봉우리
### 설명
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.

각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.

격자의 가장자리는 0으로 초기화 되었다고 가정한다.

만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/02_04.png?raw=true)


### 입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


### 출력
봉우리의 개수를 출력하세요.


### 예시 입력 1
```
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
```
### 예시 출력 1
```
10
```

### 풀이
- 시계방향 12시, 3시, 6시 9시
``` java
  int[] dx = {-1, 0, 1, 0}; // 행
  int[] dy = {0, 1, 0, -1}; // 열
```

``` java
import java.util.Scanner;

class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int n, int[][] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer ++;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}

```