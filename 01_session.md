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
