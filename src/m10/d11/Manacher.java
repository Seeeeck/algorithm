package m10.d11;

/**
 * 最长回文子串的长度
 */
public class Manacher {


    public static int maxLcpsLength(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        // sdg --> #s#d#g#
        char[] str = manacherString(s);
        // 记录每个坐标的最长回文半径
        int[] pArr = new int[str.length];
        // 最大回文右边界的下一个数
        int r = -1;
        // 最大回文右边界对应的回文中心
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = r > i ? Math.min(pArr[2 * c - i],r - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1){
                if (str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > r){
                r = i + pArr[i];
                c = i;
            }
            max = Math.max(max,pArr[i]);
        }
        // 处理串的子回文串半径-1等于其原串子回文串长度
        return max - 1;
    }

    public static char[] manacherString(String str){
        char[] chars = new char[str.length() * 2 + 1];
        char[] charArray = str.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (i & 1) == 0 ? '#' : charArray[index++];
        }
        return chars;
    }
}
