package com.practise.techiedelight.arrays;

import java.util.*;
/*
https://techiedelight.com/practice/?problem=MaximumLengthSubarray
Given an integer array, find the maximum length contiguous subarray having a given sum.

Input : nums[] = [5, 6, -5, 5, 3, 5, 3, -2, 0], target = 8
Output: [-5, 5, 3, 5]
Explanation: The subarrays with sum 8 are [[-5, 5, 3, 5], [3, 5], [5, 3]]. The longest subarray is [-5, 5, 3, 5] having length 4.
Note: Since an input can contain several maximum length subarrays with given sum, the solution should return any one of the maximum length subarray.
*/
public class MaximumLengthSubArray {
    public static List<Integer> findMaxLenSubarray(List<Integer> nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int sumSoFar = 0;
        int startIndex =0;
        int endIndex = 0;
        int length=0;
        map.put(0, -1); // if total array sum is equal to target
        for(int i=0; i< nums.size(); i++){
            sumSoFar += nums.get(i);
            if(map.containsKey(sumSoFar-target)){
                int start = map.get(sumSoFar-target)+1;
                if((i-start+1) > length){
                    startIndex = start;
                    endIndex = i;
                    length = endIndex-startIndex +1;
                }
            }
            if(!map.containsKey(sumSoFar)){
                map.put(sumSoFar, i);
            }
        }
        List<Integer> result = new ArrayList<>();
        if(length > 0){
            for(int i=startIndex; i<=endIndex;i++){
                result.add(nums.get(i));
            }
        }
        return result;
    }
}
