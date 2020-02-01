package Level01;

/**
 * @ClassName : HarshadNumber
 * @ProblemName : 하샤드 수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12947
 */
public class HarshadNumber {
    public boolean solution(int x){
        char[] harshads = Integer.toString(x).toCharArray();
        int harshadSum = 0;

        for (char harshad : harshads){
            harshadSum += Integer.parseInt(Character.toString(harshad));
        }

        return (x % harshadSum == 0);
    }

    // Test Case
    public static void main(String[] args) {
        HarshadNumber harshadNumber = new HarshadNumber();
        int arr1 = 10;
        int arr2 = 12;
        int arr3 = 11;
        int arr4 = 13;

        System.out.println(harshadNumber.solution(arr1));
        System.out.println(harshadNumber.solution(arr2));
        System.out.println(harshadNumber.solution(arr3));
        System.out.println(harshadNumber.solution(arr4));
    }
}
