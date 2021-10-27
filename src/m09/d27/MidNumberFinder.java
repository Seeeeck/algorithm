package m09.d27;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 快速获取中位数
 */
public class MidNumberFinder {
    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public MidNumberFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public double findMidNumber(){
        if(minHeap.size() == 0 && maxHeap.size() == 0){
            throw new RuntimeException();
        }
        if (minHeap.size() == maxHeap.size()){
            return minHeap.peek()*1.0/2 + maxHeap.peek()*1.0/2;
        }
        return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }

    public void insert(int ...nums){
        for (int num : nums) {
            insert(num);
        }
    }

    public void insert(int num){
        if(maxHeap.size() == 0){
            maxHeap.add(num);
            return;
        }
        if(num <= maxHeap.peek()){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }
        if(maxHeap.size() - minHeap.size() == 2){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() == 2){
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        MidNumberFinder finder = new MidNumberFinder();
        finder.insert(5,3,6,8);
        System.out.println(finder.findMidNumber());
        finder.insert(1,1,1);
        System.out.println(finder.findMidNumber());
        finder.insert(22);
        System.out.println(finder.findMidNumber());
    }
}
