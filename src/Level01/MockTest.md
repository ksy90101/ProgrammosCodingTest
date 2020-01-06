# [프로그래머스] 코딩테스트 연습

## [모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840)

### 간략한 문제 풀이

- 수포자1, 2, 3의 답은 일정 패턴을 가지고 있습니다.

- 일정 패턴을 찾아서 계속 비교하면 됩니다.

- 최대값을 구하기 위해서 최근 공부하고 있는 stream을 사용했습니다.

- 모의고사 문제의 알고리즘은 완전 탐색입니다.

- [완전탐색 자세히 보기](https://brenden.tistory.com/10)

- 처음에 반복문으로 최대값을 찾다가, stream으로도 구할수 있기 때문에 stream으로 변경을 했는데, 둘 중에 뭐가 더 효율성이 좋을지는...ㅎㅎ

- 효율성이 너무 떨어지네요. 알고리즘 문제를 풀면서 효율성도 생각을 해야 되는데, 효율성을 높일 수 있는 방법을 연구해야 되겠습니다 ㅠㅠ

### 문제 및 풀이

**문제 설명**

수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...

2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...

3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

**제한 조건**

시험은 최대 10,000 문제로 구성되어있습니다.

문제의 정답은 1, 2, 3, 4, 5중 하나입니다.

가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

| 입출력 | 예 |
| :---: | :---: |
| answers | return |
| [1,2,3,4,5] | [1] |
| [1,3,2,4,2] | [1,2,3] |

**입출력 예 설명**

**입출력 예 #1**

수포자 1은 모든 문제를 맞혔습니다.

수포자 2는 모든 문제를 틀렸습니다.

수포자 3은 모든 문제를 틀렸습니다.

따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

**입출력 예 #2**

모든 사람이 2문제씩을 맞췄습니다.

````
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * @ClassName : MockTest
 * @ProblemName : 모의고사
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class MockTest {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        OptionalInt maxScore;
        List<Integer> winners = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            scores[0] += (answers[i] == student1[i % 5]) ? 1 : 0;
            scores[1] += (answers[i] == student2[i % 8]) ? 1 : 0;
            scores[2] += (answers[i] == student3[i % 10]) ? 1 : 0;
        }

        maxScore = Arrays.stream(scores).max();
        
        for (int i = 0; i < scores.length; i++) {
            if (maxScore.getAsInt() == (scores[i])) {
                winners.add(i + 1);
            }
        }

        return winners.stream().mapToInt(winner -> winner).toArray();
    }

    // Test Case
    public static void main(String[] args) {
        MockTest mockTest = new MockTest();
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(mockTest.solution(answers1)));
        System.out.println(Arrays.toString(mockTest.solution(answers2)));
    }
}

````