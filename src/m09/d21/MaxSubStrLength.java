package m09.d21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSubStrLength {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> strSet = new HashSet<>();
        int max = 0,cur = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(strSet.contains(s.charAt(j))){
                    max = Math.max(max,cur);
                    strSet.clear();
                    cur = 0;
                    break;
                }
                strSet.add(s.charAt(i));
                cur++;
            }
            max = Math.max(max,cur);
            strSet.clear();
            cur = 0;
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
