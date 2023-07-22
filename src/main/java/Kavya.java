import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kavya {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("kavya.dat"));

        while (file.hasNextLine()) {
            ArrayList<Line> list = new ArrayList<>();
            String line = file.nextLine().toUpperCase().replaceAll("\\W+", "").trim();
            String check = "";

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (check.contains(""+ c))
                    continue;

                list.add(new Line(freq(line, c), line.indexOf(c), c));

                check += c;
            }

            Collections.sort(list);

            String out = "";

            for (Line a: list) {
                out += ("" + a.letter).repeat(a.freq);
            }

            System.out.println(out);
        }
    }

    private static int freq(String line, char c) {
        int cnt = 0;

        for (int i = 0; i < line.length(); i++)
            if (line.charAt(i) == c)
                cnt++;

        return cnt;
    }
}

class Line implements Comparable<Line> {
    int freq;
    int index;
    char letter;

    public Line(int freq, int index, char letter) {
        this.freq = freq;
        this.index = index;
        this.letter = letter;
    }

    @Override
    public int compareTo(Line other) {
        if (freq < other.freq)
            return 1;
        else if (freq > other.freq)
            return -1;

        if (index > other.index)
            return 1;
        else if (index < other.index)
            return -1;

        return 0;
    }
}