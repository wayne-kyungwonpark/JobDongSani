package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _373_FindKPairsWithSmallestSums {
    public static void main(String[] args) {
//        List<List<Integer>> result = kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 4);
//        List<List<Integer>> result = kSmallestPairs(new int[]{1, 3, 6, 7}, new int[]{5, 6, 10}, 6);
//        List<List<Integer>> result = kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
//        List<List<Integer>> result = kSmallestPairs(new int[]{1}, new int[]{3, 5, 6, 7, 8, 100}, 4);
        List<List<Integer>> result = kSmallestPairs(new int[]{0,0,0,0,0,2,2,2,2}, new int[]{-3,22,35,56,76}, 22);
//        int[] nums1 = new int[10000];
//        int[] nums2 = new int[10000];
//        for (int i = 0; i < 10000; i++) {
//            nums1[i] = i + 1;
//            nums2[i] = i + 1;
//        }
//        List<List<Integer>> result = kSmallestPairs(nums1, nums2, 1000);
        for(List<Integer> elem : result){
            System.out.println(elem.get(0) + " " + elem.get(1));
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        int min = Math.min(k * k, nums1.length * nums2.length);
        int first = 0;
        int second = 0;
        if(nums1.length < k && nums2.length < k){
            first = nums1.length;
            second = nums2.length;
        }else if(nums1.length < k && nums2.length >= k){
            if(nums1.length * nums2.length > k * k){
                first = nums1.length;
                second = k;
            }else{
                first = nums1.length;
                second = nums2.length;
            }
        }else if(nums1.length >= k && nums2.length < k){
            if(nums1.length * nums2.length > k * k){
                first = k;
                second = nums2.length;
            }else{
                first = nums1.length;
                second = nums2.length;
            }
        }else{
            first = k;
            second = k;
        }

        ResultHeap[] list = new ResultHeap[min];
        int index = 0;
        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                if(i < nums1.length && j < nums2.length){
                    list[index] = new ResultHeap();
                    list[index].elem.add(nums1[i]);
                    list[index].elem.add(nums2[j]);
                    index++;
                }else{
                    break;
                }
            }
        }

        Arrays.sort(list);

        for (int i = 0; i < k; i++) {
            if(list.length <= i){
                break;
            }
            result.add(list[i].elem);
        }

        return result;
    }

    private static class ResultHeap implements Comparable<ResultHeap> {

        List<Integer> elem = new ArrayList<>();

        @Override
        public int compareTo(ResultHeap o) {
            int sum = this.elem.get(0) + this.elem.get(1);
            int oSum = o.elem.get(0) + o.elem.get(1);
            if(sum < oSum){
                return -1;
            }else if(sum > oSum){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
