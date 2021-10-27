package m09.d28;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class UnionFind<V> {
    private final Map<V,Element<V>> elementMap;
    // key 某元素,value 该元素的父元素
    private final Map<Element<V>,Element<V>> fatherMap;
    // key 某个集合的代表元素,value 该集合的size
    private final Map<Element<V>,Integer> sizeMap;

    public UnionFind(@NotNull Collection<V> collection) {
        if (collection.isEmpty()){
            throw new RuntimeException();
        }
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V v : collection) {
            Element<V> element = new Element<>(v);
            elementMap.put(v,element);
            fatherMap.put(element,element);
            sizeMap.put(element,1);
        }
    }

    public boolean isSameSet(V v1,V v2){
        if (elementMap.containsKey(v1) && elementMap.containsKey(v2)){
            return findHead(elementMap.get(v1)) == findHead(elementMap.get(v2));
        }
        return false;
    }

    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> path = new Stack<>();
        path.push(element);
        Element<V> father = fatherMap.get(element);
        while (father != element){
            path.push(father);
            father = fatherMap.get(father);
        }
        while (!path.isEmpty()){
            fatherMap.put(path.pop(),father);
        }
        return father;
    }

    public void union(V v1,V v2){
        if (elementMap.containsKey(v1) && elementMap.containsKey(v2)){
            Element<V> f1 = findHead(elementMap.get(v1));
            Element<V> f2 = findHead(elementMap.get(v2));
            if (f1 != f2){
                Integer f1Size = sizeMap.get(f1);
                Integer f2Size = sizeMap.get(f2);
                Element<V> big = f1Size >= f2Size ? f1 : f2;
                Element<V> small = big == f1 ? f2 : f1;
                fatherMap.put(small,big);
                sizeMap.put(big,f1Size + f2Size);
                sizeMap.remove(small);
            }
        }
    }

    private static class Element<V> {
        private final V value;

        public Element(V value) {
            this.value = value;
            boolean t;
        }
    }
}
