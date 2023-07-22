import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Nishi {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("nishi.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            String operand1 = file.next();
            String sign = file.next();
            String operand2 = file.next();

            double operandOne = Double.parseDouble(operand1);
            double operandTwo = Double.parseDouble(operand2);

            int sigfigs = Math.min(sigfigs(operand1), sigfigs(operand2));
            double res;

            if (sign.equalsIgnoreCase("x"))
                res = operandOne * operandTwo;
            else
                res = operandOne / operandTwo;

            double cool = Math.round((res * Math.pow(10, sigfigs))) / Math.pow(10, sigfigs);
            String format = String.format("%." + sigfigs + "E%n", cool);
            String out = format.substring(0, format.indexOf('E') + 1);

            if (format.charAt(format.indexOf('E') + 2) == '0')
                out += format.charAt(format.indexOf('E') + 3);
            else
                out += format.substring(format.indexOf('E') + 2);

            System.out.println(out);
        }
    }

    public static int sigfigs(String operand) {
        int sigfigs = 0;
        int i = 0;

        while (i < operand.length() && (operand.charAt(i) == '0' || operand.charAt(i) == '.'))
            i++;

        for (int j = i + 1; j < operand.length(); j++) {
            if (operand.substring(j, j + 1).matches("[1-9]")) {
                sigfigs++;
            } else if (operand.charAt(j) == '0' && (j < operand.indexOf(".") || j < operand.length() - 1)) {
                sigfigs++;
            } else if (operand.charAt(j) == '0' && j > operand.indexOf(".")) {
                if (operand.contains(".")) {
                    sigfigs++;
                }
            }
        }

        return sigfigs;
    }
}
