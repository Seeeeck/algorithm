package m07.d20;

import java.util.Arrays;
// time O(N*logN) space O(1)  无稳定性
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,3,78,9,3,2,1,0,9,9,11,6789,36,895,3,8654,877,324,876,35287,9765,5,5,98,54,5,754,324};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        while (heapSize > 0){
            swap(arr,0,heapSize-1);
            heapify(arr,0,--heapSize);
        }

    }

    private static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void heapify(int[] arr,int index, int heapSize){
        int left = index * 2 + 1; //left child
        while (left < heapSize){
            int largest = left+1 < heapSize && arr[left+1] > arr[left] ? left+1 : left;
            if (arr[largest] <= arr[index]){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }



    private static void swap(int[] arr,int index1,int index2){
        if (index1 != index2){
            int data = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = data;
        }
    }
}
