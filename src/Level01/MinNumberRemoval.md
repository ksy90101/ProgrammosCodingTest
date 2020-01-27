# [프로그래머스] 코딩테스트 연습

## [제일 작은 수 제거하기](https://programmers.co.kr/learn/courses/30/lessons/12935)

### 간략한 문제 풀이

- List를 이용하여 값을 제거하였으며, Stream을 이용해서 최소값을 구했습니다.

- Stream은 코드가 간결(?)해지긴 하지만, 속도문제에서는 확실히 너무 떨어지네요...

- 배열내에서 최소값을 구하고 특히 제거하는 것이 쉬운 편이 아니여서 조금 어려웠던 문제였던 것 같습니다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/MinNumberRemoval.java)

### 문제 및 풀이

**문제 설명**

정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

**제한 조건**

arr은 길이 1 이상인 배열입니다.

인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

**입출력 예**

| arr | return |
| :---: | :---: |
| [4,3,2,1] | [4,3,2] |
| [10] | [-1] |

````
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : MinNumberRemoval
 * @ProblemName : 제일 작은 수 제거하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12935
 */
public class MinNumberRemoval {
    public int[] solution(int[] arr) {
        if (arr.length > 2) {
            List<Integer> answer = Arrays.stream(arr).boxed().collect(Collectors.toList());
            int minNumberIndex = answer.indexOf(Collections.min(answer));
            answer.remove(minNumberIndex);
            return answer.stream().mapToInt(element -> element).toArray();
        }
        return new int[]{-1};
    }

    // Test Case
    public static void main(String[] args) {
        MinNumberRemoval minNumberRemoval = new MinNumberRemoval();
        int[] arr1 = {4, 3, 2, 1};
        int[] arr2 = {10};

        System.out.println(Arrays.toString(minNumberRemoval.solution(arr1)));
        System.out.println(Arrays.toString(minNumberRemoval.solution(arr2)));
    }
}
````