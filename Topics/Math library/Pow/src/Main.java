import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        String [] num1 = input.split(" ");
        double base = Double.parseDouble(num1[0]);
        double pow = Double.parseDouble(num1[1]);

        System.out.println(Math.pow(base, pow));

    }
}