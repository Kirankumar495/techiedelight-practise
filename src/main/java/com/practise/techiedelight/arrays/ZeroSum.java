package com.practise.techiedelight.arrays;

import java.util.HashMap;
import java.util.Map;

/*
https://techiedelight.com/practice/?problem=ZeroSum
Given an integer array, check if it contains a contiguous subarray having zero-sum.
Input : [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
Output: true
Explanation: The subarrays with zero-sum are

[3, 4, -7]
[4, -7, 3]
[-7, 3, 1, 3]
[3, 1, -4]
[3, 1, 3, 1, -4, -2, -2]
[3, 4, -7, 3, 1, 3, 1, -4, -2, -2]

Input : [4, -7, 1, 2, -1]
Output: false
Explanation: The subarray with zero-sum doesn't exist.
*/
public class ZeroSum {
    public static boolean hasZeroSumSubarray(int[] nums)
    {
        int sumSoFar = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            sumSoFar += nums[i];
            if(sumSoFar == 0){
                return true;
            }
            if(map.containsKey(sumSoFar)){
                return true;
            }
            map.put(sumSoFar, i);
        }
        return false;
    }
}
