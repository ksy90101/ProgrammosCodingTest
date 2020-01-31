package Level01;

import java.util.Arrays;

/**
 * @ClassName : Average
 * @ProblemName : 평균 구하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12944
 */
public class Average {
    public double solution(int[] arr){
        double answer = 0;

        // for문 이용 방법
        for (int element : arr){
            answer += element;
        }

        // Stream 이용방법
        //answer = Arrays.stream(arr).average().getAsDouble();
        return answer / arr.length;
    }

    // Test Case
    public static void main(String[] args) {
        Average average = new Average();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 5};

        System.out.println(average.solution(arr1));
        System.out.println(average.solution(arr2));
    }
}
