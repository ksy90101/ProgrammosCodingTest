# [프로그래머스] 코딩테스트 연습

## [문자열 내 마음대로 정렬하기](https://programmers.co.kr/learn/courses/30/lessons/12915)

### 간략한 문제 풀이

- sort메소드는 앞글자부터 차례로 비교하기 때문에, 비교할 문자를 맨 앞에 넣으면 그 값에 맞춰서 정렬을 할 것입니다.

- 사실 같은 문자열이 여럿 일 경우 사전순으로 앞선 문자열이 앞쪽에 위치한다는 제한 조건이 있었기 때문에 가능했습니다.

- 최근 풀었던 알고리즘 문제중에 시간이 걸렸는데, 맨처음에 생각한 방법은 compare()메소드를 이용하여 값을 하나씩 비교 하려고 했는데, 그러면 구현할 것이 너무 많아서... 다시 생각했습니다!

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/WantStringSort.java)

### 문제 및 풀이

**문제 설명**

문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

**제한 조건**

strings는 길이 1 이상, 50이하인 배열입니다.

strings의 원소는 소문자 알파벳으로 이루어져 있습니다.

strings의 원소는 길이 1 이상, 100이하인 문자열입니다.

모든 strings의 원소의 길이는 n보다 큽니다.

인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

**입출력 예**

| strings | n | return | 
| :---: | :---: | :---: | 
| [sun, bed, car] | 1 | [car, bed, sun] | 
| [abce, abcd, cdx] | 2 | [abcd, abce, cdx] | 

**입출력 예 설명**

**입출력 예 1**

sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.

**입출력 예 2**

abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다. abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.

````
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : WantStringSort
 * @ProblemName : 문자열 내 마음대로 정렬하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class WantStringSort {

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();

        for (String string : strings){
            list.add(string.charAt(n) + string);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        WantStringSort wantStringSort = new WantStringSort();

        String[] strings1 = {"sun", "bed", "car"};
        String[] strings2 = {"abce", "abcd", "cdx"};

        int n1 = 1;
        int n2 = 2;

        System.out.println(Arrays.toString(wantStringSort.solution(strings1, n1)));
        System.out.println(Arrays.toString(wantStringSort.solution(strings2, n2)));
    }
}
````