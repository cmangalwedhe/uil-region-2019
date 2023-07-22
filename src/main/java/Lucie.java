import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Lucie {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("lucie.dat"));
        int N = file.nextInt();
        file.nextLine();

        for (int i = 0; i < N; i++) {
            Scanner chop = new Scanner(file.nextLine()).useDelimiter(",");
            int programs = chop.nextInt();
            int teams = chop.nextInt();

            int[][] mat = new int[teams + 1][programs + 1];

            for (int j = 0; j < mat[0].length - 1; j++) {
                Scanner chop2 = new Scanner(file.nextLine()).useDelimiter(",");
                int sum = 0;

                for (int k = 0; k < mat.length - 1; k++) {
                    mat[k][j] = chop2.nextInt();
                    sum += mat[k][j];
                }

                mat[mat.length - 1][j] = sum;
            }

            for (int j = 0; j < mat.length; j++) {
                int sum = 0;

                for (int k = 0; k < mat[j].length - 1; k++) {
                    sum += mat[j][k];
                }

                mat[j][mat[j].length - 1] = sum;
            }


            for (int j = 0; j < mat.length; j++) {
                StringBuilder out = new StringBuilder();

                for (int k = 0; k < (j == mat.length - 1 ? mat[j].length - 1 : mat[j].length); k++) {
                    out.append(mat[j][k]).append(',');
                }

                System.out.println(out.substring(0, out.length() - 1));
            }

            System.out.println("*".repeat(12));
        }
    }
}