# [프로그래머스] 코딩테스트 연습

## [실패율](https://programmers.co.kr/learn/courses/30/lessons/42889)

### 간략한 문제 풀이

- 지금까지 풀었던 Level1 문제중 가장 어려웠습니다. 처음 생각한 구현 방법은 '스테이지에 도달한 플레이어 수'를 구하고, '스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수'를 구하고 실패율을 구해서 정렬을 이용해 답을 도출해나갈려고 했습니다.

- 사실 처음부터 Stage라는 객체로 포장할 생각은 없었지만, 처음에 정렬과 수많은 자료구조들이 존재하게 되어서 싹다 지우고 다시 진행하게 되었습니다.

- 두번째 구현방법은 객체에 포장을 해서 실패율로 객체를 정렬하는 방법을 고민하였고, 검색 결과에 나온 대로 코드를 구현하였습니다.

- 두번째 구현 방법으로는 테스트 케이스들을 통과하기 시작했는데, 몇개에서 오류가 발생하게 되었습니다.
그 이유를 질문하기에서 찾다 보니, 제한 사항에서 '스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의한다'라는 구문을 구현하지 않았기 때문이였습니다.
제한사항을 잘 읽어 보는 것이 이제부터 중요할 것 같네요..ㅎㅎ

- Stage 객체 설명
    - 인스턴스 변수로 reachUser(도달한 유저), stayUser(머무르는 유저), stageNumber(스테이지 번호), failureRate(실패율)을 가지고 있습니다.
    - 메소드는 failureRateCalculator()로 실패율을 계산하는 메소드입니다. 
        - 마지막에 시간을 많이 잡아 먹은 제한 사항은 여기서 처리하였습니다.(스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의한다.)

- StageComparator Class
    - 객체 내 인스턴스 변수 중에 하나로 정렬을 할 수 있게 도와주는 메소드로, Comparator<>를 상속받습니다.
    - Override로 compare() 메소드를 실패율(failureRate)에 맞춰서 비교할 수 있도록 구현하였습니다.
    - 객체 내 설정한 변수 기준으로 정렬하는 방법은 차후 블로그 포스팅으로 정리 해놓는 것이 좋을 것 같습니다.
    - [참고자료](https://blog.acronym.co.kr/560)

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/FailureRate.java)

### 문제 및 풀이

**문제 설명**

![failture_rate1.png](https://grepp-programmers.s3.amazonaws.com/files/production/bde471d8ac/48ddf1cc-c4ea-499d-b431-9727ee799191.png)

슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.

실패율은 다음과 같이 정의한다.
    - 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

**제한사항**

- 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
- stages의 길이는 1 이상 200,000 이하이다.
- stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
    - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
    - 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
- 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
- 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

**입출력 예**

| N | stages | result | 
| :---: | :---: | :---: | 
| 5 | [2, 1, 2, 6, 2, 4, 3, 3] | [3,4,2,1,5] | 
| 4 | [4,4,4,4,4] | [4,1,2,3] | 

**입출력 예 설명**

**입출력 예 #1**

1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.

- 1번 스테이지 실패율 : 1/8

2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.

- 2번 스테이지 실패율 : 3/7

마찬가지로 나머지 스테이지의 실패율은 다음과 같다.

- 3번 스테이지 실패율 : 2/4
- 4번 스테이지 실패율 : 1/2
- 5번 스테이지 실패율 : 0/1

각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
- [3,4,2,1,5]

**입출력 예 #2**

모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
- [4,1,2,3]

````
package Level01;

import java.util.*;

/**
 * @ClassName : FailureRate
 * @ProblemName : 실패율
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> stageObjects = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            stageObjects.add(new Stage(i + 1));
        }
        
        for (int stage : stages) {
            for (int j = 0; j < stage; j++) {
                if (j == stage - 1 && stage > N) {
                    break;
                }
                stageObjects.get(j).reachUser++;
            }
            if (stage > N) continue;
            stageObjects.get(stage - 1).stayUser++;
        }

        for (int i = 0; i < N; i++) {
            stageObjects.get(i).failureRateCalculator();
        }

        StageComparator stageComparator = new StageComparator();
        stageObjects.sort(stageComparator);

        for (int i = 0; i < N; i++) {
            answer[i] = stageObjects.get(i).stageNumber;
        }
        
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        int N1 = 5;
        int N2 = 4;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages2 = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(failureRate.solution(N1, stages1)));
        System.out.println(Arrays.toString(failureRate.solution(N2, stages2)));
    }
}

class Stage {
    int reachUser;
    int stayUser;
    int stageNumber;
    double failureRate;

    public Stage(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public void failureRateCalculator() {
        if (reachUser == 0) {
            this.failureRate = 0.0;
            return;
        }
        this.failureRate = (double) this.stayUser / this.reachUser;
    }
}

class StageComparator implements Comparator<Stage> {
    @Override
    public int compare(Stage o1, Stage o2) {
        double firstValue = o1.failureRate;
        double secondValue = o2.failureRate;
        return Double.compare(secondValue, firstValue);
    }
}
````