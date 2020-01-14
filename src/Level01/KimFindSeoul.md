# [프로그래머스] 코딩테스트 연습

## [서울에서 김서방 찾기](https://programmers.co.kr/learn/courses/30/lessons/12919)

### 간략한 문제 풀이

- 전혀 어렵지 않는 문제였다.

- 다른 사람 풀이에서 괜찮은 코드를 찾아서 그것만 추가하려고 합니다.

````
Arrays.asList(seoul).indexOf("Kim");
````

- indexOf를 가장 먼저 생각했는데, 배열에서는 그 메소드가 없다는 걸 생각하고 나서 그냥 For문으로 돌렸습니다 ㅎㅎ

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/KimFindSeoul.java)

### 문제 및 풀이

**문제 설명**

String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요. seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

**제한 사항**

seoul은 길이 1 이상, 1000 이하인 배열입니다.

seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.

Kim은 반드시 seoul 안에 포함되어 있습니다.

**입출력 예**

| seoul | return |
| :---: | :---: |
| [Jane, Kim] |	김서방은 1에 있다 |

````
/**
 * @ClassName : KimFindSeoul
 * @ProblemName : 서울에서 김서방 찾기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12919
 */
public class KimFindSeoul {
    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        KimFindSeoul kimFindSeoul = new KimFindSeoul();

        String[] seoul = {"Jane", "Kim"};

        System.out.println(kimFindSeoul.solution(seoul));
    }
}
````