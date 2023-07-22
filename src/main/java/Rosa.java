import java.io.File;
import java.io.IOException;
import java.util.*;

public class Rosa {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("rosa.dat"));
        int N = file.nextInt();
        file.nextLine();

        for (int i = 0; i < N; i++) {
            String key = file.nextLine();
            String fileOne = file.nextLine();

            TreeMap<String, String> one = new TreeMap<>();
            TreeMap<String, String> two = new TreeMap<>();

            String line = file.nextLine();
            String[] split = line.split(",");
            int index = -1;

            for (int j = 0; j < split.length; j++) {
                if (split[j].equals(key)) {
                    index = j;
                    break;
                }
            }

            one.put(split[index], line);

            String lines;

            while (!(lines = file.nextLine()).equals("EOF")) {
                String[] cool = lines.split(",");
                one.put(cool[index], lines);
            }

            String fileTwo = file.nextLine();

            while (!(lines = file.nextLine()).equals("EOF")) {
                String[] cool = lines.split(",");
                two.put(cool[index], lines);
            }

            String a = fileOne.split(" ")[1];
            String b = fileTwo.split(" ")[1];

            System.out.printf("File %s Missing from File %s%n", a, b);

            for (String keys: one.keySet()) {
                if (!two.containsKey(keys)) {
                    System.out.println(one.get(keys));
                }
            }

            System.out.printf("File %s Missing from File %s%n", b, a);

            for (String keys: two.keySet()) {
                if (!one.containsKey(keys)) {
                    System.out.println(two.get(keys));
                }
            }

            System.out.println("Difference between Files");

            for (String keys: one.keySet()) {
                if (two.containsKey(keys)) {
                    if (!(one.get(keys).equals(two.get(keys)))) {
                        System.out.println(one.get(keys));
                        System.out.println(two.get(keys));
                    }
                }
            }
        }
    }
}
