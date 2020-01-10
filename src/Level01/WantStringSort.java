package Level01;

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
