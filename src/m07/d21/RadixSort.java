package m07.d21;

public class RadixSort {
    //基排序
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    private static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i=0,j=0;
        int[] bucket = new int[R-L+1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i],d);
                count[j]++;
            }
            for (i = R; i >= radix; i--) {
                j = getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i];
                count[j] --;
            }
            for (i=L,j=0;i<=R;i++,j++){
                arr[i] = bucket[j];
            }
        }
    }
    // d=1 -> 返回num个位数; d=2 -> 返回num十位数 ...
    private static int getDigit(int num,int d){
        int a = (int)Math.pow(10,d-1);
        return (num/a) % 10;
    }

    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        return countBits(max);
    }

    private static int countBits(int num){
        if (num == 0){
            return 1;
        }
        int res = 0;
        while (num != 0){
            num /= 10;
            res++;
        }
        return res;
    }
}
