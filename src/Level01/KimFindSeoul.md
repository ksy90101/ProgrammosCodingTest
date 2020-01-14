# [프로그래머스] 코딩테스트 연습

## [체육복](https://programmers.co.kr/learn/courses/30/lessons/42862)

### 간략한 문제 풀이

- 중복값 제거와 검색을 사용해서 풀었긴 했는데, 조금 어려웠습니다.

- 이 알고리즘 문제는 탐욕법(Greedy)를 사용하는 문제입니다.

- [탐욕법(Greedy) 자세히 보기](https://mygumi.tistory.com/121)

- 또한 자바 API은 Math.abs()메소드에 대해서 배울 수 있었습니다.

- 절대값을 return해주는 메소드로, 알고리즘 문제에 처음으로 도입해봤습니다.

- 복잡해 보이기도하고, 실제로 무식하게 접근하는 방식이여서... 차후 변경해봐야 될것 같습니다 ㅠㅠ

- [Math.abs()](https://to-paz.tistory.com/276)

### 문제 및 풀이

**문제 설명**

점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

**제한사항**

전체 학생의 수는 2명 이상 30명 이하입니다.

체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.

여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.

여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.

여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

**입출력 예** 

| n | lost | reserve | return |
| :---: | :---: | :---: | :---: |
| 5 | [2, 4] | [1, 3, 5] | 5 |
| 5 | [2, 4] | [3]	4 |
| 3 | [3] | [1] | 2 |

**입출력 예 설명**

**예제 #1**

1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

**예제 #2**

3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

[출처](https://hsin.hr/coci/archive/2009_2010/contest6_tasks.pdf)

````
/**
 * @ClassName : GymSuit
 * @ProblemName : 체육복
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class GymSuit {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for (int j = 0; j < reserve.length; j++) {
            for (int i = 0; i < lost.length; i++) {
                if (lost[i] == -1 || reserve[j] == -1) {
                    continue;
                }

                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        GymSuit gymSuit = new GymSuit();
        System.out.println(gymSuit.solution(n1, lost1, reserve1));
        System.out.println(gymSuit.solution(n2, lost2, reserve2));
        System.out.println(gymSuit.solution(n3, lost3, reserve3));
    }
}

````