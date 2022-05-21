package com.practise.techiedelight.arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given an unsorted integer array, find a pair with the given sum in it.
• Each input can have multiple solutions. The output should match with either one of them.
Input : nums[] = [8, 7, 2, 5, 3, 1], target = 10
Output: (8, 2) or (7, 3)
• The solution can return pair in any order. If no pair with the given sum exists, the solution should return null.
Input : nums[] = [5, 2, 6, 8, 1, 9], target = 12
Output: null

*/
public class TwoSum {
    public static void main(String[] args){
        int nums[] = {8, 7, 2, 5, 3, 1};
        int target = 10;
        int[] res = findPair(nums, target);
        System.out.print("number 1:" + res[0] + " number 2:" + res[1]);
    }

    public static int[] findPair(int[] nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i< nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                result[0] = temp;
                result[1] = nums[i];
                return result;
            } else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
