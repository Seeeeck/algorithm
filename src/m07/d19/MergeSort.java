package m07.d19;
// time O(N*logN) space O(N) 有稳定性
public class MergeSort {


    /**
     * 归并排序
     * @param arr
     */
    public static void sort(int[] arr){
        process(arr,0, arr.length-1);
    }

    private static void process(int[] arr,int L,int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (i=0;i < arr.length;i++){
            arr[L+i] = help[i];
        }
    }
}
