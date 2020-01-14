package Level01;


public class KimFindSeoul {
    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        KimFindSeoul kimFindSeoul = new KimFindSeoul();

        String[] seoul = {"Jane", "Kim"};

        System.out.println(kimFindSeoul.solution(seoul));
    }
}
