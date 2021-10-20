import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        int result = 0;

        Random random = new Random(a+b);
        int intervalLength = b - a + 1;

        for (int i=0; i<n ;i++){
            result += random.nextInt(intervalLength) + a;
        }
        System.out.println(result);
    }


}