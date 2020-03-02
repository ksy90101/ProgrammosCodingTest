# [프로그래머스] 코딩테스트 연습

## [기능 개발](https://programmers.co.kr/learn/courses/30/lessons/42586)

### 간략한 문제 풀이

- 처음에는 문제를 이해하기에 조금 난해할 수 있지만, 조금만 생각하면 출제 의도를 알 수 있을 것이다.

- 일단, 레이저를 만나기 전에 나오는 `(` 이거의 갯수가 올려져 있는 쇠막대기의 갯수이다.

- 따라서 레이저를 만나기 전에 나오는 `(`의 개수만큼 절단이 나오게 될 것이다. 따라서 `(`의 개수만큼 절단 개수를 더해주면 된다.

- 그리고 `)`이게 나오게 되면 쇠막대기의 끝부분이 짤리게 될 것이다. 이것은 한개의 쇠막대기의 끝부분만 잘리는 것 이기 떄문에, +1만 해주면 된다.

- 스택을 이용하면 `(`가 나오면 갯수만큼 집어넣고, `)`이게 나오면 하나를 빼주면 되는 식으로 쉽게 문제가 풀릴 것이다.

- 사실 스택을 이용하지 않아도 충분히 풀수는 있지만, 스택/큐 문제이기 떄문에 스택으로 풀어봤다 ㅎㅎ

#### 스택(Stack)

![스택의 동작](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile25.uf.tistory.com%2Fimage%2F253AA138564FC930108483)
- push() : 스택 맨 윗부분에 원소를 집어 넣음
- pop() : 스택 맨 윗부분에 있는 요소를 꺼내고 `return`해준다.
- peek() : 스택 맨 윗부분에 있는 요소를 제거하지 않고 조회용으로 사용

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level02/IronRod.java)

### 문제 및 풀이

**문제 설명**

여러 개의 쇠막대기를 레이저로 절단하려고 합니다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자릅니다. 쇠막대기와 레이저의 배치는 다음 조건을 만족합니다.

- 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
- 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
- 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
- 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.

아래 그림은 위 조건을 만족하는 예를 보여줍니다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치, 수직으로 그려진 점선 화살표는 레이저의 발사 방향입니다.

![image0.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/dbd166625b/d3ae656b-bb7b-421c-9f74-fa9ea800b860.png)

이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있습니다.

(a) 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 '()'으로 표현합니다. 또한 모든 '()'는 반드시 레이저를 표현합니다.

(b) 쇠막대기의 왼쪽 끝은 여는 괄호 '('로, 오른쪽 끝은 닫힌 괄호 ')'로 표현됩니다.

위 예의 괄호 표현은 그림 위에 주어져 있습니다.

쇠막대기는 레이저에 의해 몇 개의 조각으로 잘리는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘리고, 이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘립니다.

쇠막대기와 레이저의 배치를 표현한 문자열 arrangement가 매개변수로 주어질 때, 잘린 쇠막대기 조각의 총 개수를 return 하도록 solution 함수를 작성해주세요.

**제한사항**

arrangement의 길이는 최대 100,000입니다.

arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.

**입출력 예**

| arrangement | return |
| :---: | :---: | 
| ()(((()())(())()))(()) | 17 |

**입출력 예 설명**

문제에 나온 예와 같습니다.

[출처](https://www.digitalculture.or.kr/koi/selectOlymPiadDissentList.do)

````java
import java.util.Stack;

/**
 * @ClassName : IronRod
 * @ProblemName : 쇠막대기
 * @URL :
 */
public class IronRod {
    public int solution(String arrangement){
        int answer = 0;
        String laserDelimiter  = arrangement.replace("()", "0");
        String[] arrangements = laserDelimiter.split("");
        Stack<String> stack = new Stack<>();

        for (String arrangementValue : arrangements) {
            if (arrangementValue.equals("(")) {
                stack.push(arrangementValue);
            } else if (arrangementValue.equals(")")) {
                stack.pop();
                answer += 1;
            } else if (arrangementValue.equals("0")) {
                answer += stack.size();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        IronRod ironRod = new IronRod();
        System.out.println(ironRod.solution(arrangement));
    }
}
````