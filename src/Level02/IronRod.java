package Level02;

import java.util.Stack;

/**
 * @ClassName : IronRod
 * @ProblemName : 쇠막대기
 * @URL :
 */
public class IronRod {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        IronRod ironRod = new IronRod();
        System.out.println(ironRod.solution(arrangement));
    }

    public int solution(String arrangement) {
        int answer = 0;
        String laserDelimiter = arrangement.replace("()", "0");
        String[] arrangements = laserDelimiter.split("");
        Stack<String> stack = new Stack<>();

        for (String arrangementValue : arrangements) {
            if (arrangementValue.equals("(")) {
                stack.push(arrangementValue);
            } else if (arrangementValue.equals(")")) {
                stack.pop();
                answer += 1;
            } else if (arrangementValue.equals("0")) {
                answer += stack.size();
            }
        }
        return answer;
    }
}
