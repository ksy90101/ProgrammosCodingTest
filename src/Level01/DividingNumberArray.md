# [프로그래머스] 코딩테스트 연습

## [나누어 떨어지는 숫자 배열](https://programmers.co.kr/learn/courses/30/lessons/12910)

### 간략한 문제 풀이

- 크게 어려움 없는 문제였다.

- 다른사람 풀이를 봤는데, Java Stream, 람다를 이용해서 한줄에 끝냈는데, 엄청나게 부러운 실력이다..ㅠㅠ

````
Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
````

### 문제 및 풀이

**문제 설명**

array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.

divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

**제한사항**

arr은 자연수를 담은 배열입니다.

정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.

divisor는 자연수입니다.

array는 길이 1 이상인 배열입니다.

**입출력 예**

| arr | divisor| return | 
| :---: | :---: | :---:| 
| [5, 9, 7, 10] | 5 | [5, 10] | 
| [2, 36, 1, 3] | 1 | [1, 2, 3, 36] | 
| [3,2,6] | 10 | [-1] | 

**입출력 예 설명**

**입출력 예#1**

arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

**입출력 예#2**

arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

**입출력 예#3**

3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.

````
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : dividingNumberArray
 * @ProblemName : 나누어 떨어지는 숫자 배열
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class DividingNumberArray {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> dividingNumbers = new ArrayList<>();

        int[] answer = {-1};
        for (int number : arr) {
            if (number % divisor == 0) {
                dividingNumbers.add(number);
            }
        }

        dividingNumbers.sort(null);

        if (dividingNumbers.isEmpty()) {
            return answer;
        } else {
            answer = dividingNumbers.stream().mapToInt(n -> n).toArray();
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        DividingNumberArray dividingNumberArray = new DividingNumberArray();

        int[] arr1 = {5, 9, 7, 10};
        int[] arr2 = {2, 36, 1, 3};
        int[] arr3 = {3, 2, 6};

        int divisor1 = 5;
        int divisor2 = 1;
        int divisor3 = 10;

        System.out.println(Arrays.toString(dividingNumberArray.solution(arr1, divisor1)));
        System.out.println(Arrays.toString(dividingNumberArray.solution(arr2, divisor2)));
        System.out.println(Arrays.toString(dividingNumberArray.solution(arr3, divisor3)));
    }
}
````