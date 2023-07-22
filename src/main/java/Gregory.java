import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Gregory {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("gregory.dat"));

        String highestLowest = file.nextLine();
        String specialCharacters = file.nextLine();

        ArrayList<String> commonPasswords = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String[] ary = file.nextLine().split(",");
            commonPasswords.addAll(Arrays.asList(ary));
        }

        while (file.hasNextLine()) {
            String password = file.nextLine();
            char[] ary = password.toCharArray();

            int[] hist = new int[4];

            for (char c: ary) {
                if (Character.isLowerCase(c))
                    hist[0]++;
                else if (Character.isUpperCase(c))
                    hist[1]++;
                else if (Character.isDigit(c))
                    hist[2]++;
                else if (specialCharacters.contains("" + c))
                    hist[3]++;
            }

            boolean check = Arrays.stream(hist).filter(x -> x != 0).count() >= 3;

            if (commonPasswords.contains(password.toLowerCase()) || !check || password.length() < 8) {
                System.out.printf("%s:%d:%S\n", password, 0, "unacceptable");
                continue;
            }

            int score = 0;

            for (int j = 0; j < highestLowest.length() / 2; j++) {
                if (password.toUpperCase().contains(highestLowest.substring(j, j+1))) {
                    int cnt = 0;

                    for (int k = 0; k < password.length(); k++)
                        if (password.toUpperCase().charAt(k) == highestLowest.charAt(j))
                            cnt++;

                    score += cnt;
                }

            }

            for (int j = highestLowest.length() / 2; j < highestLowest.length(); j++) {
                if (password.toUpperCase().contains(highestLowest.substring(j, j+1))) {
                    int cnt = 0;

                    for (int k = 0; k < password.length(); k++)
                        if (password.toUpperCase().charAt(k) == highestLowest.charAt(j))
                            cnt += 2;

                    score += cnt;
                }
            }

            for (char c: ary) {
                if (Character.isDigit(c))
                    score += 2;
                else if (specialCharacters.contains("" + c))
                    score += 3;

            }

            score += 2 * (password.length() - 8);

            if (Arrays.stream(hist).filter(x -> x > 0).count() == 4)
                score += 5;


            for (int j = 0; j < ary.length - 1; j++) {
                char c = ary[j], d = ary[j+1];
                if (Character.isUpperCase(c) && !Character.isUpperCase(d))
                    score += 2;
                else if (Character.isLowerCase(c) && !Character.isLowerCase(d))
                    score += 2;
                else if (Character.isDigit(c) && !Character.isDigit(d))
                    score += 2;
                else if (specialCharacters.indexOf(c) > -1 && specialCharacters.indexOf(d) == -1) {
                    score += 2;
                }

                else if (specialCharacters.indexOf(c) == -1 && specialCharacters.indexOf(d) > -1)
                    score += 2;
            }

            for (int j = 0; j < ary.length - 1; j++) {
                char c= ary[j], d = ary[j+1];

                if (c == d)
                    score--;
            }

            for (int j = 0; j < ary.length - 2; j++) {
                char c = ary[j], d = ary[j+1], e = ary[j+2];

                if (d == c + 1 && e == d + 1)
                    score -= 5;
            }

            String ranking;

            if (score <= 0)
                ranking = "unacceptable";
            else if (score >= 1 && score <= 15)
                ranking = "weak";
            else if (score >= 16 && score <= 30)
                ranking = "fair";
            else if (score >= 31 && score <= 45)
                ranking = "good";
            else
                ranking = "strong";

            System.out.printf("%s:%d:%S\n", password, score, ranking);
        }
    }
}