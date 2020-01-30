package Level01;

/**
 * @ClassName : CollatzConjecture
 * @ProblemName : 콜라츠 추측
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12943
 */
public class CollatzConjecture {
    public int solution(long num){
        int answer = 0;
        while (num != 1){
            num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
            answer++;
            if(answer == 500){
                answer = -1;
                break;
            }
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        CollatzConjecture collatzConjecture = new CollatzConjecture();
        long n1 = 6;
        long n2 = 16;
        long n3 = 626331;

        System.out.println(collatzConjecture.solution(n1));
        System.out.println(collatzConjecture.solution(n2));
        System.out.println(collatzConjecture.solution(n3));
    }
}
