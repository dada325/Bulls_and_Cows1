package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input the length of the secret code:");
        Scanner myScanner = new Scanner(System.in);
        try{int length = myScanner.nextInt();
        System.out.print("Input the number of possible symbols in the code:");
        int lengthSum = myScanner.nextInt();

        if(lengthSum<10|| length > lengthSum){
            System.out.print("error");
            System.exit(0);
        }
        int lengthAlpha= lengthSum - 10;
        String secret = setSecret (lengthSum, length, lengthAlpha);
        char[] secretArray = secret.toCharArray();
        String as = "*";
        int out = 96 + lengthAlpha;
        char outPrint = (char)out;
        String outPrintString = String.valueOf(outPrint);

        if (lengthAlpha!=0) {
            System.out.format("The secret is prepared: %s (0-9, a-%s).", as.repeat(length), outPrintString);
            System.out.format("The secret is %s", secret);
        } else {
            System.out.format("The secret is prepared: %s (0-9).", as.repeat(length));
        }
        System.out.println("Okay, let's start a game!");
        int turn =1;

        while (true){
            System.out.format("Turn %d\n",turn);
            String input = guess();
            int [] count = count(input, secretArray);
            int bulls = count[1];
            int cows = count[0];

            if (bulls==length){
                System.out.format("Grade: %d bulls\n" +
                        "Congratulations! You guessed the secret code.\n",bulls);
                break;
            }
            System.out.format("Grade: %d bull(s) and %d cow(s)\n",bulls,cows);
            turn++;
        }}
        catch(InputMismatchException a){
            System.out.println("error");
        }


    }

    public static String setSecret (int lengthSum, int length, int lengthAlpha) {
        StringBuilder myBuilder = new StringBuilder();
        String num = mux(lengthAlpha);
        if (lengthSum > 36) {
            System.out.format("Error: can't generate a secret number with a length of %d because there aren't enough unique digits and Alphabet.", length);
            System.exit(0);
        } else {
            HashSet<String> numSet = new HashSet<>();
            while (true) {
                if (!(num.equals("0"))){

                    myBuilder.append(num);
                    numSet.add(num);
                    break;
                }

            }
            for (int i = 0; i < length-1; i++){
                while (true){
                    String newNum = mux(lengthAlpha);
                    if (!(numSet.contains(newNum))){
                        myBuilder.append(newNum);
                        numSet.add(newNum);
                        break;
                    }
                }
            }

        }
        return myBuilder.toString();
    }

    public static String mux(int lengthAlpha){
        Random r = new Random();
        int mux = r.nextInt(2);
        if(lengthAlpha != 0){
            if (mux == 0){
                return genRam();
            }else {
                return genAlpha(lengthAlpha);
            }
        }
        else {
            return genRam();
        }
    }

    public static String genRam(){

        long pseudoRandomNumber = System.nanoTime();
        String Number = Long.toString(pseudoRandomNumber);
        char[] a = Number.toCharArray();
        return String.valueOf(a[13]);
    }

    public static String  genAlpha(int lengthAlpha){
        Random r = new Random();
        int intervalLength = lengthAlpha;
        char result = 97;
        result += r.nextInt(intervalLength);
        return String.valueOf(result);
    }

    public static String guess (){
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }
    public static int[] count (String  input, char[] secret){
        int []res = new int[2];
        char[] toCheck = input.toCharArray();

        HashSet<Character> cows = new HashSet<>();
        for (int j = 0; j<secret.length; j++){
            cows.add(secret[j]);
        }

        for (int i = 0; i< toCheck.length; i++){

                if (toCheck[i] == secret[i]){
                    res[1]++;
                    cows.remove(toCheck[i]);
                }

            }
        for (int i = 0; i< toCheck.length; i++) {
            if (cows.contains(toCheck[i])) {
                res[0]++;
            }
        }
        return res;
    }
}
