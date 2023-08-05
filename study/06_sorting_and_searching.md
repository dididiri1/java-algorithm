
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
- 버블 정렬(Bubble Sort)은 두 인접한 원소를 검사하여 정렬하는 방법이다.
- 시간 복잡도가 O(n2)로 상당히 느리지만, 코드가 단순하기 때문에 자주 사용된다.

## 예시
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

### 풀이
``` java

```