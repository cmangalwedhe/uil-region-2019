import java.io.File;
import java.io.IOException;
import java.util.*;

public class Deborah {
    static HashMap<String, List<String>> map;
    static List<String> favItems;
    static Set<String> children;
    static int maxDepth;
    static String maxString;

    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("deborah.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            map = new HashMap<>();
            favItems = new ArrayList<>();
            children = new HashSet<>();

            int limit = file.nextInt();

            for (int j = 0; j < limit; j++) {
                String parent = file.next();

                if (file.nextInt() == 1) {
                    favItems.add(parent);
                }

                int cnt = file.nextInt();
                map.put(parent, new ArrayList<>());

                for (int k = 0; k < cnt; k++) {
                    String fileName = file.next();
                    children.add(fileName);
                    map.get(parent).add(fileName);
                }
            }

            maxDepth = 0;
            maxString = "";

            for (String desktop : map.keySet()) {
                if (children.contains(desktop)) {
                    continue;
                }

                dfs(desktop, 0);
            }

            System.out.printf("%s (%d)%n", maxString, maxDepth);
        }
    }

    public static void dfs(String key, int depth) {
        if (favItems.contains(key) && (depth > maxDepth || (depth == maxDepth && key.compareTo(maxString) < 0))) {
            maxDepth = depth;
            maxString = key;
        }

        for (String neighbor : map.get(key)) {
            dfs(neighbor, depth + 1);
        }
    }
}
