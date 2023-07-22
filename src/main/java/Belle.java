import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Belle {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("belle.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            int a = file.nextInt(), b = file.nextInt();
            System.out.println(Math.max(a, b));
        }
    }
}
