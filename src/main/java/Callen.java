import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Callen {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("callen.dat"));

        while (file.hasNextLine()) {
            String[] split = file.nextLine().split(" ");
            int temp1, temp2, tStep, wind1, wind2, wStep;
            int[] ary = new int[split.length];

            for (int i = 0; i < ary.length; i++) {
                ary[i] = Integer.parseInt(split[i]);
            }

            temp1 = Math.min(ary[0], ary[1]);
            temp2 = Math.max(ary[0], ary[1]);
            tStep = ary[2];
            wind1 = Math.min(ary[3], ary[4]);
            wind2 = Math.max(ary[3], ary[4]);
            wStep = ary[5];

            System.out.printf("%18s%n", "Wind Speeds");
            System.out.printf("%7s", "Temps");

            for (int j = wind1; j <= wind2; j += wStep)
                System.out.printf("%7d", j);

            System.out.println();

            for (int j = temp2; j >= temp1; j -= tStep) {
                System.out.printf("%7d", j);
                for (int k = wind1; k <= wind2; k += wStep) {
                    double windChill = 35.74 + (0.6215 * j) - (35.75 * Math.pow(k, 0.16)) + (0.4275 * j * Math.pow(k, .16));
                    System.out.printf("%7.1f", windChill);
                }

                System.out.println();
            }

            System.out.println("*".repeat(25));
        }
    }
}
