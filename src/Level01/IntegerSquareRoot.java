package Level01;

/**
 * @ClassName : IntegerSquareRoot
 * @ProblemName : 정수 제곱근 판별
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12934
 */
public class IntegerSquareRoot {
    public long solution(long n){
        double nSquareRoot = Math.sqrt(n);
        long answer = 0;

        if (nSquareRoot % (long)nSquareRoot == 0){
            answer += Math.pow((nSquareRoot + 1), 2);
        }else{
            answer = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        IntegerSquareRoot integerSquareRoot = new IntegerSquareRoot();
        int n1 = 121;
        int n2 = 3;

        System.out.println(integerSquareRoot.solution(n1));
        System.out.println(integerSquareRoot.solution(n2));
    }
}
