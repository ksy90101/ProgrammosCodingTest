package Level01;

import java.util.Scanner;

/**
 * @ClassName : RectangleStar
 * @ProblemName : 직사각형 별찍기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12969
 */
public class RectangleStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
