import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int n = scan.nextInt();
        int k = scan.nextInt();
        int result = 0;

        List<Integer> max = new ArrayList<>();
        for (int i = a; i<=b; i++){
            Random r = new Random(i);
            List<Integer> groupJ=new ArrayList<>();
            for (int j = 0 ; j<n; j++){

                groupJ.add(r.nextInt(k));
            }
           max.add(Collections.max(groupJ));
        }
        System.out.println(max.indexOf(Collections.min(max))+a);
        System.out.println(Collections.min(max));
    }
}