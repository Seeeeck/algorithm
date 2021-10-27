package m07.d21;

import java.util.PriorityQueue;

//小根堆
public class HeapSort2 {
    public static void main(String[] args) {

    }
    /**
     * 一个比较有序的数组,数组中的每一个值在拍完序后的位置与原先位置相差不超过k,对其进行排序
     * 做法:
     * 初始值i=0
     * 1. 把0到k的值放入小根堆,并弹出头部值放在第i位
     * while k+i没有越界
     *      把k+i的值放入小根堆,并弹出头部放到i
     * 剩下的值依次弹出,放到i
     * @param arr
     */
    public static void heapSort(int[] arr,int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index <Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(;index < arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}
