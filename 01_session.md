# String(문자열)

## 1. 문자 찾기

![](https://github.com/dididiri1/data-jpa/blob/main/study/images/01_01.png?raw=true)

### Scanner 문자 입력받기
- Scanner를 이용하여 char형 변수를 직접 입력받을 수 없다.
- char c = kb.next().charAt(0);
``` java
Scanner kb = new Scanner(System.in);
String str = kb.next();
char c = kb.next().charAt(0);
``` 

### 향상된 for문 & toCharArray
- String(문자열)을 char(문자)형 배열로 바꾼다.
``` java
for (char c : str.toCharArray()) {
    if (c == t) {
        answer++;
    }
}
``` 

### 대소문자 변환
- toLowerCase() 소문자 변환
- toUpperCase() 대문자 변환
``` java

String str = "computercooler"

System.out.println("str.toLowerCase() = " + str.toLowerCase());
System.out.println("str.toUpperCase() = " + str.toUpperCase());

```

## 2. 대소문자 변환

### 대소문자 구분 클래스
``` java
public String solution(String str) {
    String answer= "";
    
    for (char c : str.toCharArray()) {
        if (Character.isUpperCase(c)) { // 대문자이면.
            answer += Character.toLowerCase(c);
        } else {
            answer += Character.toUpperCase(c);
        }
    }
    
    return answer;
}
``` 

## 3. 문장 속 단어(indexOf(), substring())

### nextLine() 
- next의 경우 공백문자를 받아들일 수가 없다.
- 공백 포함 한줄 입력 받기
``` java
public static void main(String[] args) {
    Ex03 T = new Ex03();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine(); 
    System.out.println(T.solution(str));
}
``` 
### indexOf() 
- 특정 문자 위치 찾기 
- indexOf() 는 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환하며 만약 찾지 못했을 경우 "-1"을 반환 함.

### indexOf() 
- 문자열을 특정 구분자를 기준으로 나누어 배열로 리턴해줌.

``` java
String str = "it is time to study"
String[] strArray = str.split("\\s");

for (String s : strArray) {
    System.out.println("s = " + s);
}

``` 

#### 결과
``` java
s = it
s = is
s = time
s = to
s = study
```
