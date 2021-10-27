package m09.d27;

import java.util.*;

public class RandomPool<K> {
    private final HashMap<K,Integer> keyIndexMap;
    private final HashMap<Integer,K> indexKeyMap;
    private final Random random;
    private int size;

    public RandomPool() {
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        random = new Random();
        size = 0;
    }

    public void insert(K key){
        if (!keyIndexMap.containsKey(key)){
            keyIndexMap.put(key,size);
            indexKeyMap.put(size++,key);
        }
    }

    public void delete(K key){
        if (keyIndexMap.containsKey(key)){
            int index = this.keyIndexMap.get(key);
            int lastIndex = --size;
            K lastKey = indexKeyMap.get(lastIndex);
            indexKeyMap.put(index,lastKey);
            keyIndexMap.put(lastKey,index);
            indexKeyMap.remove(lastIndex);
            keyIndexMap.remove(key);
        }
    }

    // 随机获取一个key
    public K getRandom(){
        if (size == 0){
            return null;
        }
        int randomIndex = random.nextInt(size);
        return indexKeyMap.get(randomIndex);
    }

}
