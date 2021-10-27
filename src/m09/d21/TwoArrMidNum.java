package m09.d21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoArrMidNum {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();
        for (int i : nums1) {
            nums.add(i);
        }
        for (int i : nums2) {
            nums.add(i);
        }
        Collections.sort(nums);
        boolean odd = nums.size()%2 == 1;
        int mid = nums.size()/2;
        if (odd){
            return nums.get(mid+1);
        }else {
            return (nums.get(mid) + nums.get(mid+1))*1.0/2;
        }
    }
}
