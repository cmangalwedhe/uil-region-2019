import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jordan {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("jordan.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            int start = Integer.parseInt(file.next(), 17);
            int end = Integer.parseInt(file.next(), 17);

            int check = Integer.parseInt(file.next(), 17);
            int index = 2;

            ArrayList<Integer> out = new ArrayList<>();
            out.add(start); out.add(end);

            while (end < check) {
                int temp = end;
                end += start;
                start = temp;
                index++;
                out.add(end);
            }

            if (end == check) {
                System.out.println(index);
            } else {
                System.out.print(Integer.toString(out.get(index - 2), 17).toUpperCase());
                System.out.print(" " + Integer.toString(end, 17).toUpperCase());
                System.out.println();
            }
        }
    }
}
