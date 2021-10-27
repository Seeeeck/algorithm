package m07.d20;
// time O(N*logN) space O(logN)  无稳定性
public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    // arr[L...R] 排序
    private static void quickSort(int[] arr,int L,int R){
        if (L < R){
            swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1); // < 区
            quickSort(arr,p[1]+1,R); // > 区
        }
    }
    //默认以arr[R]做划分,划分为[小于arr[R],等于arr[R],大于arr[R]]
    //返回 等于区域 的左右边界下标
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;// 小于区右边界
        int more = R;// 大于区左边界
        if (arr[L] < arr[R]){   //L表示当前数的位置, arr[R] 划分值
            swap(arr,++less,L++);
        }else if (arr[L] > arr[R]){
            swap(arr,--more,L);
        }else {
            L++;
        }
        swap(arr,more,R);
        return new int[] {less+1,more};
    }

    private static void swap(int[] arr,int index1,int index2){
        if (index1 != index2){
            int data = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = data;
        }
    }
}
