package Level01;

/**
 * @ClassName : GymSuit
 * @ProblemName : 체육복
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class GymSuit {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for (int j = 0; j < reserve.length; j++) {
            for (int i = 0; i < lost.length; i++) {
                if (lost[i] == -1 || reserve[j] == -1) {
                    continue;
                }

                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        GymSuit gymSuit = new GymSuit();
        System.out.println(gymSuit.solution(n1, lost1, reserve1));
        System.out.println(gymSuit.solution(n2, lost2, reserve2));
        System.out.println(gymSuit.solution(n3, lost3, reserve3));
    }
}
