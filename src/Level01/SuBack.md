# [프로그래머스] 코딩테스트 연습

## [수박수박수박수박수박수?](https://programmers.co.kr/learn/courses/30/lessons/12922)

### 간략한 문제 풀이

- 어렵지 않았던 문제입니다. Level1를 많이 풀다보니, 이런 문제는 이제는 많이 익숙해진 것 같습니다.

- 문자열 연산에서는 String보다는 StringBuffer를 사용하는 것이 효율적으로 훨씬 더 좋기 때문에 최대한 StringBuffer를 사용하려고 노력하고 있습니다.
    
- 수학적인 알고리즘으로 접근해서 풀었던 다른 사람의 풀이가 있기 때문에, 그걸 추가하겠습니다,

````
new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
````

- replace()는 특정문자열을 찾아 다른 문자열로 변경하는 것이며, substring()은 문자열을 자르는 메서드입니다.

- 문자(Character)의 기본값은 '\0'(null character) 입니다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/SuBack.java)
    
### 문제 및 풀이

**문제 설명**

길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

**제한 조건**

n은 길이 10,000이하인 자연수입니다.

**입출력 예**

| n | return | 
| :---: | :---: | 
| 3 | 수박수 | 
| 4 | 수박수박 | 
````
/**
 * @ClassName : SuBack
 * @ProblemName : 수박수박수박수박수박수?
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12922
 */
public class SuBack {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();
        final char SU = '수';
        final char BACK = '박';

        for (int i = 1; i <= n; i++) {
            answer.append((i % 2 == 0)?BACK : SU);
        }
        return answer.toString();
    }

    // Test Case
    public static void main(String[] args) {
        SuBack suBack = new SuBack();
        int n1 = 3;
        int n2 = 4;

        System.out.println(suBack.solution(n1));
        System.out.println(suBack.solution(n2));

    }
}
````