package m07.d19;

public class GetMax {


    /**
     * 获得数组中最大值
     * @param arr
     * @return
     */
    public static int getMax(int[] arr){
        return getMaxProcess(arr,0, arr.length-1);
    }

    /**
     * 获得下标L到R之间到最大值
     * @param arr
     * @param L
     * @param R
     * @return
     */
    private static int getMaxProcess(int[] arr,int L,int R){
        if (L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = getMaxProcess(arr,L,mid);
        int rightMax = getMaxProcess(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }
}



