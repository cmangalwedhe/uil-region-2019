import java.util.*;
import java.io.*;

public class Vova {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("vova.dat"));
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            long x1 = scanner.nextLong();
            long y1 = scanner.nextLong();
            long x2 = scanner.nextLong();
            long y2 = scanner.nextLong();
            long L = scanner.nextLong();
            long C = Math.abs(y2 - y1) + Math.abs(x2 - x1);

            if (L < C || (L - C) % 2 == 1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}