package m10.d23;

/**
 * 1-26对应a-z,给一个数字,求转化成字符串有多少种方法
 */
public class DP1 {

    public static int count1(int num){
        char[] chars = String.valueOf(num).toCharArray();
        return process(chars,0);
    }

    public static int process(char[] str,int index){
        if (index == str.length){
            return 1;
        }
        if (str[index] == 0){
            return 0;
        }
        int res = 0;
        if (index == str.length-1 || (index+1 < str.length && str[index+1] != '0')){
            res = process(str,index+1);
        }
        if (index+1 < str.length && (str[index]-'0')*10+str[index+1]-'0' <= 26){
            res += process(str,index+2);
        }
        return res;
    }

    public static int count2(int num){
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length+1];
        dp[chars.length] = 1;
        for (int i = chars.length-1; i >= 0; i--) {
            if(chars[i] != 0){
                if (i == chars.length-1 || (i+1 < chars.length && chars[i+1] != '0')){
                    dp[i] = dp[i+1];
                }
                if (i+1 < chars.length && (chars[i]-'0')*10+chars[i+1]-'0' <= 26){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int a = 1020322;
        System.out.println(count1(a));
        System.out.println(count2(a));
    }
}
