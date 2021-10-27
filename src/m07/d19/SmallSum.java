package m07.d19;

public class SmallSum {
    /**
     * 求数组的小和.小和:对数组上的每个数,求其左侧比其小的数的和,并把所有的和相加
     * @param arr
     */
    public static int exe(int[] arr){
        if (arr == null || arr.length <2){
            return 0;
        }
        return process(arr,0, arr.length-1);
    }

    private static int process(int[] arr,int L,int R){
        if (L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        int leftSum = process(arr,L,mid);
        int rightSum = process(arr,mid+1,R);
        return leftSum + rightSum + merge(arr,L,mid,R);

    }

    private static int merge(int[] arr,int L,int mid,int R){
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= R){
            if (arr[p1] < arr[p2]){
                res += arr[p1]*(R-p2+1);
                help[i++] = arr[p1++];
            }else {
                help[i++] = arr[p2++];
            }
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
        return res;
    }


}
