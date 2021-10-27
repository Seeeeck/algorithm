package m09.d21;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        int begin = 0;
        int maxLen = 1;
        char[] charArray = s.toCharArray();
        // 先枚举子串长度
        // 从小子串开始遍历
        for(int L=2;L<=len;L++){
            for(int i=0;i<len;i++){
                // 通过左边界i和子串长度L计算右边界
                int j = L + i - 1;
                if(j >= len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        longestPalindrome("bb");
    }
}
