# [프로그래머스] 코딩테스트 연습

## [K번째수](https://programmers.co.kr/learn/courses/30/lessons/42840)

### 간략한 문제 풀이

- 이번문제를 풀면서 배운 점은 Arrays.copyOfRange()메소드 입니다.

- 인자로 복사할 배열과 범위를 받아서 배열을 새로 만들어 주는 메소드입니다.

- 문제의 목적은 정렬이였습니다.

- 개인적으로 나중에 정렬 알고리즘을 한번 직접 구현봐야 되겠습니다.

- Arrays.sort()메소드는 배열을 정렬해주는 메소드입니다.

- [Arrays 메소드](http://tcpschool.com/java/java_api_arrays)

- 효율성이 너무 떨어지네요. 알고리즘 문제를 풀면서 효율성도 생각을 해야 되는데, 효율성을 높일 수 있는 방법을 연구해야 되겠습니다 ㅠㅠ

### 문제 및 풀이

**문제 설명**

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.

1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.

2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

**제한사항**

array의 길이는 1 이상 100 이하입니다.

array의 각 원소는 1 이상 100 이하입니다.

commands의 길이는 1 이상 50 이하입니다.

commands의 각 원소는 길이가 3입니다.

**입출력 예**
| array | commands | return |
| :---: | :---: | :---: |
| [1, 5, 2, 6, 3, 7, 4] | [[2, 5, 3], [4, 4, 1], [1, 7, 3]] | [5, 6, 3] |

**입출력 예 설명**

[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.

[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.

[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

[출처](https://neerc.ifmo.ru/subregions/northern.html)

````
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : KNumber
 * @ProblemName : k번째수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList();

        for (int[] command : commands) {
            int[] tempArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tempArray);
            answerList.add(tempArray[command[2] - 1]);
        }

        answer = answerList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        KNumber kNumber = new KNumber();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(kNumber.solution(array, commands)));
    }
}
````