package m07.d25;

public class IEEE754 {
    public static void main(String[] args) {
        convert2Int("00001111");
        int convert = convert("11111");
        System.out.println(convert);
        String s = decimal2Binary(13);
        System.out.println(s);
    }
    /**
     * 浮点转十进制
     * @param num
     * @return
     */
    public static int convert2Int(String num){
//        if (num.length()!=32){
//            return -1;
//        }
        int S = num.charAt(0)-48;
        int convert = convert(num.substring(1, 9));
        int E = convert - 127;
        String res = "1";
        if (E >= 0){
            res = res+num.substring(9,10+E) + "." + num.substring(10+E,getIndex(num));
        }
        return 1;
    }

    private static int getIndex(String num){
        int index = num.length()-1;
        while (num.charAt(index)==48){
            index--;
        }
        return index;
    }

    //2转10
    private static int convert(String num){
        int sum = 0;
        int len = num.length();
        for (int i=0;i<len;i++){
            //第i位 的数字为：
            int dt = num.charAt(i)-48;
            sum+=(int)Math.pow(2,len-i-1)*dt;
        }
        return  sum;
    }


    /**
     * 讲10 进制转化为二进制
     * @param de ：待转换的十进制
     * @return   ：转换后的二进制（string）
     */
    private static String decimal2Binary(int de){
        StringBuilder numstr = new StringBuilder();
        while (de>0){
            int res = de%2; //除2 取余数作为二进制数
            numstr.insert(0, res);
            de = de/2;
        }
        return numstr.toString();
    }
}
