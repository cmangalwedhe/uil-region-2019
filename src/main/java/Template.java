import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Template {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("file.dat"));
        int N = file.nextInt();
    }
}
