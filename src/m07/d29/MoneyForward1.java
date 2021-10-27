package m07.d29;

import java.util.ArrayList;
import java.util.Scanner;

public class MoneyForward1 {

    public static void main(String[] args) {
        String[] lines = getStdin();
        String numStr = lines[0];
        printNumAsEnglish(numStr);
    }

    private static void printNumAsEnglish(String numStr){
        int pointIndex = numStr.indexOf(".");
        if (pointIndex != -1){
            String[] strings = numStr.split("\\.");
            try {
                int i = Integer.parseInt(strings[0]);
                int decimal = Integer.parseInt(strings[1]);

            }catch (Exception e){
                System.out.println(-1);
            }
        }else {
            try {
                int i = Integer.parseInt(numStr);
            }catch (Exception e){
                System.out.println(-1);
            }

        }
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
