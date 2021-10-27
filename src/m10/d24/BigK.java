package m10.d24;

import java.util.*;

public class BigK {


    public static String[] bigK(int k,String[] str){
        if (k <= 0 || str == null || str.length == 0){
            return new String[0];
        }
        Map<String,Integer> map = new HashMap<>();
        for (String s : str) {
            if (map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else {
                map.put(s,1);
            }
        }
        Queue<Map.Entry<String,Integer>> queue = new PriorityQueue<>(k,new EntryComparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k){
                queue.add(entry);
            }else if(queue.peek().getValue() < entry.getValue()){
                queue.poll();
                queue.add(entry);
            }
        }
        return queue.stream().map(Map.Entry::getKey).toArray(String[]::new);
    }

    private static class EntryComparator implements Comparator<Map.Entry<String,Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue()-o2.getValue();
        }
    }

}
