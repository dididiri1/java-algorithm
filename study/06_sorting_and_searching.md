
## 정렬 알고리즘 시간 복잡도 정리
| 정렬                   | 최선        | 평균       |
|----------------------|-----------|----------|
| 선택정렬(Selection Sort) | O(n^2)    | O(n^2)   |
| 버블정렬(Bubble Sort)    | O(n^2)    | O(n^2)   |
| 삽입정렬(Insert Sort)    | O(n)      | O(n^2)   |
| 퀵정렬(Quick Sort)      | O(nlogn)  | O(nlogn) |
| 병합정렬(Merge Sort)     | O(nlogn)  | O(nlogn) |
| 힙정렬(Heap Sort)       | O(nlogn)  | O(nlogn) |

## 선택 정렬(Selection Sort)
- 값들 중에서 가장 최솟값을 찾아서 맨 왼쪽으로 채워가면서 정렬하는 방법

### 특징
- 장점
  - 구현이 간단하다
- 단점
  - 데이터가 클수록 느려짐

### 예시
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/06_01.png?raw=true)

## 1. 선택 정렬

### 설명
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

정렬하는 방법은 선택정렬입니다.

### 입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

### 출력
오름차순으로 정렬된 수열을 출력합니다.

### 예시 입력 1 
```
6
13 5 11 7 23 15
```
### 예시 출력 1
```
5 7 11 13 15 23
```

### 풀이
``` java
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n-1; i++) {
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
           int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        
        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        
        for (int x : T.solution(n, arr)) {
            System.out.println(x+ " ");
        }
    }
}
```

## 버블 정렬(Bubble Sort)
- **버블 정렬**은 주어진 **인접한 두개의 레코드 키 값을 비교하여** 그 크기에 따라 위치를 **서로 교환하는 정렬 방식**
- 계속 정렬 여부를 플래그 비트 (f)로 결정함.
- 평균과 최악 모두 수행 시간 복잡도는 O(n2)이다. 
- 코드가 단순하기 때문에 자주 사용된다.
- 시간 복잡도가 O(n2)로 상당히 느리지만, 코드가 단순하기 때문에 자주 사용된다.

## 예제
![](https://github.com/dididiri1/java-algorithm/blob/main/study/images/06_02.png?raw=true)


## 2. 버블 정렬
### 설명

N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

정렬하는 방법은 버블정렬입니다.


### 입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


### 출력
오름차순으로 정렬된 수열을 출력합니다.


### 예시 입력 1
```
6
13 5 11 7 23 15
```

### 예시 출력 1
```
5 7 11 13 15 23
```

### 풀이 1
``` java
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {

        int last = n-1;
        while (last > 0) {
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i+1]) {
                    int tmp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tmp;
                }
            }
            last --;
        }

        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }
}

```

### 풀이 2
``` java
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {

        for (int i = 0; i < n-1; i++) { // n-1 4회전
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }
}
``` 

### 풀이 3
``` java
import java.util.Scanner;

public class Main {

    private static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length - 1);
    }

    private static void bubbleSort(int[] arr, int last) {
        if (last > 0) {
            for (int i = 1; i <= last; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                }
            }
            bubbleSort(arr, last - 1);
        }
    }

    private static void swap(int[] arr, int source, int target) {
        int tmp = arr[source];
        arr[source] = arr[target];
        arr[target] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.println(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        printArray(arr);
        bubbleSort(arr);
        printArray(arr);

    }
}
``` 

## 삽입 정렬(Insert Sort)
**삽입 정렬**은 가장 간단한 정렬 방식으로 **이미 순서화된 파일에 새로운 하나의 레코드를 순서의 맞게 삽입시켜 정렬**함
- 두 번째 키와 첫 번째 키를 비교해 순서대로 나열(1회전)하고, 이어서 세 번째 키를 첫 번째,  
  두 번째 키와 비교해 순서대로 나열(2회전)하고, 계속해서 n번째 키를 앞에 n-1개의 키와 비교하여  
  알 맞은 순서에 삽입하여 정렬 하는 방식.
- 평균과 최악 모두 수행 시간 복잡도는 O(n2)이다.

## 3. 삽입 정렬
### 설명

N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

정렬하는 방법은 삽입정렬입니다.


### 입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


### 출력
오름차순으로 정렬된 수열을 출력합니다.


### 예시 입력 1
``` 
6
11 7 5 6 10 9
``` 
### 예시 출력 1
``` 
5 6 7 9 10 11
``` 

### 풀이 1
``` 
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                } 
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }
}
``` 

### 풀이 2
``` 
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {

        for (int i = 1; i < n; i++) {

            int tmp = arr[i], j;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
   
                } else {
                    break;
                }

            }
            arr[j+1] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }
}
``` 