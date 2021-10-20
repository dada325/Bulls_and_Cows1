import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

// write your code here
        long k = scan.nextLong();
        double n = scan.nextDouble();
        double m = scan.nextDouble();

        boolean check = true;

        while(check) {

            Random random = new Random(k);
            for (int i = 0; i < n; i++) {
                if (random.nextGaussian() > m) {
                    break; }
                if (i == (n-1)) {
                    check = false; }
            }
            k++;

        }

        System.out.println(k-1);

    }
}