// Time Complex city=Big O(n^2)
public class QuestionOne {
    public static void main(String[] args) {
        int input[] = { -4, 1, 3, -2, -1 };
        System.out.println(findZeroSum(input));
    }

    public static String findZeroSum(int input[]) {
        int inital = 0;
        int end = 0;
        boolean found = false;
        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = i; j < input.length; j++) {
                sum += input[j];
                if (sum == 0) {
                    inital = i;
                    found = true;
                    end = j;
                    break;
                }
            }
        }
        if (found == false) {
            return "“No Elements found";
        }
        String result = "";
        for (int i = inital; i <= end; i++) {
            result += input[i] + ",";
        }
        return result;
    }
}