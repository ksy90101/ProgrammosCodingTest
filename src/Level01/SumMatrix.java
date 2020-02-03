package Level01;

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
