import java.io.*;
import java.math.*;
import java.util.*;

public class Mateusz {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("mateusz.dat"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            long[][] data = new long[N][4];
            for (int j = 0; j < N; j++) {
                data[j][0] = scanner.nextLong();
                data[j][1] = scanner.nextLong();
                data[j][2] = scanner.nextLong() + data[j][0];
                data[j][3] = scanner.nextLong() + data[j][1];
            }
            System.out.println("Case #" + (i + 1) + ": The total area is " + solve(data) + ".");
        }
    }

    public static long solve(long[][] data) {
        long result = 0;
        long currentX = 0;
        TreeMap<Long, ArrayList<int[]>> xmap = new TreeMap<>();
        TreeMap<Long, Integer> ymap = new TreeMap<>();
        for (int i = 0; i < data.length; i++) {
            if (!xmap.containsKey(data[i][0])) xmap.put(data[i][0], new ArrayList<>());
            xmap.get(data[i][0]).add(new int[]{i, 1});
            if (!xmap.containsKey(data[i][2])) xmap.put(data[i][2], new ArrayList<>());
            xmap.get(data[i][2]).add(new int[]{i, -1});
        }

        for (long x : xmap.keySet()) {
            long currentY = 0;
            long count = 0;
            long sum = 0;
            for (long y : ymap.keySet()) {
                if (count > 0) sum += y - currentY;
                currentY = y;
                count += ymap.get(y);
            }
            result += (x - currentX) * sum;
            currentX = x;
            for (int[] a : xmap.get(x)) {
                ymap.merge(data[a[0]][1], 1 * a[1], Integer::sum);
                ymap.merge(data[a[0]][3], -1 * a[1], Integer::sum);
            }
        }
        return result;
    }
}