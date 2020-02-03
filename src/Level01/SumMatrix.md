# [프로그래머스] 코딩테스트 연습

## [행렬의 덧셈](https://programmers.co.kr/learn/courses/30/lessons/12950)

### 간략한 문제 풀이

- 2차원 배열을 이해하기 쉬운 문제이지만, 제가 푼 코드는 조금 깔끔해보이지 않는 코드인 것 같습니다.

- 크게 설명할 부분은 없는 문제인 듯합니다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/SumMatrix.java)
    
### 문제 및 풀이

**문제 설명**

행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

**제한 조건**

행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.

**입출력 예**

| arr1 | arr2 | return |
| :---: | :---: | :---: |
| [[1,2],[2,3]] | [[3,4],[5,6]] | [[4,6],[7,9]] |
| [[1],[2]] | [[3],[4]] | [[4],[6]] |

````
import java.util.Arrays;

/**
 * @ClassName : SumMatrix
 * @ProblemName : 행렬의 덧셈
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12950
 */
public class SumMatrix {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        SumMatrix sumMatrix = new SumMatrix();
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};
        int[][] arr3 = {{1}, {2}};
        int[][] arr4 = {{3}, {4}};

        int[][] answer1 = sumMatrix.solution(arr1, arr2);
        int[][] answer2 = sumMatrix.solution(arr3, arr4);

        for (int i = 0; i < answer1.length; i++) {
            System.out.println(Arrays.toString(answer1[i]));
        }

        for (int i = 0; i < answer2.length; i++) {
            System.out.println(Arrays.toString(answer2[i]));
        }
    }
}
````