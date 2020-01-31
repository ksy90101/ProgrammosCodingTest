# [프로그래머스] 코딩테스트 연습

## [평균 구하기](https://programmers.co.kr/learn/courses/30/lessons/12912)

### 간략한 문제 풀이

- stream은 코드가 간결해지지만, 속도는 느리다는 것을 또 한번 느끼게 된다. 그래도 stream으로 작성을 해본 이유는 코딩테스트 연습은 API를 효율적으로 쓰기 위해서 하기 때문입니다.

- 어려운 문제가 아니기 때문에 크게 설명할 것은 없을 꺼 같습니다.

- for문 효울성

- stream문 효율성

- [Stream average() 메소드](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/stream/DoubleStream.html#average())
    - Stream안에 있는 값들의 평균을 구할 수 있는 메소드입니다.
    
- [Stream getAsDouble() 메소드](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/OptionalDouble.html#getAsDouble())
    - 값이 있다면 Double로 변환하며, 그렇지 않으면 throw NoSuchElementException을 합니다.
    - stream 결과값을 Double로 반환해주는 메소드 입니다.
    
- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/Average.java)

### 문제 및 풀이

**문제 설명**

정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

**제한사항**

arr은 길이 1 이상, 100 이하인 배열입니다.

arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.

**입출력 예**

| arr | return |
| :---: | :---: |
| [1,2,3,4] | 2.5 | 
| [5,5] | 5 |

````
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
````