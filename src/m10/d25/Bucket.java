package m10.d25;

/**
 * 给数组,画直方图,组成的新装能装多少格水
 */
public class Bucket {


    public static int count1(int[] arr){
        int[] leftMaxIndex = new int[arr.length];
        leftMaxIndex[0] = -1;
        int rightMaxIndex = -1;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i >= rightMaxIndex){
                int i1 = rightMax(arr, i + 1);
                if (i1 == -1){
                    return ans;
                }
                rightMaxIndex = i1;
            }
            if (leftMaxIndex[i-1] == -1){
                leftMaxIndex[i] = i-1;
            }else {
                leftMaxIndex[i] = arr[leftMaxIndex[i-1]] > arr[i-1] ? leftMaxIndex[i-1] : i-1;
            }
            int min = Math.min(arr[rightMaxIndex],arr[leftMaxIndex[i]]);
            ans += min > arr[i] ? min - arr[i] : 0;
        }
        return ans;
    }

    private static int rightMax(int[] arr,int i){
        int max = -1;
        int index = -1;
        for (int j = i; j < arr.length; j++) {
            if(max < arr[j]){
                index = j;
                max = arr[j];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(count2(new int[]{3,1,2,5,2,4}));
    }


    public static int count2(int[] arr){
        if (arr == null || arr.length <= 2){
            return 0;
        }
        int leftIndex = 1;
        int rightIndex = arr.length - 2;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int ans = 0;
        while (leftIndex <= rightIndex){
            if (leftMax >= rightMax){
                ans += rightMax > arr[rightIndex] ? rightMax - arr[rightIndex] : 0;
                rightMax = Math.max(rightMax,arr[rightIndex--]);
            }else {
                ans += leftMax > arr[leftIndex] ? leftMax - arr[leftIndex] : 0;
                leftMax = Math.max(leftMax,arr[leftIndex++]);
            }
        }
        return ans;
    }


}
