package m09.d24;

import java.util.ArrayList;
import java.util.List;

public class ZConvert6 {

    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        List<List<Character>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }
        char[] chars = s.toCharArray();
        boolean flag = true;
        int index = 0;
        for (char aChar : chars) {
            if (flag) {
                if (index == numRows - 1) {
                    flag = false;
                    list.get(index--).add(aChar);
                    continue;
                }
                list.get(index++).add(aChar);
            } else {
                if (index == 0) {
                    flag = true;
                    list.get(index++).add(aChar);
                    continue;
                }
                list.get(index--).add(aChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : list) {
            for (Character character : characters) {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 1);
        System.out.println(paypalishiring);
    }
}
